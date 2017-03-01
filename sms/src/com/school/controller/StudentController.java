package com.school.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.school.model.Student;
import com.school.model.StudentClass;
import com.school.service.StudentClassService;
import com.school.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	private StudentService studentService;
	private StudentClassService studentClassService;
	
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService =studentService;
	}
	
	@Autowired
	public void setStudentClassService(StudentClassService studentClassService) {
		this.studentClassService = studentClassService;
	}
	
	@RequestMapping
	public String show(Model model){
		List<Student> studentList = studentService.getAllStudent();
		List<StudentClass> stdClassList = studentClassService.getAllClass();
		model.addAttribute("stdClassList",stdClassList);
		model.addAttribute("studentList",studentList);
		return "student/student";
	}
	
	@RequestMapping(value = "/addupdate", method = RequestMethod.GET)
	public String addUpdateStudent(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		Student student = null;
		List<StudentClass> stdClassList = studentService.getAllClass();

		if (id != 0) {
			student = studentService.getByID(id);
			student.setStatus(true);
			model.addAttribute("show", true);
		}
		if (student == null) {
			student = new Student();
			model.addAttribute("stdClassList", stdClassList);
			model.addAttribute("show", false);
		}
		model.addAttribute("student", student);
		return "student/addupdate";
		
	}
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String creatingProduct(@Valid Student student, BindingResult result, Model model,RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			return "student/addupdate";

		}
		String message = studentService.createOrUpdate(student);
		List<Student> studentList = studentService.getAllStudent();
		List<StudentClass> stdClassList = studentService.getAllClass();
		model.addAttribute("studentList", studentList);
		model.addAttribute("stdClassList", stdClassList);
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/student";
		
		}
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public String deleteUser(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		studentService.deleteStudent(id);
		return "redirect:/student";
	}

	@RequestMapping(value = "/student_details", method = RequestMethod.GET)
	public ModelAndView addMarks(Model model,@RequestParam("classId") int classId) {
		 List<Student> studentList = studentService.getClassStudent(classId);		 
	     ModelAndView modelAndView = new ModelAndView("studentView");
	     modelAndView.addObject("students",studentList);
	     return modelAndView;
	}
}
