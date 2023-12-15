package com.cabeacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cabeacao.model.Tema;
import com.cabeacao.repository.TemaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*",allowedHeaders="*")//Duvida
public class TemaController {
	@Autowired//Inversão de dependencia
	private TemaRepository temaRepository;
	
	@GetMapping// listar todos
	public ResponseEntity <List<Tema>>getAll(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	
	@GetMapping("/{id}")// listar por id
	public ResponseEntity <Tema>getByid(@PathVariable Long id){
		return temaRepository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")//listar por nome
		public ResponseEntity<List<Tema>> getByNome(@PathVariable String nome){ //Duvida List e encurtar o nome
		return ResponseEntity.ok(temaRepository.findAllByNomeContainingIgnoreCase(nome));			
	}
		
	
	@PostMapping //cadastrar
	public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(temaRepository.save(tema));
	}
	
	@PutMapping//Atualizar
	public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema){
		return temaRepository.findById(tema.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED)
						.body(temaRepository.save(tema)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());			
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Tema> tema = temaRepository.findById(id);
		
		if(tema.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		temaRepository.deleteById(id);
	}
	

	
}
