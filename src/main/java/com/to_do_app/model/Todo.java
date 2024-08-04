package com.to_do_app.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@NotBlank(message = "description should not blank")
	private String description;
	private boolean isDone;
	private Date targetDate;
	private String title;
	
	public Todo() {
		
	}
	
	public Todo(Long id, String description, boolean isDone, Date targetDate, String title) {
		super();
		this.id = id;
		this.description = description;
		this.isDone = isDone;
		this.targetDate = targetDate;
		this.title = title;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public Long getId() {
		return id;
	}
	
	
	public void setDescription(String desc) {
		this.description=desc;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setTargetDate(Date date) {
		this.targetDate=date;
	}
	
	public Date getTargetDate() {
		return targetDate;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getTitle() {
		return title;
	}
}
