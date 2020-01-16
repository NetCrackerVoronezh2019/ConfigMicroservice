package ru.configmicroservice.configmicroservice.DeSerialize;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.configmicroservice.configmicroservice.Models.PortModel;


@SuppressWarnings("rawtypes")
public class PortModelDeserialize implements Deserializer {

	@Override
	 public Object deserialize(String arg0, byte[] arg1) {
	   ObjectMapper mapper = new ObjectMapper();
	    PortModel user = null;
	   try {
	     user = mapper.readValue(arg1, PortModel.class);
	   } catch (Exception e) {
	     e.printStackTrace();
	   }
	   return user;
	 }

		
}


