package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.model.Student;
import com.school.model.StudentClass;
import com.school.service.StudentClassService;
import com.school.service.StudentService;

@Controller
@RequestMapping("fee")
public class FeeController {
	private StudentClassService studentClassService;
	private StudentService studentService;
	
	@Autowired
	public void setStudentClassService(StudentClassService studentClassService) {
		this.studentClassService = studentClassService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@RequestMapping
	public String show(Model model){
		List<StudentClass> stdClassList = studentClassService.getAllClass();
		model.addAttribute("stdClassList",stdClassList);
		return "fee/fee";
	}
	@RequestMapping(value = "/showStudentList", method = RequestMethod.GET)
	public String showStudent(Model model,@RequestParam("classId") int classId) {
		if(classId!=0){
		List<Student> studentList = studentService.getAllStudentByClass(classId);
		StudentClass studentClass= studentClassService.getByID(classId);
		model.addAttribute("studentList", studentList);
		model.addAttribute("studentClass",studentClass);
		}
		return "fee/studentList";
	}
	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public String bill(Model model,@RequestParam("classId") int classId,@RequestParam("studentId") int stdId) {
		
		return "fee/bill";
	}
	
}
