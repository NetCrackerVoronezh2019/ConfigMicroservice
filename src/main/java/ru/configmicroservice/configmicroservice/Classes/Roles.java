package ru.configmicroservice.configmicroservice.Classes;
import java.util.*;

public class Roles {
	public List<String> allRoles;
	
	public Roles()
	{
		allRoles=new ArrayList<String>();
		allRoles.add("ROLE_ADMIN");
		allRoles.add("ROLE_STUDENT");
		allRoles.add("ROLE_TEACHER");
		
	}
}
