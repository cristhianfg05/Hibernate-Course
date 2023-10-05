package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetail;
import com.hibernate.entity.CourseSection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchQueryPrint {

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
            
            //Add query
            Query<Course> query= session.createQuery("select c from Course c JOIN FETCH c.sections "
            		+"where c.id=:courseId", Course.class);
            
            //set parameters for query
            query.setParameter("courseId", courseID);
            
            //load course
            Course course = query.getSingleResult();
            System.out.println("Course: "+course);
            
            //Acabar acción
            session.getTransaction().commit();
            session.close();
            System.out.println("Demo: Course sections: "+course.getSections());
            System.out.println("Demo: Acabado");
            
        
        }	catch(Exception e){
        	System.out.println("Null pointer "+e.getMessage());
        } 	finally {
        	session.close();
            factory.close();
        }
    }

}
