package ru.configmicroservice.configmicroservice.Controllers;
import org.springframework.web.bind.annotation.*;

import ru.configmicroservice.configmicroservice.Classes.KafkaConfig;
import ru.configmicroservice.configmicroservice.Models.PortModel;


@RestController
public class ConfigController {

	@PostMapping("/setPortModel")
	public PortModel setPortModel(@RequestBody PortModel portModel)
	{    		
		KafkaConfig.newPort(portModel,"ports_topic");	
        return portModel;
	}
}
