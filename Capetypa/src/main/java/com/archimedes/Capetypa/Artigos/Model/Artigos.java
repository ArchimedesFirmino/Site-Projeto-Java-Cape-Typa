package com.archimedes.Capetypa.Artigos.Model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public @interface Artigos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;

	@Column(length = 127, nullable = false)
	private String date;

	@Column(nullable = false)
	private Long author;
	
	@Column(length = 127, nullable = false)
	private String title;
	
	@Column(length = 15, nullable = false)
	private String status;

	@Column(length = 255)
	private String thumbnail;
	
	@Column(length = 127)
	private String resume;
	
	@Lob
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

}
