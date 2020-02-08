package ru.configmicroservice.configmicroservice.Classes;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import ru.configmicroservice.configmicroservice.Models.PortModel;
import ru.configmicroservice.configmicroservice.Serialize.PortModelSerializer;
import ru.configmicroservice.configmicroservice.Serialize.RolesSerializer;


public  class KafkaConfig {

	public static void newPort(PortModel portModel,String topicName)
	{
		    String bootstrapServers="127.0.0.1:9092";
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
	
	public static void sendRoles()
	{
			Roles r=new Roles();
		    String bootstrapServers="127.0.0.1:9092";
	    	Properties properties=new Properties();
	    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
	    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
	    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,RolesSerializer.class.getName());
	    	
	
	    	KafkaProducer<String,List<String>> producer=new KafkaProducer<String,List<String>>(properties);
	    	ProducerRecord<String,List<String>> record=new ProducerRecord<String,List<String>>("rolestopic",r.allRoles);

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
