package com.archimedes.capetypa.usuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long us_id;

	@Column(length = 127)
	private String us_name;

	@Column(length = 255)
	private String us_description;

	@Column(length = 127)
	private String us_birthday;

	@Column(length = 255)
	private String us_email;

	@Column(length = 63)
	private String us_password;

	@Column(length = 255)
	private String us_photo;

	@Column(length = 15)
	private String us_status;

	@Column(length = 15)
	private String us_type;

	public Long getUs_id() {
		return us_id;
	}

	public void setUs_id(Long us_id) {
		this.us_id = us_id;
	}

	public String getUs_name() {
		return us_name;
	}

	public void setUs_name(String us_name) {
		this.us_name = us_name;
	}

	public String getUs_description() {
		return us_description;
	}

	public void setUs_description(String us_description) {
		this.us_description = us_description;
	}

	public String getUs_birthday() {
		return us_birthday;
	}

	public void setUs_birthday(String us_birthday) {
		this.us_birthday = us_birthday;
	}

	public String getUs_email() {
		return us_email;
	}

	public void setUs_email(String us_email) {
		this.us_email = us_email;
	}

	public String getUs_password() {
		return us_password;
	}

	public void setUs_password(String us_password) {
		this.us_password = us_password;
	}

	public String getUs_photo() {
		return us_photo;
	}

	public void setUs_photo(String us_photo) {
		this.us_photo = us_photo;
	}

	public String getUs_status() {
		return us_status;
	}

	public void setUs_status(String us_status) {
		this.us_status = us_status;
	}

	public String getUs_type() {
		return us_type;
	}

	public void setUs_type(String us_type) {
		this.us_type = us_type;
	}


}