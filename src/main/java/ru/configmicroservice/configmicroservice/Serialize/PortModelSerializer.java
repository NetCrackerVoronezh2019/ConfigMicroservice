package  ru.configmicroservice.configmicroservice.Serialize;

import java.util.Map;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;
 


public class PortModelSerializer<T> implements Serializer<T> {
	
	@Override
	public byte[] serialize(String topic, T data) {
		 byte[] retVal = null;
		   ObjectMapper objectMapper = new ObjectMapper();
		   try {
		     retVal = objectMapper.writeValueAsString(data).getBytes();
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		   return retVal;
	}		
}
