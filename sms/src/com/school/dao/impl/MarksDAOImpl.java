package com.school.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.MarksDAO;
import com.school.model.Marks;

@Repository("marksDAOImpl")
public class MarksDAOImpl implements MarksDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	@Transactional
	@Override
	public String addList(List<Marks> marksList) {
		for(Marks m:marksList){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(m);
		jdbc.update("insert into marks (student_id,class_id,exam_id,subject_id,p_marks,t_marks)values(:studentId,:classId,:examId,:subjectId,:practicalMarks,:theoryMarks)",
				params);
		}
		return "Success";
	}
	@Transactional
	@Override
	public String edit(List<Marks> marksList) {
		for(Marks m:marksList){
			BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(m);
			jdbc.update("update marks set t_marks=:theoryMarks, p_marks=:practicalMarks where student_id=:studentId and class_id=:classId and subject_id=:subjectId and exam_id=:examId",
					params);
			}
			return "Success";
		
	}
	@Override
	public boolean isMarksSubmitted(int examId,int classId,int studentId){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("examId", examId);
		params.addValue("classId", classId);
		params.addValue("studentId", studentId);
		Marks marks=null;
		try{
		marks = (Marks) jdbc.queryForObject(" select student_id  from marks where exam_id=:examId and class_id=:classId and student_id=:studentId  limit 1", params,new RowMapper<Marks>() {
			@Override
			public Marks mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				Marks marks = new Marks();
				marks.setStudentId(rs.getInt("student_id"));
				return marks;
			}
		});
		}
		catch(EmptyResultDataAccessException ex){
			marks=null;
		}
		
		System.out.println("Marks: "+marks);
		if(marks==null) return false;
		return true;
		
	}

}
