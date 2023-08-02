package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDelete {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(CourseDetail.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        //realizar crud operations
        try {
            //Create java object
        	System.out.println("-------------DELETE----------------");
        	int courseID = 5;

            //Comenzar acción
            System.out.println("Realizando accion");
            session.beginTransaction();

            //Recoger objeto en session
            System.out.println("Recoger course como objeto");
            CourseDetail demoCourse = session.get(CourseDetail.class, courseID);
            
            //Delete course
            //Tanto si borramos un course como un courseDetails borrarà ambos siempre y cuando tengamos el OneToOne si, si es el 2 esta desenlazado
            
            //Con esto rompemos el mapping bidireccional
            demoCourse.getCourse().setCourseDetail(null);
            
            if (demoCourse != null) {
            	System.out.println("course DELETE");
                session.delete(demoCourse);
            }else {
            	System.out.println("El curso no existe");
            }
            
            
            //Delete all/some courses
            //System.out.println("-------------DELETE ALL----------------");
            //session.createQuery("delete from Course where id='2' or id='4'").executeUpdate();
            
            //Acabar acción
            session.getTransaction().commit();
            
        } finally {
            factory.close();
        }
    }

}
