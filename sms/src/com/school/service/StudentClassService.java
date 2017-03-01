package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.impl.StudentClassDAOImpl;
import com.school.model.StudentClass;

@Service
public class StudentClassService {

	private StudentClassDAOImpl studentClassDAOImpl;

	@Autowired(required=true)
	public void setStudentClassDAOImpl(StudentClassDAOImpl studentClassDAOImpl) {
		this.studentClassDAOImpl = studentClassDAOImpl;
	}
	public List<StudentClass> getAllClass() {
		return studentClassDAOImpl.getAllClass();
	}
	public String createOrUpdate(StudentClass c) {
		return studentClassDAOImpl.createOrUpdate(c);
	}
	public StudentClass getByID(int id) {
		return studentClassDAOImpl.getByID(id);
	}
	public void deleteClass(int id) {
	      studentClassDAOImpl.deleteClass(id);
	}
		
}
	
