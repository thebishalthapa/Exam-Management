package com.school.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StudentClass {

	private boolean status;
	private int classId;
	
	@NotEmpty
	private String className;
	@NotEmpty
	private String section;
	@NotNull
	private int batchDate;
	
	public StudentClass() {
	}

	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(int batchDate) {
		this.batchDate = batchDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StudentClass [status=" + status + ", classId=" + classId + ", className=" + className + ", section="
				+ section + ", batchDate=" + batchDate + "]";
	}
	
	
    	
	
}
