package com.codecool.enterprise.overcomplicated;

import com.codecool.enterprise.overcomplicated.model.tictactoegame.AiService;
import com.codecool.enterprise.overcomplicated.service.OutsourcedAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OvercomplicatedTicatactoeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OvercomplicatedTicatactoeApplication.class, args);
	}

	@Bean
	AiService aiService(){
		return new OutsourcedAiService();
	}


}
