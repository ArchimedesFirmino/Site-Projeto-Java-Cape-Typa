package com.archimedes.capetypa.calendarios;

import com.archimedes.capetypa.usuarios.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Calendario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long ca_id;

	@Column(length = 127)
	private String ca_date;

	@ManyToOne
	@JoinColumn(name = "ca_author")
	private Usuario ca_author;
	
	@Column(length = 127)
	private String ca_title;
	
	@Column(length = 15)
	private String ca_status;
	
	@Column(length = 255)
	private String ca_content;
	
	@Column(length = 127)
	private String ca_institute;
	
	@Column
	private Long ca_views;

	public Long getCa_id() {
		return ca_id;
	}

	public void setCa_id(Long ca_id) {
		this.ca_id = ca_id;
	}

	public String getCa_date() {
		return ca_date;
	}

	public void setCa_date(String ca_date) {
		this.ca_date = ca_date;
	}

	public Usuario getCa_author() {
		return ca_author;
	}

	public void setCa_author(Usuario ca_author) {
		this.ca_author = ca_author;
	}

	public String getCa_title() {
		return ca_title;
	}

	public void setCa_title(String ca_title) {
		this.ca_title = ca_title;
	}

	public String getCa_status() {
		return ca_status;
	}

	public void setCa_status(String ca_status) {
		this.ca_status = ca_status;
	}

	public String getCa_content() {
		return ca_content;
	}

	public void setCa_content(String ca_content) {
		this.ca_content = ca_content;
	}

	public String getCa_institute() {
		return ca_institute;
	}

	public void setCa_institute(String ca_institute) {
		this.ca_institute = ca_institute;
	}

	public Long getCa_views() {
		return ca_views;
	}

	public void setCa_views(Long ca_views) {
		this.ca_views = ca_views;
	}

	
}
