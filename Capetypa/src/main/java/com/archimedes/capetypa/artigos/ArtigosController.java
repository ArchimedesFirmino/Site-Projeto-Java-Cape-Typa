package com.archimedes.capetypa.artigos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/artigos")
public class ArtigosController {

	@Autowired
	private ArtigosRepository artigosRepository;

	@GetMapping
	public List<Artigos> getAll() {

		// O método "findAll()" do JPA retorna todos os registros em uma lista.
		return artigosRepository.findAll();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public String getOne(@PathVariable Long id) throws JsonProcessingException {

		// Se o registro com o Id existe.
		if (artigosRepository.existsById(id)) {

			// ObjectMapper tenta converter um objeto para JSON.
			ObjectMapper mapper = new ObjectMapper();

			// Obtém o registro pelo Id e armazena no objeto "Artigos".
			Artigos artigos = artigosRepository.findById(id).get();

			// Retorna "Artigos" convertido para JSON (String → JSON).
			return mapper.writeValueAsString(artigos);
		}

		// Se o registro não existe, retorna o JSON.
		return "{ \"status\" : \"not found\" }";

	}

	
	

}
