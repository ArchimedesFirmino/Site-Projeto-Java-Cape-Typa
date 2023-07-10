package com.archimedes.capetypa.contatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/contacts")
public class ContatoController {

	@Autowired
	private ContatoRepository repository;

	@PostMapping
	public Contato saveContact(@RequestBody Contato contact) {
		return repository.save(contact);
	}
}