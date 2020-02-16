package ru.configmicroservice.configmicroservice.Controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.configmicroservice.configmicroservice.Classes.KafkaConfig;
import ru.configmicroservice.configmicroservice.Classes.Roles;
import ru.configmicroservice.configmicroservice.Entitys.Subject;
import ru.configmicroservice.configmicroservice.Models.PortModel;
import ru.configmicroservice.configmicroservice.Repositories.SubjectRepository;
import ru.configmicroservice.configmicroservice.Services.SubjectService;


@RestController
public class ConfigController {

	@Autowired
	private KafkaConfig kafka;
	
	@Autowired 
	private SubjectRepository r;
	
	@Autowired
	private Roles roles;
	
	@PostMapping("/setPortModel")
	public PortModel setPortModel(@RequestBody PortModel portModel)
	{    		
		kafka.newPort(portModel,"ports_topic");	
        return portModel;
	}
	
	@GetMapping("/roles")
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
		r.save(_subject);
		kafka.sendSubjects();
		return _subject;
		
	}
	
	
}
