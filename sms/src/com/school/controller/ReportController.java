package com.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.model.Exam;
import com.school.model.Report;
import com.school.model.Student;
import com.school.model.StudentClass;
import com.school.service.ExamService;
import com.school.service.MarksService;
import com.school.service.ReportService;
import com.school.service.StudentClassService;
import com.school.service.StudentService;

@Controller
@RequestMapping(value="report")
public class ReportController {

	private StudentClassService studentClassService;
	private ExamService examService;
	private StudentService studentService;
	private ReportService reportService;
	private MarksService marksService;
	
	@Autowired
	public void setMarksService(MarksService marksService) {
		this.marksService = marksService;
	}
	@Autowired
	public void setStudentClassService(StudentClassService studentClassService) {
		this.studentClassService = studentClassService;
	}
	@Autowired
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@Autowired
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	@RequestMapping
	public String show(Model model){
		List<StudentClass> stdClassList = studentClassService.getAllClass();
		List<Exam> examList = examService.getAllExam();
		model.addAttribute("stdClassList",stdClassList);
		model.addAttribute("examList",examList);
		return "report/report";
	}
	@RequestMapping(value = "/showStudentList", method = RequestMethod.GET)
	public String addMarks(Model model,@RequestParam("classId") int classId,@RequestParam("examId") int examId) {
		if(classId!=0){
		List<Student> studentList = studentService.getAllStudentByClass(classId);
		Exam exam = examService.getByID(examId);
		StudentClass studentClass= studentClassService.getByID(classId);
		List<Student> filterList = filterToPrintReport(studentList, classId, examId);
		model.addAttribute("studentList", filterList);
		model.addAttribute("exam",exam);
		model.addAttribute("studentClass",studentClass);
		}
		return "report/studentList";
		
	}

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String print(Model model,@RequestParam("examId") int examId,@RequestParam("classId") int classId, @RequestParam("studentId") int studentId) {
		Student student = studentService.getByID(studentId);
		Exam exam = examService.getByID(examId);
		StudentClass studentClass= studentClassService.getByID(classId);
		List<Report> reportList = reportService.getReport(examId, classId, studentId);
		model.addAttribute("student",student);
		model.addAttribute("exam",exam);
		model.addAttribute("studentClass",studentClass);
		model.addAttribute("reportList",reportList);
		return "report/print";
	}
	
	 private List<Student> filterToPrintReport(List<Student> stdList,int classId,int examId){
    	 List<Student> filterStdList = new ArrayList<>();
		  for(Student s:stdList){
			  if(marksService.isMarksSubmitted(examId, classId,s.getStudentId())){
				  filterStdList.add(s);
			  }
		  }
		 return filterStdList;
	 }
	
}
