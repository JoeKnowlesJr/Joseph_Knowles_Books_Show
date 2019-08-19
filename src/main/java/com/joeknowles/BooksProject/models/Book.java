package com.joeknowles.BooksProject.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, max = 200)
	private String title;
	@Size(min = 5, max = 200)
	private String description;
	@Size(min = 3, max = 40)
	private String language;
	@Min(100)
	private Integer numberOfPages;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated;
	
	public Book() {}
	
	public Book(String t, String d, String l, Integer n) {
		title = t;
		description = d;
		language = l;
		numberOfPages = n;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getLanguage() { return language; }
	public void setLanguage(String language) { this.language = language; }
	public Integer getNumberOfPages() { return numberOfPages; }
	public void setNumberOfPages(Integer numberOfPages) { this.numberOfPages = numberOfPages; }
	public Date getCreated() { return created; }
	public void setCreated(Date created) { this.created = created; }
	public Date getUpdated() { return updated; }
	public void setUpdated(Date updated) { this.updated = updated; }

	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }
}
