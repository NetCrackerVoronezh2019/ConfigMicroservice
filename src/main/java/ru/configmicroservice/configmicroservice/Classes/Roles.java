package ru.configmicroservice.configmicroservice.Classes;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("role")
public class Roles {

	private List<String> allRoleNames;

	public List<String> getAllRoleNames() {
		return allRoleNames;
	}

	public void setAllRoleNames(List<String> allRoleNames) {
		this.allRoleNames = allRoleNames;
	}
	
	

	
}
