package com.school.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.StudentDAO;
import com.school.model.Student;
import com.school.model.StudentClass;

@Repository("studentDAOImpl")
public class StudentDAOImpl implements StudentDAO {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	@Transactional
	@Override
	public List<StudentClass> getAllClass() {
		return jdbc.query("select * from class", new RowMapper<StudentClass>() {
			@Override
			public StudentClass mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				StudentClass studentClass = new StudentClass();
				studentClass.setClassId(rs.getInt("class_id"));
				studentClass.setClassName(rs.getString("class_name"));
				studentClass.setSection(rs.getString("section"));
				studentClass.setBatchDate(rs.getInt("batch_date"));
				return studentClass;
			}
		});
		
	}

	@Transactional
	@Override
	public List<Student> getAllStudent() {
		return jdbc.query("select * from student join class on student.class_id=class.class_id", new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setClassName(rs.getString("class_name"));
				student.setClassId(rs.getInt("class_id"));
				student.setRoll(rs.getString("roll"));
				student.setEmail(rs.getString("email"));
				student.setBloodGroup(rs.getString("blood_group"));
				student.setOrigin(rs.getString("origin"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setMotherName(rs.getString("mother_name"));
				student.setFatherName(rs.getString("father_name"));
				return student;
			}
		});
		
	}
	@Transactional
	@Override
	public String createOrUpdate(Student student) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);
		if (student.isStatus()) {
			System.out.println(student);
			
			jdbc.update("UPDATE student set class_id =:classId,last_name = :lastName,first_name = :firstName,birthday= :birthday, address=:address,phone=:phone, origin=:origin, blood_group=:bloodGroup,email=:email,roll=:roll,mother_name=:motherName,father_name=:fatherName where student_id = :studentId",
					params);
			
			return "Student updated sucessfully";
		} else {
			jdbc.update(
					"insert into student (class_id,last_name,first_name,birthday,address,phone,origin,blood_group,email,roll,mother_name,father_name)values(:classId,:lastName,:firstName,:birthday,:address,:phone,:origin,:bloodGroup,:email,:roll,:motherName,:fatherName)",
					params);
			return "Student added sucessfully";
		}
	}
	@Transactional
	@Override
	public Student getByID(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("Id", id);
	
		return jdbc.queryForObject("select * from student where student_id=:Id ", params, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int num) throws SQLException {
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setClassId(rs.getInt("class_id"));
				student.setRoll(rs.getString("roll"));
				student.setEmail(rs.getString("email"));
				student.setBloodGroup(rs.getString("blood_group"));
				student.setOrigin("origin");
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setMotherName(rs.getString("mother_name"));
				student.setFatherName(rs.getString("father_name"));
				return student;
			}

		});

	}

	@Transactional
	@Override
	public void deleteStudent(int id) {
		jdbc.update("delete from student where student_id=:id", new MapSqlParameterSource("id",id));
		
	}

	@Transactional
	@Override
	public List<Student> getAllStudentByClass(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("classId", id);
		return jdbc.query("select * from student where student.class_id=:classId", params,new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setClassId(rs.getInt("class_id"));
				student.setRoll(rs.getString("roll"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				return student;
			}
		});
	}
	@Transactional
	@Override
	public List<Student> getClassStudent(int classId) {
		return jdbc.query("select * from student join class on student.class_id=class.class_id where student.class_id="+classId, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setClassName(rs.getString("class_name"));
				student.setRoll(rs.getString("roll"));
				student.setEmail(rs.getString("email"));
				student.setBloodGroup(rs.getString("blood_group"));
				student.setOrigin(rs.getString("origin"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setMotherName(rs.getString("mother_name"));
				student.setFatherName(rs.getString("father_name"));
				return student;
			}
		});
		
	}

}
