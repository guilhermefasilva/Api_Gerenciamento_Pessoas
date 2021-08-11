package br.com.bootcamp.dio.personApi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false)
		private String firstName;
		
		@Column(nullable = false)
		private String lastName;
		
		@Column(nullable = false, unique = true)
		private String cpf;
		
		private LocalDate birthDate;
		
		@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
		private List<Phone> phones;

		@Deprecated
		public Person() {
			
		}
		
		public Person(Long id, String firstName, String lastName, String cpf, LocalDate birthDate, List<Phone> phones) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.cpf = cpf;
			this.birthDate = birthDate;
			this.phones = phones;
		}

		public Long getId() {
			return id;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getCpf() {
			return cpf;
		}

		public LocalDate getBirthDate() {
			return birthDate;
		}

		public List<Phone> getPhones() {
			return phones;
		}
		
		
		
}
