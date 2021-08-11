package br.com.bootcamp.dio.personApi.enuns;

public enum PhoneType {
	
	HOME("Nome"),
	MOBILE("Mobile"),
	COMERCIAL("Comercial");

	private final String description;

	private PhoneType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	
}
