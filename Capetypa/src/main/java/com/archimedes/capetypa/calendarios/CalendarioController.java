package com.archimedes.capetypa.calendarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/calendars")
public class CalendarioController {

	@Autowired
	private CalendarioRepository CalendarioRepository;

	// Lista todos os Calendarios válidos.
	@GetMapping
	public List<Calendario> getAll() {
		return CalendarioRepository.findAllValidCalendars();
	}

	// Lista um Calendario válido pelo Id.
	@GetMapping(path = "/{id}")
	public List<Calendario> getOne(@PathVariable Long id) {
		return CalendarioRepository.findCalendarById(id);
	}

	@GetMapping(path = "/ca_views/{limit}")
	public List<Calendario> getByViews(@PathVariable int limit) {
		return CalendarioRepository.findMostViewedCalendars(limit);
	}

	@PatchMapping(path = "/{id}", produces = "application/json")
	public String updateViews(@PathVariable Long id) {
		CalendarioRepository.updateViews(id);
		return "{\"status\": \"success\"}";
	}

	// Obtém os Calendarios do autor.
	// Observe que a rota contém 3 parâmetros numéricos:
	// {uid} → Id do autor do Calendario
	// {art} → Id do Calendario que será excluído da listagem
	// {lim} → Quantos Calendarios serão obtidos
	// Exemplo de rota: http://domain.api/articles/author?uid=1&art=2&lim=5
	@GetMapping(path = "/ca_author")
	public List<Calendario> getByAuthor(@RequestParam("uid") Long uid, @RequestParam("art") Long articleId,
			@RequestParam("lim") int limit) {
		return CalendarioRepository.findAllByAuthor(uid, articleId, limit);
	}

	// Busca por uma palavra ou termo nos campos "title", "resume" e "content".
	// As buascas são "case-insensitive". Por exemplo, para procurar por "Biscoito":
	// GET → http://domain.api/articles/find?q=Biscoito
	@GetMapping(path = "/find")
	public List<Calendario> findCalendarByWord(@RequestParam("q") String q) {
		return CalendarioRepository.findByWord(q);
	}

}
