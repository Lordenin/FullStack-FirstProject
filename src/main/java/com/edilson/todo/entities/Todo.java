package com.edilson.todo.entities;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String Titulo;
	
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date tempoParaTerminar;
	
	private Boolean finalizado = false;

	public Todo() {
		super();
	}



	public Todo(Integer id, String titulo, String descricao, Date tempoParaTerminar, Boolean finalizado) {
		super();
		this.id = id;
		this.Titulo = titulo;
		this.descricao = descricao;
		this.tempoParaTerminar = tempoParaTerminar;
		this.finalizado = finalizado;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(id, other.id);
	}
	
	

	public Date getTempoParaTerminar() {
		return tempoParaTerminar;
	}



	public void setTempoParaTerminar(Date tempoParaTerminar) {
		this.tempoParaTerminar = tempoParaTerminar;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	
}
