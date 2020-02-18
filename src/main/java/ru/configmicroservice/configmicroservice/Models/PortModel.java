package ru.configmicroservice.configmicroservice.Models;

public class PortModel {
	
	private Microservices microserviceName;
	private Integer port;
	
	public Microservices getMicroserviceName() {
		return microserviceName;
	}
	public void setMicroserviceName(Microservices microserviceName) {
		this.microserviceName = microserviceName;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
}
