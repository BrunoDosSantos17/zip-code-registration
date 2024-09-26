package com.santosdosbruno.TelaCadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TelaCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelaCadastroApplication.class, args);
	}

}
