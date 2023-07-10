package com.archimedes.capetypa.artigos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Artigo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(length = 127)
	private String date;

	@Column(nullable = false)
	private Long author;

	@Column(length = 127)
	private String title;

	@Column(length = 15)
	private String status;

	@Column(length = 255)
	private String thumbnail;

	@Column(length = 127)
	private String resume;

	@Column
	private Long views;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

}
