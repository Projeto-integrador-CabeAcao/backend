package com.cabeacao.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O Atributo materia é obrigatório")
	@Size(min = 4, max = 100, message = "A materia precisa ter no minimo 4 caracteres e no maximo 99")
	@Column(length = 100)
	private String materia;

	@NotBlank(message = "O Atributo titulo é obrigatório")
	@Size(min = 2, max = 100, message = "O titulo precisa ter no minimo 2 caracteres e no maximo 30")
	@Column(length = 100)
	private String titulo;

	@Size(min = 5, max = 3000, message = "O texto precisa ter no minimo 1 caracteres e no maximo 3000")
	@Column(length = 3000)
	private String texto;
	// Como definir min e max de links
	@Column(length = 250)
	private String midia;

	// Como definir o atributo data da postagem
	// @NotBlank(message = "O atributo data é obrigatório")
	// private LocalDateTime data;

	@Column
	private LocalDateTime data = LocalDateTime.now();

	// @PreUpdate
	// public void preUpdate() {
	// data = LocalDateTime.now();
	// }

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
