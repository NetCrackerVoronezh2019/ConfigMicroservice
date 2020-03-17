package ru.configmicroservice.configmicroservice.Kafka;
import java.util.Properties;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.configmicroservice.configmicroservice.PropertiesConfigurations.Topics;

@Component
public  class KafkaConfig{

	@Autowired
	private Topics topics;
	
	public void sendRoles()
	{
		KafkaProducers.StringProducer(topics.getRoleTopic(),"New Roles");
	}
	
	public void sendSubjects()
	{
			KafkaProducers.StringProducer(topics.getSubjectTopic(), "New Subjects");
	}
	
	public void newMicroserviceInfo()
	{
		KafkaProducers.StringProducer(topics.getPortTopic(), "New Ports");
	}
	
}
