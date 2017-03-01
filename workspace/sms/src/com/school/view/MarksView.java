package com.school.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.school.model.Exam;
import com.school.model.Student;
import com.school.model.StudentClass;
import com.school.model.Subject;



public class MarksView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Student> students = (List<Student>) model.get("students");
		List<Subject> subjects = (List<Subject>) model.get("subjects");
		Exam exam = (Exam) model.get("exam");
		StudentClass studentClass = (StudentClass) model.get("studentClass");

		String className = studentClass.getClassName();
		String examName = exam.getExamName();

		HSSFSheet sheet = workbook.createSheet("Marks Sheet");

		HSSFRow firstheader = sheet.createRow(0);
		firstheader.createCell(3).setCellValue("Class: ");

		HSSFRow header = sheet.createRow(2);
		header.createCell(0).setCellValue("Id");
		header.createCell(1).setCellValue("Student Name");
		header.createCell(2).setCellValue(" Roll   ");

		int hcounter = 3;
		for (Subject sub : subjects) {
			header.createCell(hcounter).setCellValue(sub.getSubjectName());
			hcounter++;
		}
		int counter = 3;
		int totalSub = subjects.size();
		for (Student s : students) {
			HSSFRow row = sheet.createRow(counter++);
			row.createCell(0).setCellValue(s.getStudentId());
			row.createCell(1).setCellValue(s.getFirstName() + " " + s.getLastName());
			row.createCell(2).setCellValue(s.getRoll());
			for (int i = 3; i < totalSub + 3; i++)
				row.createCell(i).setCellValue("0.0");

		}
		firstheader.createCell(3).setCellValue("Class : " + className);
		firstheader.createCell(6).setCellValue("Exam : " + examName);

		sheet.setColumnWidth(0, 2000);
		sheet.setColumnWidth(1, 6000);
		sheet.setColumnWidth(2, 2000);
	}

}
