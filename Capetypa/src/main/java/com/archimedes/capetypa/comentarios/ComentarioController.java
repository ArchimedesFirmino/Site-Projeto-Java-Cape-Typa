package com.archimedes.capetypa.comentarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class ComentarioController {

	@Autowired
	private ComentarioRepository repository;

	@GetMapping(path = "/last/{limit}")
	public List<Comentario> getLast(@PathVariable int limit) {
		return repository.findLastComments(limit);
	}

	@GetMapping(path = "/{cm_id}")
	public List<Comentario> getCommentById(@PathVariable Long id) {
		return repository.findCommentById(id);
	}
	@GetMapping
	public List<Comentario> getAllComments() {
		return repository.findAllComments();
	}
	
	// Busca por um comentário específico.
	// Exemplo:
	// GET → http://domínio.api/comments/find?uid=Q1W2E3R4T5Y6U7&art=2&txt=Comentário do usuário
	// Busca por comentários que contenham exatamente
	// Id do usuário = "Q1W2E3R4T5Y6U7" E
	// Id do artigo = 2 E
	// Texto do comentário = "Comentário do usuário"
	// Serve para evitar que um mesmo comentário seja enviado de forma repetida.
	@GetMapping(path = "/find")
	public List<Comentario> alreadyExists(@RequestParam("uid") String uid, @RequestParam("art") Long art,
			@RequestParam("txt") String txt) {
		return repository.findCommentsByAuthorArticleAndContent(uid, art, txt);
	}

	@PostMapping
	public Comentario saveComment(@RequestBody Comentario comment) {
		return repository.save(comment);
	}
}