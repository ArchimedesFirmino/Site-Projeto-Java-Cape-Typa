package com.archimedes.capetypa.cronograma;

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
@RequestMapping("/cronograma")
public class CronogramaController {

	@Autowired
	private CronogramaRepository CronogramaRepository;

	// Lista todos os Cronogramas válidos.
	@GetMapping
	public List<Cronograma> getAll() {
		return CronogramaRepository.findAllValidCalendars();
	}

	// Lista um Cronograma válido pelo Id.
	@GetMapping(path = "/{id}")
	public List<Cronograma> getOne(@PathVariable Long id) {
		return CronogramaRepository.findCalendarById(id);
	}

	@GetMapping(path = "/views/{limit}")
	public List<Cronograma> getByViews(@PathVariable int limit) {
		return CronogramaRepository.findMostViewedCalendars(limit);
	}

	@PatchMapping(path = "/{id}", produces = "application/json")
	public String updateViews(@PathVariable Long id) {
		CronogramaRepository.updateViews(id);
		return "{\"status\": \"success\"}";
	}

	// Obtém os Cronogramas do autor.
	// Observe que a rota contém 3 parâmetros numéricos:
	// {uid} → Id do autor do Cronograma
	// {art} → Id do Cronograma que será excluído da listagem
	// {lim} → Quantos Cronogramas serão obtidos
	// Exemplo de rota: http://domain.api/articles/author?uid=1&art=2&lim=5
	@GetMapping(path = "/author")
	public List<Cronograma> getByAuthor(@RequestParam("uid") Long uid, @RequestParam("art") Long articleId,
			@RequestParam("lim") int limit) {
		return CronogramaRepository.findAllByAuthor(uid, articleId, limit);
	}

	// Busca por uma palavra ou termo nos campos "title", "resume" e "content".
	// As buascas são "case-insensitive". Por exemplo, para procurar por "Biscoito":
	// GET → http://domain.api/articles/find?q=Biscoito
	@GetMapping(path = "/find")
	public List<Cronograma> findArticleByWord(@RequestParam("q") String q) {
		return CronogramaRepository.findByWord(q);
	}

}
