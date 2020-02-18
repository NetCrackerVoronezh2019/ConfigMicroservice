package ru.configmicroservice.configmicroservice.PropertiesConfigurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import ru.configmicroservice.configmicroservice.Models.Microservices;
import ru.configmicroservice.configmicroservice.Models.PortModel;

@Component 
@ConfigurationProperties(prefix="microservices")
public class Ports {

	private Integer main;
	private Integer advertisement;
	private Integer conversation;
	private Integer userAndgroups;
		
	public Integer getMain() {
		return main;
	}
	public void setMain(Integer main) {
		this.main = main;
	}

	public Integer getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Integer advertisement) {
		this.advertisement = advertisement;
	}

	public Integer getConversation() {
		return conversation;
	}

	public void setConversation(Integer conversation) {
		this.conversation = conversation;
	}

	public Integer getUserAndgroups() {
		return userAndgroups;
	}

	public void setUserAndgroups(Integer userAndgroups) {
		this.userAndgroups = userAndgroups;
	}

	public void setPort(PortModel portModel)
	{
		
		if(portModel!=null)
		{
			if(portModel.getMicroserviceName()!=null && portModel.getPort()!=null)
			{
				if(portModel.getMicroserviceName()==Microservices.MAIN)
					this.setMain(portModel.getPort());
				else
				{
					if(portModel.getMicroserviceName()==Microservices.ADVERTISEMENT)
						this.setAdvertisement(portModel.getPort());
					else
					{
						if(portModel.getMicroserviceName()==Microservices.CONVERSATION)
						{
							this.setConversation(portModel.getPort());
						}
						else
						{
							this.setUserAndgroups(portModel.getPort());
						}
					}
				}
			}
		}
	}
	
	
	
}
