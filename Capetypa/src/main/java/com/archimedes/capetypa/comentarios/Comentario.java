package com.archimedes.capetypa.comentarios;

import com.archimedes.capetypa.artigos.Artigo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long cm_id;
	private String cm_date;
	private String fb_uid;
	private String fb_name;
	private String fb_photo;
	private String fb_email;
	@ManyToOne
	@JoinColumn(name = "cm_article")
	private Artigo cm_article;
	private String cm_comment;
	private String cm_status;
	public Long getCm_id() {
		return cm_id;
	}
	public void setCm_id(Long cm_id) {
		this.cm_id = cm_id;
	}
	public String getCm_date() {
		return cm_date;
	}
	public void setCm_date(String cm_date) {
		this.cm_date = cm_date;
	}
	public String getFb_uid() {
		return fb_uid;
	}
	public void setFb_uid(String fb_uid) {
		this.fb_uid = fb_uid;
	}
	public String getFb_name() {
		return fb_name;
	}
	public void setFb_name(String fb_name) {
		this.fb_name = fb_name;
	}
	public String getFb_photo() {
		return fb_photo;
	}
	public void setFb_photo(String fb_photo) {
		this.fb_photo = fb_photo;
	}
	public String getFb_email() {
		return fb_email;
	}
	public void setFb_email(String fb_email) {
		this.fb_email = fb_email;
	}
	public Artigo getCm_article() {
		return cm_article;
	}
	public void setCm_article(Artigo cm_article) {
		this.cm_article = cm_article;
	}
	public String getCm_comment() {
		return cm_comment;
	}
	public void setCm_comment(String cm_comment) {
		this.cm_comment = cm_comment;
	}
	public String getCm_status() {
		return cm_status;
	}
	public void setCm_status(String cm_status) {
		this.cm_status = cm_status;
	}



}
