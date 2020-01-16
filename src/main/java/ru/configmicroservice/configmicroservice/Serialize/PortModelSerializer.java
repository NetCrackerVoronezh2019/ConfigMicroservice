package  ru.configmicroservice.configmicroservice.Serialize;

import java.util.Map;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;



public class PortModelSerializer implements Serializer {

	 @Override public byte[] serialize(String arg0, Object arg1) {
		   byte[] retVal = null;
		   ObjectMapper objectMapper = new ObjectMapper();
		   try {
		     retVal = objectMapper.writeValueAsString(arg1).getBytes();
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		   return retVal;
		 }		
}
