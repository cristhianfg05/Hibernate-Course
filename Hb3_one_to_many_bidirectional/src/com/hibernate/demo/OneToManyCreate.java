package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetail;
import com.hibernate.entity.CourseSection;

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
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        //realizar crud operations
        try {
            //Create java object
            System.out.println("Creando java object");
//            Course course = new Course("Java hibernate","java.com.es");
//            CourseDetail courseDetail = new CourseDetail("20€","cfg");
//            Course demoCourse = new Course("Java course", "www.javarocks.com");
//            CourseDetail demoCourseDetails = new CourseDetail("20€","YT Cfg");
//            
//            Course demoCourse1 = new Course("Laravel course", "www.laravelrocks.com");
//            CourseDetail demoCourseDetail1 = new CourseDetail("20€","YT Cfg");
//            
//            Course demoCourse2 = new Course("React course", "www.reactrocks.com");
//            CourseDetail demoCourseDetail2 = new CourseDetail("20€","YT Cfg");
            
            //Asociar objetos
//            course.setCourseDetail(courseDetail);
            System.out.println("Realizando accion");
            session.beginTransaction();
            //Vamos a añadir sections
            //1- Recogemos el curso en el que van las sections enganchadas
            int id = 1;
            Course course = session.get(Course.class, id);
            
            //2- Creamos los objetos courseSection
            CourseSection section1 = new CourseSection("Introduction");
            CourseSection section2 = new CourseSection("Setup");
            CourseSection section3 = new CourseSection("Starting");
            
            //3- los enlazamos con el metodo auxiliar add
            course.add(section1);
            course.add(section2);
            course.add(section3);
            
            //Comenzar acción
            

            //Guardar objeto en session
            //Solamente guardando course se guardan ambos objetos por el Cascading aplicado en la clase course
            System.out.println("Guardando course como objeto");
//          session.save(course);
            session.save(section1);
            session.save(section2);
            session.save(section3);


            //Acabar acción
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

}
