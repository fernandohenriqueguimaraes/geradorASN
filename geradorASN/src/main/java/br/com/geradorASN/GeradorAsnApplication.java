package br.com.geradorASN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.geradorASN.service.config.RestConfig;

@ComponentScan(basePackages = {"br.com.geradorASN"})
@Configuration
@EnableWebMvc
@SpringBootApplication
public class GeradorAsnApplication {
	
	private static RestConfig REST_CONFIG = null;
	
	private static final String PACOTE = "br.com.geradorASN.service.config.RestNimbiProd";

	public static void main(String[] args) {
		
		try {
			
			Class<?> clazz = Class.forName(PACOTE);
			RestConfig restConfig = (RestConfig) clazz.newInstance();
			
			REST_CONFIG = restConfig;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		SpringApplication.run(GeradorAsnApplication.class, args);
	}
	
	@Bean
	public HttpHeaders createHeaders() {
		return REST_CONFIG.getHeaders();
	}
	
	@Bean
	public RestConfig getRestConfig() {
		return REST_CONFIG;
	}

}
