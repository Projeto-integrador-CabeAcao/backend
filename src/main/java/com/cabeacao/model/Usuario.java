package com.cabeacao.model;



import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Atributo usuario é obrigatório")
	@Size(max = 50, message = "O usuario precisa ter no maximo 50" )
	@Column (length = 50)
	private String usuario;
	
	@NotBlank(message = "O Atributo usuario é obrigatório")
	@Size(max = 50, message = "O usuario precisa ter no maximo 50" )
	@Column (length = 50)
	private String nome;
	
	
	@NotBlank(message = "O Atributo senha é obrigatório")
	@Size(min = 8, max = 50, message = "A senha precisa ter no minimo 8 caracteres e no maximo 50" )
	@Column (length = 50)
	private String senha;
	
	@NotNull
	private String foto;
	
	@NotBlank(message = "O Atributo data é obrigatório")
	@Size(min = 10, max = 10, message = "A data precisa ter 8 caracteres" )
	@Column (length = 10)
	private Date dataNascimento;
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
