package com.cabeacao.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	
	@NotBlank(message = "O campo disciplina é obrigatório")
	@Size(min = 1, max = 100, message = "A disciplina precisa ter no minimo 1 caracteres e no maximo 100" )
	@Column (length = 100)
	private String disciplina;
	
		
	@NotBlank(message = "O campo Descrição é obrigatório")
	@Size(min = 10, max = 500, message = "A descrição precisa ter no minimo 5 caracteres e no maximo 500" )
	@Column (length = 500)
	private String descricao;
	
	
	private String link;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tema",cascade  = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;	
	
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

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
	
	

}