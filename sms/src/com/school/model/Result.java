package com.school.model;

public class Result {
	
	private int classId;
	private int studentId;
	private int subjectId;
	private int examId;
	private String examName;
	private String examDate;
	private String className;
	private String stdFirstName;
	private String stdSecondName;
	private String roll;
	private String subjectName;
	private boolean hasPractical;
	private float fullThMarks;
	private float passThMarks;
	private float obtThMarks;
	private float fullPrMarks;
	private float passPrMarks;
	private float obtPrMarks;
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(int classId, int studentId, int subjectId, int examId, String examName, String examDate,
			String className, String stdFirstName, String stdSecondName, String roll, String subjectName,
			boolean hasPractical, float fullThMarks, float passThMarks, float obtThMarks, float fullPrMarks,
			float passPrMarks, float obtPrMarks) {
		super();
		this.classId = classId;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.examId = examId;
		this.examName = examName;
		this.examDate = examDate;
		this.className = className;
		this.stdFirstName = stdFirstName;
		this.stdSecondName = stdSecondName;
		this.roll = roll;
		this.subjectName = subjectName;
		this.hasPractical = hasPractical;
		this.fullThMarks = fullThMarks;
		this.passThMarks = passThMarks;
		this.obtThMarks = obtThMarks;
		this.fullPrMarks = fullPrMarks;
		this.passPrMarks = passPrMarks;
		this.obtPrMarks = obtPrMarks;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStdFirstName() {
		return stdFirstName;
	}

	public void setStdFirstName(String stdFirstName) {
		this.stdFirstName = stdFirstName;
	}

	public String getStdSecondName() {
		return stdSecondName;
	}

	public void setStdSecondName(String stdSecondName) {
		this.stdSecondName = stdSecondName;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
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
		return "Result [classId=" + classId + ", studentId=" + studentId + ", subjectId=" + subjectId + ", examId="
				+ examId + ", examName=" + examName + ", examDate=" + examDate + ", className=" + className
				+ ", stdFirstName=" + stdFirstName + ", stdSecondName=" + stdSecondName + ", roll=" + roll
				+ ", subjectName=" + subjectName + ", hasPractical=" + hasPractical + ", fullThMarks=" + fullThMarks
				+ ", passThMarks=" + passThMarks + ", obtThMarks=" + obtThMarks + ", fullPrMarks=" + fullPrMarks
				+ ", passPrMarks=" + passPrMarks + ", obtPrMarks=" + obtPrMarks + "]";
	}
	
	
	
	
}
