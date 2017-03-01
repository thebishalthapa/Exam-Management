package com.school.model;

public class Exam {

	private boolean status;
	private int examId;
	private String examName;
	private String examDate;
	private String description;
	
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam(int examId, String examName, String examDate, String description) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.examDate = examDate;
		this.description = description;
	}

	
	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", examDate=" + examDate + ", description="
				+ description + "]";
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
