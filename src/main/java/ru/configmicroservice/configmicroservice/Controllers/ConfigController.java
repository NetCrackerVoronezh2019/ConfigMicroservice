package ru.configmicroservice.configmicroservice.Controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.configmicroservice.configmicroservice.Entitys.Subject;
import ru.configmicroservice.configmicroservice.Kafka.KafkaConfig;
import ru.configmicroservice.configmicroservice.Models.PortModel;
import ru.configmicroservice.configmicroservice.PropertiesConfigurations.Ports;
import ru.configmicroservice.configmicroservice.PropertiesConfigurations.Roles;
import ru.configmicroservice.configmicroservice.Repositories.SubjectRepository;
import ru.configmicroservice.configmicroservice.Services.SubjectService;


@RestController
public class ConfigController {
	
   @Autowired
   private Ports ports;

	@Autowired
	private KafkaConfig kafka;
	
	@Autowired 
	private SubjectService subjectService;
	
	@Autowired
	private Roles roles;
	
	
	
	@PostMapping("/setPortModel")
	public void setPortModel(@RequestBody PortModel portModel)
	{    		
		kafka.newPort();	
        ports.setPort(portModel);
	}
	
	@GetMapping("getallsubjects")
	public List<Subject> getAllSubjects()
	{
		return subjectService.findAll();
	}
	
	@GetMapping("/getallroles")
	public List<String> getAllRoles()
	{
		return roles.getAllRoleNames();
	}
	
	@PostMapping("/setroles")
	public  ResponseEntity<List<String>> setRoles(@RequestBody List<String> _roles)
	{
		roles.setAllRoleNames(_roles);
		kafka.sendRoles();
		return new ResponseEntity<>(_roles,HttpStatus.OK);
	}
	
	@PostMapping("/addnewsubject")
	public Subject addSubjects(@RequestBody Subject _subject)
	{
		subjectService.save(_subject);
		kafka.sendSubjects();
		return _subject;
		
	}
	
	
}
