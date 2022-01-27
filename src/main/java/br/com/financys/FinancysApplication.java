package br.com.financys;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = ("br.com.financys.entities"))
@EnableJpaRepositories(basePackages = ("br.com.financys.repository"))
@ComponentScan(basePackages = ("br.com.financys.controller, br.com.financys.service, package br.com.financys.exception"))
@SpringBootApplication
public class FinancysApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(FinancysApplication.class, args);
	}




}
