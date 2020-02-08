package ru.configmicroservice.configmicroservice.Serialize;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class RolesSerializer implements Serializer<List<String>>{

	@Override
	public byte[] serialize(String topic, List<String> data) {
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
