package ru.configmicroservice.configmicroservice.PropertiesConfigurations;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.*;

@Component
@ConfigurationProperties(prefix="topics")
public class Topics {

	private String portTopic;
	private String roleTopic;
	private String subjectTopic;
	
	public String getPortTopic() {
		return portTopic;
	}
	public void setPortTopic(String portTopic) {
		this.portTopic = portTopic;
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
