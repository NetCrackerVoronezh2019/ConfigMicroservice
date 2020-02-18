package ru.configmicroservice.configmicroservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import ru.configmicroservice.configmicroservice.Entitys.Subject;
import ru.configmicroservice.configmicroservice.Repositories.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	
	public void addNewSubjects(List<Subject> _subjects)
	{
		subjectRepository.saveAll(_subjects);
	}
	
	public void save(Subject subject)
	{
		subjectRepository.save(subject);
	}
	
	public List<Subject> findAll()
	{
		return subjectRepository.findAll();
	}
}
