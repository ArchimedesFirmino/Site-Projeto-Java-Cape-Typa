package com.archimedes.capetypa.comentarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private ComentarioRepository comentariosRepository;

	@GetMapping
	public List<Comentario> getAll() {

		// O método "findAll()" do JPA retorna todos os registros em uma lista.
		return comentariosRepository.findAll();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public String getOne(@PathVariable Long id) throws JsonProcessingException {

		// Se o registro com o Id existe.
		if (comentariosRepository.existsById(id)) {

			// ObjectMapper tenta converter um objeto para JSON.
			ObjectMapper mapper = new ObjectMapper();

			// Obtém o registro pelo Id e armazena no objeto "Artigos".
			Comentario comentarios = comentariosRepository.findById(id).get();

			// Retorna "Artigos" convertido para JSON (String → JSON).
			return mapper.writeValueAsString(comentarios);
		}

		// Se o registro não existe, retorna o JSON.
		return "{ \"status\" : \"not found\" }";
	}

	@PostMapping
	public Comentario post(@RequestBody Comentario comentarios) {

		// O método "save()" de JPA cria um novo registro
		// e armazena o objeto nele.
		return comentariosRepository.save(comentarios);
	}

}
