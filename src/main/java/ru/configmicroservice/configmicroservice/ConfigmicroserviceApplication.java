package ru.configmicroservice.configmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ru.configmicroservice.configmicroservice.Kafka.KafkaConfig;

@SpringBootApplication
public class ConfigmicroserviceApplication {

	public static void main(String[] args) {
		
	
		ConfigurableApplicationContext app=SpringApplication.run(ConfigmicroserviceApplication.class, args);
		try {
		    KafkaConfig kafka=(KafkaConfig)app.getBean("kafkaConfig");
			kafka.sendRoles();
			kafka.sendSubjects();
		    kafka.newMicroserviceInfo();
		}
		catch(Exception ex)
		{
			
		}
		
	}
		

}
