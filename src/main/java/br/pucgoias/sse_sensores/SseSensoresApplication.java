package br.pucgoias.sse_sensores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SseSensoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SseSensoresApplication.class, args);
	}

}
