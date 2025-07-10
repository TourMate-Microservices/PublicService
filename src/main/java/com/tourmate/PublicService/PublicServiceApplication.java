package com.tourmate.PublicService;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PublicServiceApplication {
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.filename(".env")
				.ignoreIfMalformed()
				.ignoreIfMissing()
				.load();

		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
		SpringApplication.run(PublicServiceApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void logApplicationPort() {
		String port = environment.getProperty("local.server.port");
		System.out.println("Application started on port: " + port);
	}
}
