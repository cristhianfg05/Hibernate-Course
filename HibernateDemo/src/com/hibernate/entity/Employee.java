package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int emp_id;
	
	@Column(name="first_name")
	private String emp_first_name;
	
	@Column(name="last_name")
	private String emp_last_name;
	
	@Column(name="email")
	private String emp_email;

	public Employee() {}
	
	public Employee(String emp_first_name, String emp_last_name, String emp_email) {
		super();
		this.emp_first_name = emp_first_name;
		this.emp_last_name = emp_last_name;
		this.emp_email = emp_email;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_first_name() {
		return emp_first_name;
	}

	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}

	public String getEmp_last_name() {
		return emp_last_name;
	}

	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_first_name=" + emp_first_name + ", emp_last_name=" + emp_last_name
				+ ", emp_email=" + emp_email + "]";
	}
	
	
	
	
}
