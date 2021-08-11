package br.com.bootcamp.dio.personApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.bootcamp.dio.personApi.Dto.request.PersonDto;
import br.com.bootcamp.dio.personApi.entity.Person;

@Mapper
public interface PersonMapper {
		
		PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
		
		@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
		Person toPerson(PersonDto personDto);
		PersonDto toDTO(Person person);
		
}
