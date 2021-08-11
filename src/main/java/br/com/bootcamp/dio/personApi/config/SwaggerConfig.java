package br.com.bootcamp.dio.personApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiGerenciamentoPessoas() {
		return new Docket(DocumentationType.SWAGGER_2)
		          .select()
		          .apis(RequestHandlerSelectors.basePackage("br.com.bootcamp.dio.personApi"))
		          .paths(PathSelectors.ant("/**"))
		          .build()
		          .apiInfo(apiInfo());
	}
	
	
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Api simples, gerenciamento de pessoas")
	            .description("Desenvolvimento de uma api simulando o gerenciamento de pessoas para uma empresa")
	            .version("1.0.0")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("Guilherme Assis", "https://github.com/guilhermefasilva", null))
	            .build();
	}
}
