package ru.configmicroservice.configmicroservice.PropertiesConfigurations;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.*;

@Component
@ConfigurationProperties(prefix="topics")
public class Topics {

	private String microservicesInfoTopic;
	private String roleTopic;
	private String subjectTopic;
	
	public String getMicroservicesInfoTopic() {
		return microservicesInfoTopic;
	}
	public void setMicroservicesInfoTopic(String portTopic) {
		this.microservicesInfoTopic = portTopic;
	}
	public String getRoleTopic() {
		return roleTopic;
	}
	public void setRoleTopic(String roleTopic) {
		this.roleTopic = roleTopic;
	}
	public String getSubjectTopic() {
		return subjectTopic;
	}
	public void setSubjectTopic(String subjectTopic) {
		this.subjectTopic = subjectTopic;
	}
	
	
}
