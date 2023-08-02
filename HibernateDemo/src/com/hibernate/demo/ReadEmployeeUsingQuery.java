package com.hibernate.demo;

import com.hibernate.entity.Employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployeeUsingQuery {

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
            

            //Comenzar acción
            System.out.println("Realizando accion");
            session.beginTransaction();
            
            //Query1 todos los empleados
            System.out.println("---------------QUERY 1--------------");
            List<Employee> employees = session.createQuery("from Employee").list();
            extractList(employees);
            
          //Query employees
            System.out.println("---------------QUERY 2--------------");
            employees = session.createQuery("from Employee e where e.emp_first_name='Cristhian'").list();
            extractList(employees);
            
            //Acabar acción
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

	private static void extractList(List<Employee> employees) {
		//Mostrar empleados
		System.out.println("ENTRO");
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
