package ru.configmicroservice.configmicroservice.Models;

public class MicroserviceInfo {
	
	private Microservices microserviceName;
	private Integer port;
	private String token;
	
	
	public MicroserviceInfo(Microservices _mName,Integer _port,String _token)
	{
		this.microserviceName=_mName;
		this.port=_port;
		this.token=_token;
	}
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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
