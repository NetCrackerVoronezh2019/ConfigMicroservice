package ru.configmicroservice.configmicroservice.Models;

public class PortModel {

	public MicroservicesEnum microServiceName;
	public String port;
	
	public PortModel(MicroservicesEnum microServiceName,String port)
	{
		this.microServiceName=microServiceName;
		this.port=port;
	}
}
