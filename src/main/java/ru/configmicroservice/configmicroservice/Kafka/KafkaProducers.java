package ru.configmicroservice.configmicroservice.Kafka;
import java.util.Properties;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducers {

	@SuppressWarnings("resource")
	public static void StringProducer(String topic,String message)
	{
		KafkaProducer<String,String> producer = null;
		try
		{
			String bootstrapServers="192.168.99.100:9092";
	    	Properties properties=new Properties();
	    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
	    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
	    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
	    	producer=new KafkaProducer<String,String>(properties);
	    	ProducerRecord<String,String> record=new ProducerRecord<String,String>(topic,message);
	    	producer.send(record,new Callback(){
	    		
	    	    public void onCompletion(RecordMetadata rm, Exception ex){
	    	    	if(ex==null)
	    	    	{
	    	    		System.out.println("SEND"+topic);
	    	    		System.out.println("Callback Working !");	
	    	    	}
	    	    	else
	    	    	{
	    	    		System.out.println("SEND"+topic);
	    	    		System.out.println(ex.getMessage());
	    	    	}
	    	    }
	    	 }
	    			);
		}
	    	
		catch(Exception ex) {
			
		}
		finally{
			if(producer!=null)
			{
				producer.flush();
				//producer.close();
			}
		}
    	
	}
}
