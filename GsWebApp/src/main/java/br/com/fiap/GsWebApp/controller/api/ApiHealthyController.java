package br.com.fiap.GsWebApp.controller.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.GsWebApp.model.Healthy;
import br.com.fiap.GsWebApp.repository.GsRepository;

@RestController
@RequestMapping("/api/healthy")
public class ApiHealthyController {
	
	@Autowired
	private GsRepository repository;
	
	@GetMapping
	public Page<Healthy> index(
			@RequestParam(required = false) String title,
			@PageableDefault Pageable pageable
			) {
		
		if (title == null) 
			return repository.findAll(pageable);
		
		return repository
				.findByTitleLike("%" + title + "%" , pageable);
	}
	
	@PostMapping
	public ResponseEntity<Healthy> create(
			@RequestBody Healthy healthy,
			UriComponentsBuilder uriBuilder
			) {
		repository.save(healthy);
		
		URI uri = uriBuilder
				.path("api/healthy/{id}")
				.buildAndExpand(healthy.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(healthy);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Healthy>  get(@PathVariable Long id) {
		Optional<Healthy> healthy = repository.findById(id);
		if (healthy.isPresent()) 
			return ResponseEntity.ok( healthy.get() ) ;
		
		return ResponseEntity.notFound().build();
		
		
	}


}