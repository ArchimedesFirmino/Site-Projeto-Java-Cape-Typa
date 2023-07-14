package com.archimedes.capetypa.calendarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
	// Constante de busca por Calendarios.
	final String DEFAULTPARAMS = "ca_date <= NOW() AND ca_status = 'on'";

	// Obtém todos os Calendarios ordenados pela data decrescente.
	@Query(value = "SELECT * FROM Calendario WHERE " + DEFAULTPARAMS + " ORDER BY ca_date DESC", nativeQuery = true)
	List<Calendario> findAllValidCalendars();
	
	// Obtém os Calendarios mais visualizados decrescente.
	@Query(value = "SELECT * FROM Calendario WHERE " + DEFAULTPARAMS
			+ " ORDER BY ca_views DESC LIMIT :limit", nativeQuery = true)
	List<Calendario> findMostViewedCalendars(@Param("limit") int limit);

	// Obtém um Calendario pelo Id.
	@Query(value = "SELECT * FROM Calendario WHERE " + DEFAULTPARAMS + " AND ca_id = :id", nativeQuery = true)
	List<Calendario> findCalendarById(@Param("id") Long id);

	// Obtém os Calendarios de um autor, exceto o Calendario com "id", em ordem aleatória.
	@Query(value = "SELECT * FROM Calendario WHERE " + DEFAULTPARAMS
			+ " AND ca_author = :uid AND ca_id != :articleId ORDER BY RAND() LIMIT :limit", nativeQuery = true)
	List<Calendario> findAllByAuthor(@Param("uid") Long uid, @Param("articleId") Long articleId,
			@Param("limit") int limit);

	// Verifica se um Calendario existe ou é ativo.
	@Query(value = "SELECT CASE WHEN COUNT(ca_id) > 0 THEN true ELSE false END FROM Calendario WHERE " + DEFAULTPARAMS
			+ " AND ca_id = :id", nativeQuery = true)
	boolean existsById(@Param("id") Long id);

	// Atualiza a quantidade de views do Calendario pelo Id.
	@Modifying
	@Query(value = "UPDATE Calendarios SET ca_views = ca_views + 1 WHERE " + DEFAULTPARAMS + " AND ca_id = :id", nativeQuery = true)
	void updateViews(@Param("id") Long id);

	// Busca por uma palavra ou termo nos campos "title", "resume" e "content".
	@Query(value = "SELECT * FROM Calendario WHERE " + DEFAULTPARAMS
			+ " AND UPPER(ca_title) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(ca_institute) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(ca_content) LIKE UPPER(CONCAT('%', :query, '%'))", nativeQuery = true)
	List<Calendario> findByWord(@Param("query") String query);
}
