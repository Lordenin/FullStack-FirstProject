package com.edilson.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilson.todo.entities.Todo;
import com.edilson.todo.repositories.TodoRepository;
import com.edilson.todo.services.exceptions.ObjectNotFoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public Todo findById(Integer id) {
		Optional<Todo> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto Não encontrado!!" + id + ", Tipo:" + Todo.class.getName()));
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = repository.finAllOpen();
		return list;
	}

	public List<Todo> findAllClose() {
		List<Todo> list = repository.finAllClose();
		return list;
	}

	public List<Todo> findAll() {
		List<Todo> list = repository.findAll();
		return list;
	}

	public Todo create(Todo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	public Todo update(Integer id, Todo obj) {
		Todo newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDescricao(obj.getDescricao());
		newObj.setTempoParaTerminar(obj.getTempoParaTerminar());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj);
	}

}
