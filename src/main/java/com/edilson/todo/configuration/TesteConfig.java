package com.edilson.todo.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.edilson.todo.services.DBservice;

@Configuration
@Profile("test")
public class TesteConfig {
	
	@Autowired
	private DBservice dbservice;
	
	@Bean
	public boolean instancia() throws ParseException {
		this.dbservice.instanciaBaseDeDados();
		return true;
	}

}
