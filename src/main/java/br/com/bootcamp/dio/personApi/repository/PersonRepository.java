package br.com.bootcamp.dio.personApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bootcamp.dio.personApi.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
