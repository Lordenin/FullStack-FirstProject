package com.edilson.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilson.todo.entities.Todo;
import com.edilson.todo.repositories.TodoRepository;

@Service
public class DBservice {
	@Autowired
	private TodoRepository todoRepository;

	public void instanciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Todo t1 = new Todo(null, "Girotondo", "ss", sdf.parse("06/02/2023"), false);
		Todo t2 = new Todo(null, "Matrearca", "DD", sdf.parse("06/02/2023"), true);
		Todo t3 = new Todo(null, "Birulçeic", "AA", sdf.parse("06/02/2023"), false);
		Todo t4 = new Todo(null, "XIMBOLHA", "GG", sdf.parse("06/02/2023"), true);
		Todo t5 = new Todo(null, "OOOO", "HH", sdf.parse("06/02/2023"), false);
		todoRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5));

	}

}
