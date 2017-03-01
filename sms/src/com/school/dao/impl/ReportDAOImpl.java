package com.school.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.school.dao.ReportDAO;
import com.school.model.Report;

@Repository("reportDAOImpl")
public class ReportDAOImpl implements ReportDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	@Override
	public List<Report> getReport(int examId, int classId, int studentId) {
		return jdbc.query(" select class_id,student_id,exam_id,subject_id,subject_name,has_practical,full_tmarks,pass_tmarks,t_marks,full_pmarks, pass_pmarks,p_marks   from result where exam_id="+examId+" and class_id="+classId+" and student_id="+studentId+";", new RowMapper<Report>() {
			@Override
			public Report mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				Report report = new Report();
				report.setExamId(rs.getInt("exam_id"));
				report.setStudentId(rs.getInt("student_id"));
				report.setSubjectId(rs.getInt("subject_id"));
				report.setSubjectName(rs.getString("subject_name"));
				report.setExamId(rs.getInt("exam_id"));
				report.setHasPractical(rs.getBoolean("has_practical"));
				report.setFullThMarks(rs.getFloat("full_tmarks"));
				report.setPassThMarks(rs.getFloat("pass_tmarks"));
				report.setObtThMarks(rs.getFloat("t_marks"));
				report.setFullPrMarks(rs.getFloat("full_pmarks"));
				report.setPassPrMarks(rs.getFloat("pass_pmarks"));
				report.setObtPrMarks(rs.getFloat("p_marks"));
				return report;
			}
		});
	}
	

}
