package com.school.dao;

import java.util.List;

import com.school.model.Exam;

public interface ExamDAO {

	public List<Exam> getAllExam();
	public String createOrUpdate(Exam exam);
	public Exam getByID(int id);
	public void deleteExam(int id);
}
