package br.com.fiap.GsWebApp.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.GsWebApp.model.Healthy;

public interface GsRepository extends JpaRepository<Healthy, Long> {
	
	Page<Healthy> findByTitleLike(String title, org.springframework.data.domain.Pageable pageable);

}
