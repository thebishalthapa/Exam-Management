package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.dao.impl.ReportDAOImpl;
import com.school.model.Report;

@Component
public class ReportService {


	private ReportDAOImpl reportDAOImpl;
	
	@Autowired(required=true)
	public void setReportDAOImpl(ReportDAOImpl reportDAOImpl) {
		this.reportDAOImpl = reportDAOImpl;
	}

	public List<Report> getReport(int examId, int classId, int studentId) {
		return reportDAOImpl.getReport(examId, classId, studentId);
	}
	
	
	
}
