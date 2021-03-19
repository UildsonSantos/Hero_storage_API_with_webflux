package com.digitalinnovationone.heroesapi;

import lombok.extern.slf4j.Slf4j;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableDynamoDBRepositories
public class HeroesapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(HeroesapiApplication.class, args);

	}

}
