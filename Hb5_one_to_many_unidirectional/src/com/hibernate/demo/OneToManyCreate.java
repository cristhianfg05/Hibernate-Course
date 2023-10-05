package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetail;
import com.hibernate.entity.CourseSection;
import com.hibernate.entity.Topic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyCreate {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(CourseDetail.class)
                .addAnnotatedClass(CourseSection.class)
                .addAnnotatedClass(Topic.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        //realizar crud operations
        try {
            //Create java object
            System.out.println("Creando java object");
            CourseSection section = new CourseSection("Titulo");
            
            //Creamos topics
            Topic t1 = new Topic("Tit1");
            Topic t2 = new Topic("Tit2");
            Topic t3 = new Topic("Tit3");
            Topic t4 = new Topic("Tit4");
            
            //Add topics to section
            section.add(t1);
            section.add(t2);
            section.add(t3);
            section.add(t4);
            
            
            //Asociar objetos
            System.out.println("Realizando accion");
            session.beginTransaction();
          
            System.out.println("Section: "+section);
            System.out.println("Topicos: "+section.getTopics());
            
            System.out.println("Guardando courseSection como objeto");          
            session.save(section);

            //Acabar acción
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

}
