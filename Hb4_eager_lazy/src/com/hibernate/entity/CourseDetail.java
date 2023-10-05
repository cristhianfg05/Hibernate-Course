package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="course_detail")
public class CourseDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="course_price")
	private String coursePrice;
	
	@Column(name="course_channel")
	private String courseChannel;
	
	//Añadimos nuevo atributo que referencie el curso
	//Add mapping
	// @OneToOne(mappedBy="courseDetail", cascade=CascadeType.ALL)  --> Con esto enlazamos CourseDetail a course (OneToOne 1)
	@OneToOne(mappedBy="courseDetail", cascade= {
			CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	//Con este nuevo "one to one" desenlazamos courseDetail de course (OneToOne 2)
	private Course course;
	
	public CourseDetail() {}

	public CourseDetail(String coursePrice, String courseChannel) {
		super();
		this.coursePrice = coursePrice;
		this.courseChannel = courseChannel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getCourseChannel() {
		return courseChannel;
	}

	public void setCourseChannel(String courseChannel) {
		this.courseChannel = courseChannel;
	}


	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseDetail [id=" + id + ", coursePrice=" + coursePrice + ", courseChannel=" + courseChannel + "]";
	}

	

	
	
	
	
	
}
