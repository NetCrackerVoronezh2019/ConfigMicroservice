package ru.configmicroservice.configmicroservice.PropertiesConfigurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.*;
import org.springframework.stereotype.Component;

import ru.configmicroservice.configmicroservice.Models.MicroserviceInfo;
import ru.configmicroservice.configmicroservice.Models.Microservices;

@Component 
@ConfigurationProperties(prefix="microservices")
public class MicroservicesProp {

	private Integer main;
	private Integer advertisement;
	private Integer conversation;
	private Integer userAndgroups;
	private Integer amazon;
	
	private String main_token;
	private String advertisement_token;
	private String conversation_token;
	private String userAndgroups_token;
	private String amazon_token;
	
	
	
	public List<MicroserviceInfo> getAllPorts()
	{
		List<MicroserviceInfo> allModels=new ArrayList<>();
		MicroserviceInfo main=new MicroserviceInfo(Microservices.MAIN,this.getMain(),this.getMain_token());
		MicroserviceInfo advertisement=new MicroserviceInfo(Microservices.ADVERTISEMENT,this.getAdvertisement(),this.getAdvertisement_token());
		MicroserviceInfo amazon=new MicroserviceInfo(Microservices.AMAZON,this.getAmazon(),this.getAmazon_token());
		MicroserviceInfo conversation=new MicroserviceInfo(Microservices.CONVERSATION,this.getConversation(),this.getConversation_token());
		allModels.add(main);
		allModels.add(advertisement);
		allModels.add(amazon);
		allModels.add(conversation);
		return allModels;
	}

	public void setPort(MicroserviceInfo portModel)
	{
		
		if(portModel!=null)
		{
			if(portModel.getMicroserviceName()!=null && portModel.getPort()!=null && portModel.getToken()!=null)
			{
				System.out.println("В методе");
				System.out.println(portModel.getToken());
				System.out.println(portModel.getPort());
				System.out.println(portModel.getMicroserviceName());
				
				if(portModel.getMicroserviceName()==Microservices.MAIN)
				{
					this.setMain(portModel.getPort());
					this.setMain_token(portModel.getToken());
				}
				else
				{
					if(portModel.getMicroserviceName()==Microservices.ADVERTISEMENT)
					{
						this.setAdvertisement(portModel.getPort());
						this.setAdvertisement_token(portModel.getToken());
					}
					else
					{
						if(portModel.getMicroserviceName()==Microservices.CONVERSATION)
						{
							this.setConversation(portModel.getPort());
							this.setConversation_token(portModel.getToken());
						}
						else
						{
							this.setUserAndgroups(portModel.getPort());
							this.setUserAndgroups_token(portModel.getToken());
						}
					}
				}
			}
		}
	}
	
	
		
	public String getMain_token() {
		return main_token;
	}
	public void setMain_token(String main_token) {
		this.main_token = main_token;
	}
	public String getAdvertisement_token() {
		return advertisement_token;
	}
	public void setAdvertisement_token(String advertisement_token) {
		this.advertisement_token = advertisement_token;
	}
	public String getConversation_token() {
		return conversation_token;
	}
	public void setConversation_token(String conversation_token) {
		this.conversation_token = conversation_token;
	}
	public String getUserAndgroups_token() {
		return userAndgroups_token;
	}
	public void setUserAndgroups_token(String userAndgroups_token) {
		this.userAndgroups_token = userAndgroups_token;
	}
	public String getAmazon_token() {
		return amazon_token;
	}
	public void setAmazon_token(String amazon_token) {
		this.amazon_token = amazon_token;
	}
	public Integer getAmazon() {
		return amazon;
	}
	public void setAmazon(Integer amazon) {
		this.amazon = amazon;
	}
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
	
	
	
}
