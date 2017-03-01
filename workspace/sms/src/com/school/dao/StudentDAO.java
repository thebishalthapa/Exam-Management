package com.school.dao;

import java.util.List;

import com.school.model.Student;
import com.school.model.StudentClass;

public interface StudentDAO {

	public List<StudentClass> getAllClass();
	public List<Student> getAllStudent();
	public String createOrUpdate(Student student);
	public Student getByID(int id);
	public void deleteStudent(int id);
	public List<Student> getAllStudentByClass(int id);
	public List<Student> getClassStudent(int classId);
	
}
