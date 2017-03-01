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

import com.school.dao.SubjectDAO;
import com.school.model.StudentClass;
import com.school.model.Subject;

@Repository("subjectDAOImpl")
public class SubjectDAOImpl implements SubjectDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	@Override
	public List<Subject> getAllSubject() {
		return jdbc.query("select * from subject join class on subject.class_id=class.class_id", new RowMapper<Subject>() {
			@Override
			public Subject mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				Subject subject = new Subject();
				subject.setClassId(rs.getInt("class_id"));
				subject.setClassName(rs.getString("class_name"));
				subject.setSubjectId(rs.getInt("subject_id"));
				subject.setSubjectName(rs.getString("subject_name"));
				subject.setHasPractical(rs.getBoolean("has_practical"));
				subject.setFullThMarks(rs.getFloat("full_tmarks"));
				subject.setPassThMarks(rs.getFloat("pass_tmarks"));
				subject.setFullPrMarks(rs.getFloat("full_pmarks"));
				subject.setPassPrMarks(rs.getFloat("pass_pmarks"));
				return subject;
			}
		});
	}
	@Transactional
	@Override
	public String createOrUpdate(Subject subject) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(subject);
		if (subject.isStatus()) {
			System.out.println(subject);
			
			jdbc.update("UPDATE subject set class_id =:classId,subject_name = :subjectName,has_practical = :hasPractical ,full_tmarks = :fullThMarks, pass_tmarks=:passThMarks,full_pmarks=:fullPrMarks, pass_pmarks=:passPrMarks where subject_id = :subjectId",
					params);
			
			return "Subject updated sucessfully";
		} else {
			jdbc.update(
					"insert into subject (class_id,subject_name,has_practical,full_tmarks,full_pmarks,pass_tmarks,pass_pmarks)values(:classId,:subjectName,:hasPractical,:fullThMarks,:fullPrMarks,:passThMarks,:passPrMarks)",
					params);
			return "Subject added sucessfully";
		}
	}
	@Transactional
	@Override
	public Subject getByID(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("subjectId", id);
	
		return jdbc.queryForObject("select * from subject where subject_id=:subjectId ", params, new RowMapper<Subject>() {
			@Override
			public Subject mapRow(ResultSet rs, int num) throws SQLException {
				Subject subject = new Subject();
				subject.setClassId(rs.getInt("class_id"));
				subject.setSubjectId(rs.getInt("subject_id"));
				subject.setSubjectName(rs.getString("subject_name"));
				subject.setHasPractical(rs.getBoolean("has_practical"));
				subject.setFullThMarks(rs.getFloat("full_tmarks"));
				subject.setPassThMarks(rs.getFloat("pass_tmarks"));
				subject.setFullPrMarks(rs.getFloat("full_pmarks"));
				subject.setPassPrMarks(rs.getFloat("pass_pmarks"));
				return subject;
			}

		});

	}
	@Transactional
	@Override
	public void deleteSubject(int id) {
		jdbc.update("delete from subject where subject_id=:id", new MapSqlParameterSource("id",id));
		
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

	@Override
	public List<Subject> getByClassID(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("classId", id);
		return jdbc.query("select * from subject where  subject.class_id =:classId", params,new RowMapper<Subject>() {
			@Override
			public Subject mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				Subject subject = new Subject();
				subject.setClassId(rs.getInt("class_id"));
				subject.setSubjectId(rs.getInt("subject_id"));
				subject.setSubjectName(rs.getString("subject_name"));
				subject.setHasPractical(rs.getBoolean("has_practical"));
				return subject;
			}
		});
	}

}
