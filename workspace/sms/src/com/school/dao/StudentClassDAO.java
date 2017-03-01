package com.school.dao;

import java.util.List;

import com.school.model.StudentClass;

public interface StudentClassDAO {
	
	public List<StudentClass> getAllClass();
	public String createOrUpdate(StudentClass c);
	public StudentClass getByID(int id);
	public void deleteClass(int id);
}
