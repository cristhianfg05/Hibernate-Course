package com.connection.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestjdbcConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_list_of_employee";
		String userId = "hbemployee";
		String pass = "hbemployee";
		try {
			System.out.println("TEST CONECTION SQL");
			System.out.println(url);
			Connection c = DriverManager.getConnection(url,userId,pass);
			System.out.println("Funciona");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
