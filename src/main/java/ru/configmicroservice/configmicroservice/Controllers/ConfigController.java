package ru.configmicroservice.configmicroservice.Controllers;
import ru.configmicroservice.configmicroservice.DeSerialize.PortModelDeserialize;

import ru.configmicroservice.configmicroservice.Models.*;
import ru.configmicroservice.configmicroservice.Serialize.PortModelSerializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;




@RestController
public class ConfigController {

	
	
	@GetMapping("/getdata")
	public List<PortModel> yy()
	{
		
		String bootstrapServers2="127.0.0.1:9092";
		String topic="ports_topic";
    	Properties properties2=new Properties();
    	properties2.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers2);
    	properties2.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
    	properties2.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,PortModelDeserialize.class.getName());
    	properties2.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
    	properties2.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "portsz");
    	KafkaConsumer<String,PortModel> consumer=new KafkaConsumer<String,PortModel>(properties2);
    	consumer.subscribe(Arrays.asList(topic));
    	
    	List<PortModel> models=new ArrayList<PortModel>();
    	int i=0;
    	while(i<5)
    	{
    		ConsumerRecords<String,PortModel> records=consumer.poll(Duration.ofMillis(100));
    		
    		for(ConsumerRecord<String,PortModel> recordx:records)
    		{
    		  models.add(recordx.value());	
    		}
    		
    		i++;
    	}
		
    	return models;
	}
	
	
	@GetMapping("/setdata")
	public boolean xx()
	{
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		 
         headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
         headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<PortModel> entity = new HttpEntity<PortModel>(headers);
		 ResponseEntity<PortModel> response = restTemplate.exchange("http://localhost:8081/gett",HttpMethod.GET, entity, PortModel.class );
	    	
		 
		    String bootstrapServers="127.0.0.1:9092";
	    	Properties properties=new Properties();
	    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
	    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
	    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,PortModelSerializer.class.getName());
	    	
	    	KafkaProducer<String,PortModel> producer=new KafkaProducer<String,PortModel>(properties);
	    	ProducerRecord<String,PortModel> record=new ProducerRecord<String,PortModel>("ports_topic",response.getBody());
	    	
	    	producer.send(record,new Callback(){
	    	    public void onCompletion(RecordMetadata rm, Exception ex){
	    	    	if(ex==null)
	    	    	{
	    	    		System.out.println("Callback Working !");
	    	    		System.out.println("Topic---"+rm.topic());
	    	    		System.out.println("partition---"+rm.partition());
	    	    		System.out.println("Offset---"+rm.offset());
	    	    		
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
	    	
         return true;
	}
}
