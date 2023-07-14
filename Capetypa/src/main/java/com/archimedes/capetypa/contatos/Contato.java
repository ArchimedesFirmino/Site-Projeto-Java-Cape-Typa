package com.archimedes.capetypa.contatos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long cnt_id;

	@Column(length = 127)
	private String cnt_date;

	@Column(length = 255)
	private String cnt_name;
	
	@Column(length = 255)
	private String cnt_subject;
	
	@Column(length = 255)
	private String cnt_email;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String cnt_message;
	
	@Column(length = 15)
	private String cnt_status;

	public Long getCnt_id() {
		return cnt_id;
	}

	public void setCnt_id(Long cnt_id) {
		this.cnt_id = cnt_id;
	}

	public String getCnt_date() {
		return cnt_date;
	}

	public void setCnt_date(String cnt_date) {
		this.cnt_date = cnt_date;
	}

	public String getCnt_name() {
		return cnt_name;
	}

	public void setCnt_name(String cnt_name) {
		this.cnt_name = cnt_name;
	}

	public String getCnt_subject() {
		return cnt_subject;
	}

	public void setCnt_subject(String cnt_subject) {
		this.cnt_subject = cnt_subject;
	}

	public String getCnt_email() {
		return cnt_email;
	}

	public void setCnt_email(String cnt_email) {
		this.cnt_email = cnt_email;
	}

	public String getCnt_message() {
		return cnt_message;
	}

	public void setCnt_message(String cnt_message) {
		this.cnt_message = cnt_message;
	}

	public String getCnt_status() {
		return cnt_status;
	}

	public void setCnt_status(String cnt_status) {
		this.cnt_status = cnt_status;
	}

	
	
	
}
