package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.dao.impl.MarksDAOImpl;
import com.school.model.Marks;

@Component
public class MarksService  {

	private MarksDAOImpl marksDAOImpl;
	
	@Autowired
	public void setMarksDAOImpl(MarksDAOImpl marksDAOImpl) {
		this.marksDAOImpl = marksDAOImpl;
	}	
	public String addList(List<Marks> marksList) {
		return marksDAOImpl.addList(marksList);
	}
	public String edit(List<Marks> marksList){
		return marksDAOImpl.edit(marksList);
	}
	public boolean isMarksSubmitted(int examId,int classId,int studentId){
		return marksDAOImpl.isMarksSubmitted(examId, classId, studentId);
	}

}
