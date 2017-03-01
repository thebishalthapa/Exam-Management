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

import com.school.dao.ExamDAO;
import com.school.model.Exam;


@Repository("examDAOImpl")
public class ExamDAOImpl implements ExamDAO{

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	@Transactional
	@Override
	public List<Exam> getAllExam() {
		return jdbc.query("select * from exam", new RowMapper<Exam>() {
			@Override
			public Exam mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				Exam exam = new Exam();
				exam.setExamId(rs.getInt("exam_id"));
				exam.setExamDate(rs.getString("exam_date"));
				exam.setExamName(rs.getString("exam_name"));
				exam.setDescription(rs.getString("description"));
				return exam;
		};
		});
	}

   
	@Transactional
	@Override
	public String createOrUpdate(Exam exam) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(exam);
		if (exam.isStatus()) {
			jdbc.update("UPDATE exam set exam_name = :examName,exam_date = :examDate, description = :description where exam_id = :examId",
					params);
			
			return "Exam updated sucessfully";
		} else {
			jdbc.update(
					"insert into exam (exam_name,exam_date,description)values(:examName,:examDate,:description)",
					params);
			return "Class added sucessfully";
		}
	}
	@Transactional
	@Override
	public Exam getByID(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("Id", id);
	
		return jdbc.queryForObject("select * from exam where exam_id=:Id ", params, new RowMapper<Exam>() {
			@Override
			public Exam mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				Exam exam = new Exam();
				exam.setExamId(rs.getInt("exam_id"));
				exam.setExamDate(rs.getString("exam_date"));
				exam.setExamName(rs.getString("exam_name"));
				exam.setDescription(rs.getString("description"));
				return exam;
		};
		});
	}
	

	@Override
	public void deleteExam(int id) {
		System.out.println(id);
		jdbc.update("delete from exam where exam_id=:id", new MapSqlParameterSource("id",id));
		
	}

}
