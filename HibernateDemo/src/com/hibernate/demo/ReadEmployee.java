package com.hibernate.demo;

import com.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployee {

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
        	System.out.println("-------------CREATE----------------");
            System.out.println("Creando java object");
            Employee empObj = new Employee("Esther", "Ruano Hortoneda", "Example@example.com");

            //Comenzar acción
            System.out.println("Realizando accion");
            session.beginTransaction();

            //Guardar objeto en session
            System.out.println("Guardando empleado como objeto");
            session.save(empObj);

            //Acabar acción
            session.getTransaction().commit();
            
            System.out.println("-------------READ----------------");
            System.out.println(empObj.getEmp_id());
            
            //Comenzar acción
            System.out.println("Realizando accion");
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Leer objeto a partir de clave primaria --> si no lo encuentra NULL
            System.out.println("Leer empleado");
            empObj = session.get(Employee.class, empObj.getEmp_id());
            System.out.println(empObj);

            //Acabar acción
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

}
