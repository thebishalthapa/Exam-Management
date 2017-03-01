package com.school.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.school.model.Student;

public class StudentView extends AbstractExcelView  {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
		  HttpServletResponse response) throws Exception {

		  List<Student> students = (List<Student>) model.get("students");
		  HSSFSheet sheet = workbook.createSheet("Student ");
		  sheet.autoSizeColumn(1000000);
		  HSSFRow header = sheet.createRow(0);
		  header.createCell(0).setCellValue("Id");
		  header.createCell(1).setCellValue("Student Name");
		  header.createCell(2).setCellValue(" Roll   ");
		  header.createCell(3).setCellValue(" Father Name  ");
		  header.createCell(4).setCellValue(" Mother Name  ");
		  header.createCell(5).setCellValue(" Address ");
		  header.createCell(6).setCellValue(" Contact ");
		  header.createCell(7).setCellValue(" Email ");
		  header.createCell(8).setCellValue(" Origin ");
		  header.createCell(9).setCellValue(" Blood Group ");
		  header.createCell(10).setCellValue(" D.O.B ");
		  
		  
		  
		  int counter = 1;
		  for (Student s : students) {
		   HSSFRow row = sheet.createRow(counter++);
		   row.createCell(0).setCellValue(s.getStudentId());	
		   row.createCell(1).setCellValue(s.getFirstName()+" "+s.getLastName());
		   row.createCell(2).setCellValue(s.getRoll());
		   row.createCell(3).setCellValue(s.getFatherName());
		   row.createCell(4).setCellValue(s.getMotherName());
		   row.createCell(5).setCellValue(s.getAddress());
		   row.createCell(6).setCellValue(s.getPhone());
		   row.createCell(7).setCellValue(s.getEmail());
		   row.createCell(8).setCellValue(s.getOrigin());
		   row.createCell(9).setCellValue(s.getBloodGroup());
		   row.createCell(10).setCellValue(s.getBirthday());
		  }
		 
		  sheet.setColumnWidth(0,2000);
		  sheet.setColumnWidth(1, 6500);
		  sheet.setColumnWidth(2, 2000);
		  sheet.setColumnWidth(3, 6500);
		  sheet.setColumnWidth(4, 6500);
		  sheet.setColumnWidth(5, 7500);
		  sheet.setColumnWidth(6, 4500);
		  sheet.setColumnWidth(7, 6500);
		  sheet.setColumnWidth(9, 4500);
		  sheet.setColumnWidth(10, 4500);

		  
	}

}
