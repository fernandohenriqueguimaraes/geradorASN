package br.com.geradorASN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.geradorASN.service.config.RestNimbiConfig;

@ComponentScan(basePackages = {"br.com.geradorASN"})
@Configuration
@EnableWebMvc
@SpringBootApplication
public class GeradorAsnApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GeradorAsnApplication.class, args);
	}
	
}
