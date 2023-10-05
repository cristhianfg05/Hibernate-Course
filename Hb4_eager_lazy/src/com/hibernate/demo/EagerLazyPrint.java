package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetail;
import com.hibernate.entity.CourseSection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyPrint {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(CourseDetail.class)
                .addAnnotatedClass(CourseSection.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        //realizar crud operations
        try {
            //Create java object
        	System.out.println("-------------PRINT----------------");
        	int courseID = 1;

            //Comenzar acción
            System.out.println("Demo: Realizando accion");
            session.beginTransaction();

            //Recoger objeto en session
            System.out.println("Demo: Recoger course como objeto");
            Course course = session.get(Course.class, courseID);
            
            System.out.println("Demo: Course: "+course);
            
            System.out.println("Demo: Course sections: "+course.getSections());
            
            //Acabar acción
            session.getTransaction().commit();
            System.out.println("Demo: Acabado");
        
        }	catch(Exception e){
        	System.out.println("Null pointer "+e.getMessage());
        } 	finally {
        	session.close();
            factory.close();
        }
    }

}
