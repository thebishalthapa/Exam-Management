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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.school.model.StudentClass;
import com.school.service.StudentClassService;



@Controller
@RequestMapping("studentclass")
public class StudentClassController {

	private StudentClassService studentClassService;
	
	@Autowired
	public void setStudentClassService(StudentClassService studentClassService) {
		this.studentClassService =studentClassService;
	}
	
	@RequestMapping
	public String show(Model model){
		List<StudentClass> classList = studentClassService.getAllClass();
		for(StudentClass sc : classList) System.out.println(sc);
		model.addAttribute("classList",classList);
		return "class/class";
	}
	
	@RequestMapping(value = "/addupdate", method = RequestMethod.GET)
	public String addUpdateStudent(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		StudentClass studentClass = null;
		if (id != 0) {
			studentClass = studentClassService.getByID(id);
			studentClass.setStatus(true);
			model.addAttribute("show", true);
		}
		if (studentClass == null) {
			studentClass= new StudentClass();
			model.addAttribute("show", false);
		}

		model.addAttribute("studentClass", studentClass);
		return "class/addupdate";
		
	}
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String creatingProduct(@Valid StudentClass studentClass, BindingResult result, Model model,RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			return "class/addupdate";

		}
		String message = studentClassService.createOrUpdate(studentClass);
		List<StudentClass> classList = studentClassService.getAllClass();
		model.addAttribute("classList", classList);
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/studentclass";
		
		}
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public String deleteUser(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		studentClassService.deleteClass(id);
		return "redirect:/studentclass";
	}
}
