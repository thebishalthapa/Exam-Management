package com.school.dao;

import java.util.List;

import com.school.model.Report;

public interface ReportDAO {

	public List<Report> getReport(int examId,int classId,int studentId);
}
