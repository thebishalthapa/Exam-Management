package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.impl.StudentDAOImpl;
import com.school.model.Student;
import com.school.model.StudentClass;

@Service
public class StudentService {

	private StudentDAOImpl studentDAOImpl;

	@Autowired(required=true)
	public void setStudentDAOImpl(StudentDAOImpl studentDAOImpl) {
		this.studentDAOImpl = studentDAOImpl;
	}

	
	public List<StudentClass> getAllClass() {
		return studentDAOImpl.getAllClass();
	}

	
	public List<Student> getAllStudent() {
		return studentDAOImpl.getAllStudent();
	}

	
	public String createOrUpdate(Student student) {
		return studentDAOImpl.createOrUpdate(student);
	}

	
	public Student getByID(int id) {
		return studentDAOImpl.getByID(id);
	}

	
	public void deleteStudent(int id) {
		studentDAOImpl.deleteStudent(id);
		
	}
	public List<Student> getAllStudentByClass(int id) {
	 return studentDAOImpl.getAllStudentByClass(id);
	}
	public List<Student> getClassStudent(int classId) {
		return studentDAOImpl.getClassStudent(classId);
	}
}
