package com.archimedes.capetypa.artigos;

import com.archimedes.capetypa.usuarios.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Artigo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long ar_id;

	@Column(length = 127)
	private String ar_date;

	@ManyToOne
	@JoinColumn(name = "ar_author")
	private Usuario ar_author;

	@Column(length = 127)
	private String ar_title;

	@Column(length = 15)
	private String ar_status;

	@Column(length = 255)
	private String ar_thumbnail;

	@Column(length = 127)
	private String ar_resume;

	@Column
	private Long ar_views;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String ar_content;

	public Long getAr_id() {
		return ar_id;
	}

	public void setAr_id(Long ar_id) {
		this.ar_id = ar_id;
	}

	public String getAr_date() {
		return ar_date;
	}

	public void setAr_date(String ar_date) {
		this.ar_date = ar_date;
	}

	public Usuario getAr_author() {
		return ar_author;
	}

	public void setAr_author(Usuario ar_author) {
		this.ar_author = ar_author;
	}

	public String getAr_title() {
		return ar_title;
	}

	public void setAr_title(String ar_title) {
		this.ar_title = ar_title;
	}

	public String getAr_status() {
		return ar_status;
	}

	public void setAr_status(String ar_status) {
		this.ar_status = ar_status;
	}

	public String getAr_thumbnail() {
		return ar_thumbnail;
	}

	public void setAr_thumbnail(String ar_thumbnail) {
		this.ar_thumbnail = ar_thumbnail;
	}

	public String getAr_resume() {
		return ar_resume;
	}

	public void setAr_resume(String ar_resume) {
		this.ar_resume = ar_resume;
	}

	public Long getAr_views() {
		return ar_views;
	}

	public void setAr_views(Long ar_views) {
		this.ar_views = ar_views;
	}

	public String getAr_content() {
		return ar_content;
	}

	public void setAr_content(String ar_content) {
		this.ar_content = ar_content;
	}

}
