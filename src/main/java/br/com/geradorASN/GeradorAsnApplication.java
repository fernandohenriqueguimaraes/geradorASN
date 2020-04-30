package br.com.geradorASN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@PropertySource({ResourceLoader.CLASSPATH_URL_PREFIX + "log.properties",
	ResourceLoader.CLASSPATH_URL_PREFIX + "spring.properties",
	ResourceLoader.CLASSPATH_URL_PREFIX + "messages.properties"
})
@SpringBootApplication
public class GeradorAsnApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeradorAsnApplication.class, args);
	}

}
