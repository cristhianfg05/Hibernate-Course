package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetail;
import com.hibernate.entity.CourseSection;
import com.hibernate.entity.Student;
import com.hibernate.entity.Topic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyPrint {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(CourseDetail.class)
                .addAnnotatedClass(CourseSection.class)
                .addAnnotatedClass(Topic.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        //realizar crud operations
        try {
            //Create java object
        	System.out.println("-------------PRINT----------------");
        	int id = 1;

            //Comenzar acción
            System.out.println("Realizando accion");
            session.beginTransaction();

            //Recoger objeto en session
            System.out.println("Recoger course como objeto");
            Student st = session.get(Student.class, id);
            
            System.out.println("student: "+st);
            
            System.out.println("student courses: "+st.getCourses());
            
            //Acabar acción
            session.getTransaction().commit();
        
        }	catch(Exception e){
        	System.out.println("Null pointer "+e.getMessage());
        } 	finally {
        	session.close();
            factory.close();
        }
    }

}
