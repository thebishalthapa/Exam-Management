package com.school.dao;

import java.util.List;

import com.school.model.Marks;

public interface MarksDAO {

	public String addList(List<Marks> marks);
	public String edit(List<Marks> marksList);
	public boolean isMarksSubmitted(int examId,int classId,int studentId);
}
