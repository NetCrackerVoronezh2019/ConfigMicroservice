package ru.configmicroservice.configmicroservice.PropertiesConfigurations;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("subject")
public class Subjects {

	private List<String> allSubjects;

	public List<String> getAllSubjects() {
		return allSubjects;
	}

	public void setAllSubjects(List<String> allSubjects) {
		this.allSubjects = allSubjects;
	}
	
	@PostConstruct
    protected void init() {
        List<String> subjects=new ArrayList<>();
        subjects.add("Русский язак");
        subjects.add("Английский язык");
        subjects.add("Программирование");
        subjects.add("Физика");
        subjects.add("Информатика");
        subjects.add("Химия");
        this.setAllSubjects(subjects);
    }
	
}
