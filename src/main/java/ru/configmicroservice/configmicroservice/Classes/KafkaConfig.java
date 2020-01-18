package ru.configmicroservice.configmicroservice.Classes;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import ru.configmicroservice.configmicroservice.Models.PortModel;
import ru.configmicroservice.configmicroservice.Serialize.PortModelSerializer;


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
	    	    		System.out.println("СonfigMicroservice	Producer Start !!");
	    	    		System.out.println("Callback Working !");
	    	    		System.out.println("Topic---"+rm.topic());
	    	    		System.out.println("partition---"+rm.partition());
	    	    		System.out.println("Offset---"+rm.offset());
	    	    		System.out.println("СonfigMicroservice	Producer End !!");
	    	    		
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
