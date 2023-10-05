package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Anotamos la clase como entidad de la base de datos
@Entity
@Table(name="topic")
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="topic_name")
	private String topicName;

	
	public Topic() {}


	public Topic(String topicName) {
		super();
		this.topicName = topicName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTopicName() {
		return topicName;
	}


	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}


	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicName=" + topicName + "]";
	}
	
	
}
