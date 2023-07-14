package com.archimedes.capetypa.artigos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
	// Constante de busca por artigos.
	final String DEFAULTPARAMS = "date <= NOW() AND status = 'on'";

	// Obtém todos os artigos ordenados pela data decrescente.
	@Query(value = "SELECT * FROM artigo WHERE " + DEFAULTPARAMS + " ORDER BY date DESC", nativeQuery = true)
	List<Artigo> findAllValidArticles();

	// Obtém os artigos mais visualizados decrescente.
	@Query(value = "SELECT * FROM artigo WHERE " + DEFAULTPARAMS
			+ " ORDER BY ar_views DESC LIMIT :limit", nativeQuery = true)
	List<Artigo> findMostViewedArticles(@Param("limit") int limit);

	// Obtém um artigo pelo Id.
	@Query(value = "SELECT * FROM artigo WHERE " + DEFAULTPARAMS + " AND ar_id = :id", nativeQuery = true)
	List<Artigo> findArticleById(@Param("id") Long id);

	// Obtém os artigos de um autor, exceto o artigo com "id", em ordem aleatória.
	@Query(value = "SELECT * FROM artigo WHERE " + DEFAULTPARAMS
			+ " AND ar_author = :uid AND id != :ar_Id ORDER BY RAND() LIMIT :limit", nativeQuery = true)
	List<Artigo> findAllByAuthor(@Param("uid") Long uid, @Param("articleId") Long articleId,
			@Param("limit") int limit);

	// Verifica se um artigo existe ou é ativo.
	@Query(value = "SELECT CASE WHEN COUNT(id) > 0 THEN true ELSE false END FROM artigo WHERE " + DEFAULTPARAMS
			+ " AND ar_id = :id", nativeQuery = true)
	boolean existsById(@Param("id") Long id);

	// Atualiza a quantidade de views do artigo pelo Id.
	@Modifying
	@Query(value = "UPDATE artigos SET ar_views = ar_views + 1 WHERE " + DEFAULTPARAMS + " AND ar_id = :id", nativeQuery = true)
	void updateViews(@Param("id") Long id);

	// Busca por uma palavra ou termo nos campos "title", "resume" e "content".
	@Query(value = "SELECT * FROM artigo WHERE " + DEFAULTPARAMS
			+ " AND UPPER(ar_title) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(ar_resume) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(ar_content) LIKE UPPER(CONCAT('%', :query, '%'))", nativeQuery = true)
	List<Artigo> findByWord(@Param("query") String query);
}

