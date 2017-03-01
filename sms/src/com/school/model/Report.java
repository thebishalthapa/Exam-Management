package com.school.model;

public class Report {
	
	private int classId;
	private int studentId;
	private int subjectId;
	private int examId;
	private String subjectName;
	private boolean hasPractical;
	private float fullThMarks;
	private float passThMarks;
	private float obtThMarks;
	private float fullPrMarks;
	private float passPrMarks;
	private float obtPrMarks;
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public boolean isHasPractical() {
		return hasPractical;
	}

	public void setHasPractical(boolean hasPractical) {
		this.hasPractical = hasPractical;
	}

	public float getFullThMarks() {
		return fullThMarks;
	}

	public void setFullThMarks(float fullThMarks) {
		this.fullThMarks = fullThMarks;
	}

	public float getPassThMarks() {
		return passThMarks;
	}

	public void setPassThMarks(float passThMarks) {
		this.passThMarks = passThMarks;
	}

	public float getObtThMarks() {
		return obtThMarks;
	}

	public void setObtThMarks(float obtThMarks) {
		this.obtThMarks = obtThMarks;
	}

	public float getFullPrMarks() {
		return fullPrMarks;
	}

	public void setFullPrMarks(float fullPrMarks) {
		this.fullPrMarks = fullPrMarks;
	}

	public float getPassPrMarks() {
		return passPrMarks;
	}

	public void setPassPrMarks(float passPrMarks) {
		this.passPrMarks = passPrMarks;
	}

	public float getObtPrMarks() {
		return obtPrMarks;
	}

	public void setObtPrMarks(float obtPrMarks) {
		this.obtPrMarks = obtPrMarks;
	}

	@Override
	public String toString() {
		return "Report [classId=" + classId + ", studentId=" + studentId + ", subjectId=" + subjectId + ", examId="
				+ examId + ", subjectName=" + subjectName + ", hasPractical=" + hasPractical + ", fullThMarks="
				+ fullThMarks + ", passThMarks=" + passThMarks + ", obtThMarks=" + obtThMarks + ", fullPrMarks="
				+ fullPrMarks + ", passPrMarks=" + passPrMarks + ", obtPrMarks=" + obtPrMarks + "]";
	}

		
}
