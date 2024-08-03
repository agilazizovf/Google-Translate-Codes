package com.translate.Google.Translate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.translate.app.client")
public class GoogleTranslateApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleTranslateApplication.class, args);
	}

}
