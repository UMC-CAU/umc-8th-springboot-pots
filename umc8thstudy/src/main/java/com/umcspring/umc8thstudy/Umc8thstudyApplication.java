package com.umcspring.umc8thstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc8thstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc8thstudyApplication.class, args);
	}

}
