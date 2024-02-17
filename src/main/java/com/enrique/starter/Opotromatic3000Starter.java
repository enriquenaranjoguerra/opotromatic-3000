package com.enrique.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.enrique.controller.ConfigController;
import com.enrique.controller.QuestionController;
import com.enrique.managers.BoxManager;
import com.enrique.managers.CardManager;
import com.enrique.managers.CategoryManager;
import com.enrique.managers.QuestionManager;

@EnableJpaRepositories(basePackages = { "com.enrique.repositories" })
@SpringBootApplication(scanBasePackages = { "com.enrique.managers", "com.enrique.controller", "com.enrique.services" })
@EntityScan(basePackages = { "com.enrique.entities" })
public class Opotromatic3000Starter implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(false)
				.maxAge(4800);
	}

	public static void main(String[] args) {
		SpringApplication.run(Opotromatic3000Starter.class, args);
	}

	@Bean
	public QuestionController questionController(QuestionManager questionManager) {
		return new QuestionController(questionManager);
	}

	@Bean
	public ConfigController configController(CategoryManager categoryManager, BoxManager boxManager,
			CardManager cardManager) {
		return new ConfigController(categoryManager, boxManager, cardManager);
	}
}
