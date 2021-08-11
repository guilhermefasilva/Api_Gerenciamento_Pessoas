package br.com.bootcamp.dio.personApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bootcamp.dio.personApi.Dto.MessageResponseDto;
import br.com.bootcamp.dio.personApi.Dto.request.PersonDto;
import br.com.bootcamp.dio.personApi.entity.Person;
import br.com.bootcamp.dio.personApi.mapper.PersonMapper;
import br.com.bootcamp.dio.personApi.repository.PersonRepository;
import br.com.bootcamp.dio.personApi.resources.PersonNotFoundException;

@Service
public class PersonService {

	
	private PersonRepository personRepository;
	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDto createPerson(PersonDto personDto) {
		Person personToSave = personMapper.toPerson(personDto);
		
		Person savePerson = personRepository.save(personToSave);
		return MessageResponseDto
				.builder()
				.message("Created person with id" + savePerson.getId())
				.build();
		
	}

	public List<PersonDto> listAll() {
		List<Person> person = personRepository.findAll();
		return person.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}

	public PersonDto findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
	}
	
	public MessageResponseDto updateById(Long id, PersonDto personDto) throws PersonNotFoundException {
		verifyIfExists(id);
			Person personToSave = personMapper.toPerson(personDto);
		
		Person savePerson = personRepository.save(personToSave);
		return MessageResponseDto
				.builder()
				.message("Update person with id" + savePerson.getId())
				.build();
	}

	

	public void delete(Long id) throws PersonNotFoundException{
			verifyIfExists(id);
			personRepository.deleteById(id);
	}
	
	
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id)
				.orElseThrow(()-> new PersonNotFoundException(id));
	}

	
	

	
	
}
