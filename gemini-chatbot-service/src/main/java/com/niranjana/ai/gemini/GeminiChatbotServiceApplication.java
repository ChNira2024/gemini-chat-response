package com.niranjana.ai.gemini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeminiChatbotServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(GeminiChatbotServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GeminiChatbotServiceApplication.class, args);
		log.info("GeminiChatbotServiceApplication is started..........");
	}

}
