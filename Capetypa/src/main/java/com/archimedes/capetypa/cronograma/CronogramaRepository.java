package com.archimedes.capetypa.cronograma;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CronogramaRepository extends JpaRepository<Cronograma, Long> {
	// Constante de busca por Cronogramas.
	final String DEFAULTPARAMS = "date <= NOW() AND status = 'on'";

	// Obtém todos os Cronogramas ordenados pela data decrescente.
	@Query(value = "SELECT * FROM Cronograma WHERE " + DEFAULTPARAMS + " ORDER BY date DESC", nativeQuery = true)
	List<Cronograma> findAllValidCalendars();

	// Obtém os Cronogramas mais visualizados decrescente.
	@Query(value = "SELECT * FROM Cronograma WHERE " + DEFAULTPARAMS
			+ " ORDER BY views DESC LIMIT :limit", nativeQuery = true)
	List<Cronograma> findMostViewedCalendars(@Param("limit") int limit);

	// Obtém um Cronograma pelo Id.
	@Query(value = "SELECT * FROM Cronograma WHERE " + DEFAULTPARAMS + " AND id = :id", nativeQuery = true)
	List<Cronograma> findCalendarById(@Param("id") Long id);

	// Obtém os Cronogramas de um autor, exceto o Cronograma com "id", em ordem aleatória.
	@Query(value = "SELECT * FROM Cronograma WHERE " + DEFAULTPARAMS
			+ " AND author = :uid AND id != :articleId ORDER BY RAND() LIMIT :limit", nativeQuery = true)
	List<Cronograma> findAllByAuthor(@Param("uid") Long uid, @Param("articleId") Long articleId,
			@Param("limit") int limit);

	// Verifica se um Cronograma existe ou é ativo.
	@Query(value = "SELECT CASE WHEN COUNT(id) > 0 THEN true ELSE false END FROM Cronograma WHERE " + DEFAULTPARAMS
			+ " AND id = :id", nativeQuery = true)
	boolean existsById(@Param("id") Long id);

	// Atualiza a quantidade de views do Cronograma pelo Id.
	@Modifying
	@Query(value = "UPDATE Cronogramas SET views = views + 1 WHERE " + DEFAULTPARAMS + " AND id = :id", nativeQuery = true)
	void updateViews(@Param("id") Long id);

	// Busca por uma palavra ou termo nos campos "title", "resume" e "content".
	@Query(value = "SELECT * FROM Cronograma WHERE " + DEFAULTPARAMS
			+ " AND UPPER(title) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(resume) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(content) LIKE UPPER(CONCAT('%', :query, '%'))", nativeQuery = true)
	List<Cronograma> findByWord(@Param("query") String query);
}
