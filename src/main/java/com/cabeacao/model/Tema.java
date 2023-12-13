package com.cabeacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // criando uma tabela
@Table(name = "tb_temas")//esta nomeando a tabela
public class Tema {
	
	@Id //Criando o ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)//AutoIncrement no ID
	private Long id;
	//long == BigInt
	
	
	@NotBlank(message = "O Atributo nome é obrigatório")
	@Size(min = 5, max = 100, message = "O nome precisa ter no minimo 5 caracteres e no maximo 100" )
	@Column (length = 100)
	private String nome;
	
	@NotNull(message = "O Atributo disponivel é obrigatório")
	@Column(columnDefinition="tinyint(1) default 1")
	private boolean disponivel;		
	
	
	@NotBlank(message = "O Atributo Descrição é obrigatório")
	@Size(min = 10, max = 500, message = "A descrição precisa ter no minimo 5 caracteres e no maximo 500" )
	@Column (length = 500)
	private String descricao;
	
	
	public Long getId() { 
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	

}