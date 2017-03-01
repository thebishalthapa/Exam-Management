package com.school.model;


public class Student {

	private int studentId;
	private int classId;
	private String  roll;
	private String email;
	private String bloodGroup;
	private String origin;
	private String phone;
	private String address;
	private String birthday;
	private String firstName;
	private String lastName;
	private boolean status;
	private String className;
	private String motherName;
	private String fatherName;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int student, int classId, String roll, String email, String bloodGroup, String origin,
			String phone, String address, String birthday, String firstName, String lastName) {
		super();
		this.studentId = student;
		this.classId = classId;
		this.roll = roll;
		this.email = email;
		this.bloodGroup = bloodGroup;
		this.origin = origin;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [studenId=" + studentId + ", classId=" + classId + ", roll=" + roll + ", email=" + email
				+ ", bloodGroup=" + bloodGroup + ", origin=" + origin + ", phone=" + phone + ", address=" + address
				+ ", birthday=" + birthday + ", firstName=" + firstName + ", lastName=" + lastName + ", status="
				+ status + ", className=" + className + "]";
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	
		
		
	
}
