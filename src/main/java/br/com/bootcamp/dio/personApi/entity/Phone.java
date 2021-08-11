package br.com.bootcamp.dio.personApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.bootcamp.dio.personApi.enuns.PhoneType;


@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated
	@Column(nullable = false)
	private PhoneType type;
	
	@Column(nullable = false)
	private String number;
	
	@Deprecated
	public Phone() {
		
	}
	
	public Phone(Long id, PhoneType type, String number) {
		this.id = id;
		this.type = type;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public PhoneType getType() {
		return type;
	}

	public String getNumber() {
		return number;
	}
	
	
	
	
	

}
