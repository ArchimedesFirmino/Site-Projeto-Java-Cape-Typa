package com.archimedes.capetypa.comentarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

	final String DEFAULTPARAMS = "cm_status = 'on'";

	// Lista os comentários mais recentes.
	@Query(value = "SELECT * FROM comentario WHERE " + DEFAULTPARAMS
			+ " ORDER BY cm_date DESC LIMIT :limit  ", nativeQuery = true)
	List<Comentario> findLastComments(@Param("limit") int limit);
	
	@Query(value = "SELECT * FROM comentario WHERE " + DEFAULTPARAMS + " AND cm_id = :id", nativeQuery = true)
	List<Comentario> findCommentById(@Param("id") Long id);


	// Pesquisa por comentários pelo autor, artigo e comentário.
	@Query(value = "SELECT * FROM comentario WHERE " + DEFAULTPARAMS
			+ " AND fb_uid = :uid AND cm_article.ar_id = :art AND cm_comment = :txt", nativeQuery = true)
	List<Comentario> findCommentsByAuthorArticleAndContent(@Param("uid") String uid, @Param("art") Long art,
			@Param("txt") String txt);

	// Salva um novo comentário.
	@Query(value = "SELECT * FROM comentario WHERE " + DEFAULTPARAMS
			+ " AND ar_id = :articleId ORDER BY cm_date DESC", nativeQuery = true)
	List<Comentario> findAllCommentByArticle(@Param("articleId") Long articleId);
	
	@Query(value = "SELECT * FROM comentario WHERE " + DEFAULTPARAMS, nativeQuery = true)
	List<Comentario> findAllComments();

}