package ru.configmicroservice.configmicroservice.Controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.configmicroservice.configmicroservice.Entitys.Subject;
import ru.configmicroservice.configmicroservice.Kafka.KafkaConfig;
import ru.configmicroservice.configmicroservice.Models.MicroserviceInfo;
import ru.configmicroservice.configmicroservice.PropertiesConfigurations.MicroservicesProp;
import ru.configmicroservice.configmicroservice.PropertiesConfigurations.Roles;
import ru.configmicroservice.configmicroservice.Services.SubjectService;


@RestController
public class ConfigController {
	
   @Autowired
   private MicroservicesProp microservicesProp;

	@Autowired
	private KafkaConfig kafka;
	
	@Autowired 
	private SubjectService subjectService;
	
	@Autowired
	private Roles roles;
	
	
	
	@PostMapping("/setInfoModel")
	public ResponseEntity<?> setPortModel(@RequestBody MicroserviceInfo microInfo)
	{    		
			
		microservicesProp.setInfo(microInfo);
		kafka.newMicroserviceInfo();
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@GetMapping("/getAllInfo")
	public ResponseEntity<List<MicroserviceInfo>> getAllMicroservicesInfo()
	{
		return new ResponseEntity<>(microservicesProp.getAllMicroservicesInfo(),HttpStatus.OK);
		
	}
	@GetMapping("getAllSubjects")
	public ResponseEntity<List<Subject>> getAllSubjects()
	{
		return new ResponseEntity<>(subjectService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllRoles")
	public ResponseEntity<List<String>> getAllRoles()
	{
		return new ResponseEntity<>(roles.getAllRoleNames(),HttpStatus.OK);
	}
	
	@PostMapping("/setRoles")
	public  ResponseEntity<List<String>> setRoles(@RequestBody List<String> _roles)
	{
		roles.setAllRoleNames(_roles);
		kafka.sendRoles();
		return new ResponseEntity<>(_roles,HttpStatus.OK);
	}
	
	@PostMapping("/setNewSubject")
	public ResponseEntity<Subject> addSubjects(@RequestBody Subject _subject)
	{
		subjectService.save(_subject);
		kafka.sendSubjects();
		return new ResponseEntity<>(_subject,HttpStatus.OK);
		
	}
	
	
}
