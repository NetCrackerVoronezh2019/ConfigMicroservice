package ru.configmicroservice.configmicroservice.Serialize;
import java.util.*;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.configmicroservice.configmicroservice.Classes.SubjectServiceX;
import ru.configmicroservice.configmicroservice.Entitys.Subject;


public class SubjectsSerializer implements Serializer<SubjectServiceX> {

	@Override
	public byte[] serialize(String topic, SubjectServiceX data) {
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
