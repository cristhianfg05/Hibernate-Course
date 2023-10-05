package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	
	//Add course section
	//Mapping one to many (es many to one porque hay varias course sections en course)
//	@OneToMany(fetch=FetchType.EAGER, mappedBy="course", cascade= {
//			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
//	})
	//Si hacemos lazy loading será lo siguiente
	@OneToMany(fetch=FetchType.LAZY, mappedBy="course", cascade= {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
	})
	private List<CourseSection> sections;
	
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

	
	
	public List<CourseSection> getSections() {
		return sections;
	}

	public void setSections(List<CourseSection> sections) {
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseWebsite=" + courseWebsite
				+ ", courseDetail=" + courseDetail + "]";
	}

	
	//Añadir metodo para ayudar al mapping bidireccional
	public void add(CourseSection section) {
		if(sections == null) {
			sections = new ArrayList<>();
		}
		sections.add(section);
		section.setCourse(this);
	}
	

	
	
	
}
