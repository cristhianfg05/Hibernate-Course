package com.hibernate.demo;

import com.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        //realizar crud operations
        try {
            //Create java object
            System.out.println("Creando java object");
            Employee empObj = new Employee("Aitor", "Menta", "Example@example.com");

            //Comenzar acción
            System.out.println("Realizando accion");
            session.beginTransaction();

            //Guardar objeto en session
            System.out.println("Guardando empleado como objeto");
            session.save(empObj);

            //Acabar acción
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

}
