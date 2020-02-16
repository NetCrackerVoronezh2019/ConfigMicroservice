package ru.configmicroservice.configmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ru.configmicroservice.configmicroservice.Classes.KafkaConfig;

@SpringBootApplication
public class ConfigmicroserviceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app=SpringApplication.run(ConfigmicroserviceApplication.class, args);
		KafkaConfig kafka=(KafkaConfig)app.getBean("kafkaConfig");
		kafka.sendRoles();
	    kafka.sendSubjects();
	}

}
