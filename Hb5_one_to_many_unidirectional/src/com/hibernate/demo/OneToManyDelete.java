package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetail;
import com.hibernate.entity.CourseSection;
import com.hibernate.entity.Topic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDelete {

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
        	System.out.println("-------------DELETE----------------");
        	int courseID = 10;

            //Comenzar acción
            System.out.println("Realizando accion");
            session.beginTransaction();

            //Recoger objeto en session
            System.out.println("Recoger course como objeto");
            CourseSection demoCourse = session.get(CourseSection.class, courseID);
            session.delete(demoCourse);
            
            
            //Acabar acción
            session.getTransaction().commit();
            
        } finally {
            factory.close();
        }
    }

}
