package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetail;
import com.hibernate.entity.CourseSection;
import com.hibernate.entity.Student;
import com.hibernate.entity.Topic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyCreate2 {

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
        	
        	System.out.println("Realizando accion");
            session.beginTransaction();
            
//            //Create java object
//            System.out.println("Creando java object");
//            Course course = new Course("Prueba", "Website");
//            
//            //Asociar objetos
//            
//          
//          
//            System.out.println("Guardando course como objeto");
//            session.save(course);
//
//            //Creamos students para el curso
//            Student st1 = new Student("Cristhian", "Fajardo", "Example@gmail.com");
//            Student st2 = new Student("Cristhian2", "Fajardo", "Example@gmail.com");
//            Student st3 = new Student("Cristhian3", "Fajardo", "Example@gmail.com");
//            Student st4 = new Student("Cristhian4", "Fajardo", "Example@gmail.com");
//            
//            //Añadimos los estudiantes
//            course.addStudent(st1);
//            course.addStudent(st2);
//            course.addStudent(st3);
//            course.addStudent(st4);
//            
//            //Guardar students
//            System.out.println("Guardando student como objeto");
//            session.save(st1);
//            session.save(st2);
//            session.save(st3);
//            session.save(st4);
            
            
            //get student by id
            int id = 1;
            Student st = session.get(Student.class, id);
            
            System.out.println("Student: "+st);
            System.out.println("Cursos actuales: "+st.getCourses());
            
            //Create coruse
            Course c = new Course("Demo", "Test.com");
            Course c2 = new Course("Demo2", "Test2.com");
            Course c3 = new Course("Demo3", "Test3.com");
            Course c4 = new Course("Dem4", "Test4.com");
            //Add student to couses
            c.addStudent(st);
            c2.addStudent(st);
            c3.addStudent(st);
            c4.addStudent(st);
            
            //Save courses
            session.save(c);
            session.save(c2);
            session.save(c3);
            session.save(c4);
            
            //Acabar acción
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

}
