package br.com.bootcamp.dio.personApi.resources;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
				
	public PersonNotFoundException(Long id) {
		super("Id não encontrado" + id);
	}
	

}
