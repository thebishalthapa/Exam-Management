package com.school.dao;

import java.util.List;

import com.school.model.StudentClass;
import com.school.model.Subject;

public interface SubjectDAO {
	
	public List<StudentClass> getAllClass();
	public List<Subject> getAllSubject();
	public String createOrUpdate(Subject subject);
	public Subject getByID(int id);
	public List<Subject> getByClassID(int id);
	public void deleteSubject(int id);
}
