package com.hibernate.demo;

import com.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

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
        	System.out.println("-------------DELETE----------------");
        	int empId = 1;
            System.out.println(empId);

            //Comenzar acción
            System.out.println("Realizando accion");
            session.beginTransaction();

            //Recoger objeto en session
            System.out.println("Recoger empleado como objeto");
            Employee empObj = session.get(Employee.class, empId);
            
            //Delete object
            System.out.println("Empleado DELETE");
            session.delete(empObj);
            
            //Delete all/some employee
            System.out.println("-------------DELETE ALL----------------");
            session.createQuery("delete from Employee where id='2' or id='4'").executeUpdate();
            
            //Acabar acción
            session.getTransaction().commit();
            
        } finally {
            factory.close();
        }
    }

}
