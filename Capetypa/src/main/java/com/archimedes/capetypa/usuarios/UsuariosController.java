package com.archimedes.capetypa.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private UsuariosRepository usuariosRepository;

	@GetMapping
	public List<Usuarios> getAll() {

		// O método "findAll()" do JPA retorna todos os registros em uma lista.
		return usuariosRepository.findAll();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public String getOne(@PathVariable Long id) throws JsonProcessingException {

		// Se o registro com o Id existe.
		if (usuariosRepository.existsById(id)) {

			// ObjectMapper tenta converter um objeto para JSON.
			ObjectMapper mapper = new ObjectMapper();

			// Obtém o registro pelo Id e armazena no objeto "usuarios".
			Usuarios usuarios = usuariosRepository.findById(id).get();

			// Retorna "usuarios" convertido para JSON (String → JSON).
			return mapper.writeValueAsString(usuarios);
		}

		// Se o registro não existe, retorna o JSON.
		return "{ \"status\" : \"not found\" }";

	}
}
