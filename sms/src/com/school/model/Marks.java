package com.school.model;

public class Marks {

	private int marksId;
	private int studentId;
	private int classId;
	private int examId;
	private int subjectId;
	private float practicalMarks;
	private float theoryMarks;
	
	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Marks(int marksId, int studentId, int classId, int examId, int subjectId, float practicalMarks,
			float theoryMarks) {
		super();
		this.marksId = marksId;
		this.studentId = studentId;
		this.classId = classId;
		this.examId = examId;
		this.subjectId = subjectId;
		this.practicalMarks = practicalMarks;
		this.theoryMarks = theoryMarks;
	}

	public int getMarksId() {
		return marksId;
	}

	public void setMarksId(int marksId) {
		this.marksId = marksId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public float getPracticalMarks() {
		return practicalMarks;
	}

	public void setPracticalMarks(float practicalMarks) {
		this.practicalMarks = practicalMarks;
	}

	public float getTheoryMarks() {
		return theoryMarks;
	}

	public void setTheoryMarks(float theoryMarks) {
		this.theoryMarks = theoryMarks;
	}

	@Override
	public String toString() {
		return "Marks [marksId=" + marksId + ", studentId=" + studentId + ", classId=" + classId + ", examId=" + examId
				+ ", subjectId=" + subjectId + ", practicalMarks=" + practicalMarks + ", theoryMarks=" + theoryMarks
				+ "]";
	}
	
	
	
}
