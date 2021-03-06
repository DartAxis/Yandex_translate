package ru.dartinc.Yandex_translate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YandexTranslateApplication {

	public static void main(String[] args) {
		SpringApplication.run(YandexTranslateApplication.class, args);
	}

}
