package com.hibernate.demo;

import com.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

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
        	System.out.println("-------------UPDATE----------------");
        	int empId = 1;
            System.out.println(empId);

            //Comenzar acción
            System.out.println("Realizando accion");
            session.beginTransaction();

            //Recoger objeto en session
            System.out.println("Recoger empleado como objeto");
            Employee empObj = session.get(Employee.class, empId);
            
            System.out.println("Empleado updateado");
            empObj.setEmp_first_name("Fernando");
            System.out.println(empObj);
            
            //update all employee
            System.out.println("-------------UPDATE ALL----------------");
            session.createQuery("update Employee set emp_email='cambiado@gmail.com'").executeUpdate();
            //Acabar acción
            session.getTransaction().commit();
            
        } finally {
            factory.close();
        }
    }

}
