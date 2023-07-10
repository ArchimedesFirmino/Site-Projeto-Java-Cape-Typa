package com.archimedes.capetypa.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/users/social")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/{userId}")
	public List<Usuario> getSocial(@PathVariable Long userId) {
		return repository.findByUser(userId);
	}

}