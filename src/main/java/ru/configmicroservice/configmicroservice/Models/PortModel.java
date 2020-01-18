package ru.configmicroservice.configmicroservice.Models;

public class PortModel {

	public String microServiceName;
	public String port;
	
	public PortModel(String microServiceName,String port)
	{
		this.microServiceName=microServiceName;
		this.port=port;
	}
}
