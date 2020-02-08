package ru.configmicroservice.configmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.configmicroservice.configmicroservice.Classes.KafkaConfig;

@SpringBootApplication
public class ConfigmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigmicroserviceApplication.class, args);
		KafkaConfig.sendRoles();
	}

}
