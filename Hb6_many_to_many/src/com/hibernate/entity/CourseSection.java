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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course_section")
public class CourseSection {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	//Mapping many to one (es many to one porque hay varias course sections en course)
	@ManyToOne(cascade= {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
	})
	@JoinColumn(name="course_id")
	private Course course;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="course_section_id")
	private List<Topic> topics;
	
	public CourseSection() {
	}

	//El constructor de las clases se hace solo con las variables de la clase, sin identificador y sin relación
	public CourseSection(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "CourseSection [id=" + id + ", title=" + title + "]";
	}
	
	
	//Añadimios metodo para el mapeo unidireccional
	public void add(Topic topic) {
		if (topics == null) {
			topics = new ArrayList<>();
		}
		topics.add(topic);
	}
}
