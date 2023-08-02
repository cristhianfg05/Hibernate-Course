package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneCreate {

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
            System.out.println("Creando java object");
            Course demoCourse = new Course("Java course", "www.javarocks.com");
            CourseDetail demoCourseDetails = new CourseDetail("20€","YT Cfg");
            
            Course demoCourse1 = new Course("Laravel course", "www.laravelrocks.com");
            CourseDetail demoCourseDetail1 = new CourseDetail("20€","YT Cfg");
            
            Course demoCourse2 = new Course("React course", "www.reactrocks.com");
            CourseDetail demoCourseDetail2 = new CourseDetail("20€","YT Cfg");
            
            //Asociar objetos
            demoCourse.setCourseDetail(demoCourseDetails);
            demoCourse1.setCourseDetail(demoCourseDetail1);
            demoCourse2.setCourseDetail(demoCourseDetail2);

            //Comenzar acción
            System.out.println("Realizando accion");
            session.beginTransaction();

            //Guardar objeto en session
            //Solamente guardando course se guardan ambos objetos por el Cascading aplicado en la clase course
            System.out.println("Guardando course como objeto");
            session.save(demoCourse);
            session.save(demoCourse1);
            session.save(demoCourse2);

            //Acabar acción
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

}
