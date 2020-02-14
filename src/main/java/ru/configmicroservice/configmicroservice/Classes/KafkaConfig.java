package ru.configmicroservice.configmicroservice.Classes;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.configmicroservice.configmicroservice.Entitys.Subject;
import ru.configmicroservice.configmicroservice.Models.PortModel;
import ru.configmicroservice.configmicroservice.Serialize.PortModelSerializer;
import ru.configmicroservice.configmicroservice.Serialize.RolesSerializer;
import ru.configmicroservice.configmicroservice.Serialize.SubjectsSerializer;
import ru.configmicroservice.configmicroservice.Services.SubjectService;

@Component
public  class KafkaConfig {

	@Autowired
	private Roles roles;
	
	@Autowired
	private SubjectService subjectService;
	
	public void newPort(PortModel portModel,String topicName)
	{
			String bootstrapServers="192.168.99.100:9092";
	    	Properties properties=new Properties();
	    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
	    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
	    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,PortModelSerializer.class.getName());
	    	KafkaProducer<String,PortModel> producer=new KafkaProducer<String,PortModel>(properties);
	    	ProducerRecord<String,PortModel> record=new ProducerRecord<String,PortModel>(topicName,portModel);
	    	producer.send(record,new Callback(){
	    	    public void onCompletion(RecordMetadata rm, Exception ex){
	    	    	if(ex==null)
	    	    	{
	    	    		System.out.println("Callback Working !");	
	    	    	}
	    	    	else
	    	    	{
	    	    		System.out.println(ex.getMessage());
	    	    	}
	    	    }
	    	 }
	    			);
	    	producer.flush();
	    	producer.close();
	}
	
	public void sendRoles()
	{
			String bootstrapServers="192.168.99.100:9092";
	    	Properties properties=new Properties();
	    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
	    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
	    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,RolesSerializer.class.getName());
	    	
	
	    	KafkaProducer<String,List<String>> producer=new KafkaProducer<String,List<String>>(properties);
	    	ProducerRecord<String,List<String>> record=new ProducerRecord<String,List<String>>("roles_topic",roles.getAllRoleNames());

	    	producer.send(record,new Callback(){
	    	    public void onCompletion(RecordMetadata rm, Exception ex){
	    	    	if(ex==null)
	    	    	{
	    	    		System.out.println("Callback Working !");	
	    	    	}
	    	    	else
	    	    	{
	    	    		System.out.println(ex.getMessage());
	    	    	}
	    	    }
	    	 }
	    			);
	    	producer.flush();
	    	producer.close();
	}
	
	public void sendSubjects()
	{
			String bootstrapServers="192.168.99.100:9092";
	    	Properties properties=new Properties();
	    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
	    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
	    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,SubjectsSerializer.class.getName());
	    	
	
	    	KafkaProducer<String,SubjectServiceX> producer=new KafkaProducer<String,SubjectServiceX>(properties);
	    	ProducerRecord<String,SubjectServiceX> record=new ProducerRecord<String,SubjectServiceX>("subjects_topic",subjectService.getAllSubjects());

	    	producer.send(record,new Callback(){
	    	    public void onCompletion(RecordMetadata rm, Exception ex){
	    	    	if(ex==null)
	    	    	{
	    	    		System.out.println("Callback Working !");	
	    	    	}
	    	    	else
	    	    	{
	    	    		System.out.println(ex.getMessage());
	    	    	}
	    	    }
	    	 }
	    			);
	    	producer.flush();
	    	producer.close();
	}
	
	
}
