package br.com.bootcamp.dio.personApi.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bootcamp.dio.personApi.Dto.MessageResponseDto;
import br.com.bootcamp.dio.personApi.Dto.request.PersonDto;
import br.com.bootcamp.dio.personApi.resources.PersonNotFoundException;
import br.com.bootcamp.dio.personApi.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	private PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto) {
		return personService.createPerson(personDto);
	}
	
	@GetMapping
	public List<PersonDto> findAll(){
		return personService.listAll();
	}
	
	@GetMapping("{id}")
	public PersonDto findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public MessageResponseDto updateByid(@PathVariable Long id, @RequestBody @Valid PersonDto personDto) throws PersonNotFoundException {
			return personService.updateById(id, personDto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
		this.personService.delete(id);
	}
	
}
