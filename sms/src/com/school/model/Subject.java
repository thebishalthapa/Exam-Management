package com.school.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Subject {
	
	private boolean isStatus;
	private int subjectId;
	private int classId;
	@NotEmpty
	private String subjectName;
	private boolean hasPractical;
	@NumberFormat(style=Style.NUMBER)
	private float fullThMarks;
	@NumberFormat(style=Style.NUMBER)
	private float fullPrMarks;
	@NumberFormat(style=Style.NUMBER)
	private float passThMarks;
	@NumberFormat(style=Style.NUMBER)
	private float passPrMarks;
	
	private String className;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int subjectId, int classId, String subjectName, boolean hasPractical, float fullThMarks,
			float fullPrMarks, float passThMarks, float passPrMarks) {
		super();
		this.subjectId = subjectId;
		this.classId = classId;
		this.subjectName = subjectName;
		this.hasPractical = hasPractical;
		this.fullThMarks = fullThMarks;
		this.fullPrMarks = fullPrMarks;
		this.passThMarks = passThMarks;
		this.passPrMarks = passPrMarks;
	}
    
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
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

	public float getFullPrMarks() {
		return fullPrMarks;
	}

	public void setFullPrMarks(float fullPrMarks) {
		this.fullPrMarks = fullPrMarks;
	}

	public float getPassThMarks() {
		return passThMarks;
	}

	public void setPassThMarks(float passThMarks) {
		this.passThMarks = passThMarks;
	}

	public float getPassPrMarks() {
		return passPrMarks;
	}

	public void setPassPrMarks(float passPrMarks) {
		this.passPrMarks = passPrMarks;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", classId=" + classId + ", subjectName=" + subjectName
				+ ", hasPractical=" + hasPractical + ", fullThMarks=" + fullThMarks + ", fullPrMarks=" + fullPrMarks
				+ ", passThMarks=" + passThMarks + ", passPrMarks=" + passPrMarks + "]";
	}

	public boolean isStatus() {
		return isStatus;
	}

	public void setStatus(boolean isStatus) {
		this.isStatus = isStatus;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
}
