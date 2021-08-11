package br.com.bootcamp.dio.personApi.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDto {
	
	private String message;

}
