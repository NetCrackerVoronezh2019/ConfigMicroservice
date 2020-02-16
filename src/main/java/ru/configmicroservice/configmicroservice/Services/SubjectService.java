package ru.configmicroservice.configmicroservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import ru.configmicroservice.configmicroservice.Classes.SubjectServiceX;
import ru.configmicroservice.configmicroservice.Entitys.Subject;
import ru.configmicroservice.configmicroservice.Repositories.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	public SubjectServiceX getAllSubjects()
	{
		List<Subject> ex= subjectRepository.findAll();
		SubjectServiceX x=new SubjectServiceX();
		x.subjects=ex;
		return x;
	}
	
	public void addNewSubjects(List<Subject> _subjects)
	{
		subjectRepository.saveAll(_subjects);
	}
}
