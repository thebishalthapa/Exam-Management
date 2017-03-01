package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.impl.SubjectDAOImpl;
import com.school.model.StudentClass;
import com.school.model.Subject;

@Service
public class SubjectService  {

	private SubjectDAOImpl subjectDAOImpl;

	@Autowired(required=true)
	public void setSubjectDAOImpl(SubjectDAOImpl subjectDAOImpl) {
		this.subjectDAOImpl = subjectDAOImpl;
	}
	public List<Subject> getAllSubject() {
		return subjectDAOImpl.getAllSubject();
	}
	public String createOrUpdate(Subject subject) {
		return subjectDAOImpl.createOrUpdate(subject);
	}
	public Subject getByID(int id) {
		return subjectDAOImpl.getByID(id);
	}
	public void deleteSubject(int id) {
	      subjectDAOImpl.deleteSubject(id);
	}
	public List<StudentClass> getAllClass() {
		return subjectDAOImpl.getAllClass();
	}
	
	public List<Subject> getByClassID(int id) {
	    return subjectDAOImpl.getByClassID(id);
	}

}
