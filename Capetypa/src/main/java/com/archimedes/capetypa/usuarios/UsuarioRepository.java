package com.archimedes.capetypa.usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	@Query(value = "SELECT * FROM usuario WHERE us_status = 'on' AND us_id = :uid ORDER BY us_name", nativeQuery = true)
	List<Usuario> findByUser(@Param("uid") Long uid);
}