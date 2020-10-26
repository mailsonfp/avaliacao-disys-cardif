package com.avaliacao.core.springfox;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.avaliacao.api.model.output.CargoModelOutput;
import com.avaliacao.api.model.output.DepartamentoModelOutput;
import com.avaliacao.domain.model.Cargo;
import com.avaliacao.domain.model.Departamento;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {
	
	ModelRef modeloProblema = new ModelRef("Problema");
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.avaliacao.api")).build()
				.globalResponseMessage(RequestMethod.GET, getGlobalResponseMessage())
				.globalResponseMessage(RequestMethod.POST, getGlobalPostPutResponseMessages())
				.globalResponseMessage(RequestMethod.PUT, getGlobalPostPutResponseMessages())
				.globalResponseMessage(RequestMethod.DELETE, getGlobalDeleteResponseMessages())
				.directModelSubstitute(Cargo.class, CargoModelOutput.class)			
				.directModelSubstitute(Departamento.class, DepartamentoModelOutput.class)
				.useDefaultResponseMessages(false)
				.ignoredParameterTypes(ServletRequest.class)
				.apiInfo(getApiInfo())
				.tags(
					new Tag("Departamentos", "Endpoint responsável por armazenar as operações relativas aos departamentos"),
					new Tag("Cargos", "Endpoint responsável por armazenar as operações relativas aos cargos"),
					new Tag("Funcionários", "Endpoint responsável por armazenar as operações relativas aos funcionários"));
	}
	
	private List<ResponseMessage> getGlobalResponseMessage(){
		return Arrays.asList(
					new ResponseMessageBuilder()
						.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message("Erro interno da api")
						.responseModel(modeloProblema)
						.build(),
					new ResponseMessageBuilder()
						.code(HttpStatus.NOT_ACCEPTABLE.value())
						.message("Recurso  não possui representação que poderia ser aceita pelo consumidor")
						.build()
				);
	}
	
	private List<ResponseMessage> getGlobalPostPutResponseMessages() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.BAD_REQUEST.value())
					.message("Requisição inválida")
					.responseModel(modeloProblema)
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno no servidor")
					.responseModel(modeloProblema)
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.NOT_ACCEPTABLE.value())
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
					.message("Requisição recusada porque o corpo está em um formato não suportado")
					.responseModel(modeloProblema)
					.build()
			);
	}
	
	private List<ResponseMessage> getGlobalDeleteResponseMessages() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.BAD_REQUEST.value())
					.message("Requisição inválida")
					.responseModel(modeloProblema)
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno no servidor")
					.responseModel(modeloProblema)
					.build()
			);
	}
	
	public ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
					.title("Avaliação desenvolvedor Java DiSys - Cardif")
					.description("API desenvolvida para Avaliação desenvolvedor Java DiSys - Cardif")
					.version("1")
					.contact(new Contact("Mailson Fernando Pereira", "https://www.linkedin.com/in/mailsonfernandopereira/", "mailsonp.dev@gmail.com"))
					.build();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
	
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
