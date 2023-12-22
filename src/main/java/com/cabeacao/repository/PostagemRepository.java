package com.cabeacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.cabeacao.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem,Long>{
	//metodo query
	public List <Postagem> findAllByMateriaContainingIgnoreCase(@Param("materia")String materia);
}
