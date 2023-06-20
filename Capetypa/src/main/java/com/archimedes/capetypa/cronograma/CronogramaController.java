package com.archimedes.capetypa.cronograma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/cronograma")
public class CronogramaController {
	@Autowired
	private CronogramaRepository cronogramaRepository;

	@GetMapping
	public List<Cronograma> getAll() {

		// O método "findAll()" do JPA retorna todos os registros em uma lista.
		return cronogramaRepository.findAll();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public String getOne(@PathVariable Long id) throws JsonProcessingException {

		// Se o registro com o Id existe.
		if (cronogramaRepository.existsById(id)) {

			// ObjectMapper tenta converter um objeto para JSON.
			ObjectMapper mapper = new ObjectMapper();

			// Obtém o registro pelo Id e armazena no objeto "Artigos".
			Cronograma cronograma = cronogramaRepository.findById(id).get();

			// Retorna "Artigos" convertido para JSON (String → JSON).
			return mapper.writeValueAsString(cronograma);
		}

		// Se o registro não existe, retorna o JSON.
		return "{ \"status\" : \"not found\" }";

	}

}
