package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.impl.ExamDAOImpl;
import com.school.model.Exam;

@Service
public class ExamService{

	private ExamDAOImpl examDAOImpl;

	@Autowired(required=true)
	public void setExamDAOImpl(ExamDAOImpl examDAOImpl) {
		this.examDAOImpl = examDAOImpl;
	}
	public List<Exam> getAllExam() {
		return examDAOImpl.getAllExam();
	}
	public String createOrUpdate(Exam exam) {
		return examDAOImpl.createOrUpdate(exam);
	}
	public Exam getByID(int id) {
		
		return examDAOImpl.getByID(id);
	}

	public void deleteExam(int id) {
		examDAOImpl.deleteExam(id);
		
	}
}
