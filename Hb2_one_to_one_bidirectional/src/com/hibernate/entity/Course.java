package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_website")
	private String courseWebsite;
	
	//Para la relacion 1 a 1 en una base de datos
	//Un courseDetail no puede existir si no existe un curso
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="course_detail_id")
	private CourseDetail courseDetail;
	
	
	public Course() {}

	public Course(String courseName, String courseWebsite) {
		super();
		this.courseName = courseName;
		this.courseWebsite = courseWebsite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseWebsite() {
		return courseWebsite;
	}

	public void setCourseWebsite(String courseWebsite) {
		this.courseWebsite = courseWebsite;
	}

	
	
	public CourseDetail getCourseDetail() {
		return courseDetail;
	}

	public void setCourseDetail(CourseDetail courseDetail) {
		this.courseDetail = courseDetail;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseWebsite=" + courseWebsite
				+ ", courseDetail=" + courseDetail + "]";
	}

	

	
	
	
}
