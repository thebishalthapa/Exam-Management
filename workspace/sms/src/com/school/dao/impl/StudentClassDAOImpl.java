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

import com.school.dao.StudentClassDAO;
import com.school.model.StudentClass;


@Repository("studentClassDAOImpl")
public class StudentClassDAOImpl implements StudentClassDAO {

	
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
	public String createOrUpdate(StudentClass c) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(c);
		if (c.isStatus()) {
			jdbc.update("UPDATE class set class_name = :className,section = :section, batch_date = :batchDate where class_id = :classId",
					params);
			
			return "Class updated sucessfully";
		} else {
			jdbc.update(
					"insert into class (class_name,section,batch_date)values(:className,:section,:batchDate)",
					params);
			return "Class added sucessfully";
		}
		
	}
	@Transactional
	@Override
	public StudentClass getByID(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		

		return jdbc.queryForObject("select * from class where class_id=:id ", params, new RowMapper<StudentClass>() {
			@Override
			public StudentClass mapRow(ResultSet rs, int num) throws SQLException {
				StudentClass studentClass = new StudentClass();
				studentClass.setBatchDate(rs.getInt("batch_date"));
				studentClass.setClassName(rs.getString("class_name"));
				studentClass.setClassId(rs.getInt("class_id"));
				studentClass.setSection(rs.getString("section"));
				return studentClass;
			}

		});

		
	}
	@Transactional
	@Override
	public void deleteClass(int id) {
		jdbc.update("delete from class where class_id=:id", new MapSqlParameterSource("id",id));
		
	}

	
}
