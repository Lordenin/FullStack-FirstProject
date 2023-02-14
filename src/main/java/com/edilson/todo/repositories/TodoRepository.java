package com.edilson.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edilson.todo.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	@Query("SELECT obj FROM Todo obj WHERE obj.finalizado = false ORDER BY obj.tempoParaTerminar")
	List<Todo> finAllOpen();

	@Query("SELECT obj FROM Todo obj WHERE obj.finalizado = true ORDER BY obj.tempoParaTerminar")
	List<Todo> finAllClose();

}
