package com.archimedes.capetypa.artigos;

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
@RequestMapping("/articles")
public class ArtigoController {

	@Autowired
	private ArtigoRepository artigoRepository;

	// Lista todos os artigos válidos.
	@GetMapping
	public List<Artigo> getAll() {
		return artigoRepository.findAllValidArticles();
	}

	// Lista um artigo válido pelo Id.
	@GetMapping(path = "/{id}")
	public List<Artigo> getOne(@PathVariable Long id) {
		return artigoRepository.findArticleById(id);
	}

	@GetMapping(path = "/views/{limit}")
	public List<Artigo> getByViews(@PathVariable int limit) {
		return artigoRepository.findMostViewedArticles(limit);
	}

	@PatchMapping(path = "/{id}", produces = "application/json")
	public String updateViews(@PathVariable Long id) {
		artigoRepository.updateViews(id);
		return "{\"status\": \"success\"}";
	}

	// Obtém os artigos do autor.
	// Observe que a rota contém 3 parâmetros numéricos:
	// {uid} → Id do autor do artigo
	// {art} → Id do artigo que será excluído da listagem
	// {lim} → Quantos artigos serão obtidos
	// Exemplo de rota: http://domain.api/articles/author?uid=1&art=2&lim=5
	@GetMapping(path = "/author")
	public List<Artigo> getByAuthor(@RequestParam("uid") Long uid, @RequestParam("art") Long articleId,
			@RequestParam("lim") int limit) {
		return artigoRepository.findAllByAuthor(uid, articleId, limit);
	}

	// Busca por uma palavra ou termo nos campos "title", "resume" e "content".
	// As buascas são "case-insensitive". Por exemplo, para procurar por "Biscoito":
	// GET → http://domain.api/articles/find?q=Biscoito
	@GetMapping(path = "/find")
	public List<Artigo> findArticleByWord(@RequestParam("q") String q) {
		return artigoRepository.findByWord(q);
	}

}
