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
import com.school.model.Subject;
import com.school.service.SubjectService;



@Controller
@RequestMapping("subject")
public class SubjectController {

	private SubjectService subjectService;
	
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService =subjectService;
	}
	
	@RequestMapping
	public String show(Model model){
		List<Subject> subjectList = subjectService.getAllSubject();
		for(Subject sc : subjectList) System.out.println(sc);
		model.addAttribute("subjectList",subjectList);
		return "subject/subject";
	}
	
	@RequestMapping(value = "/addupdate", method = RequestMethod.GET)
	public String addUpdateStudent(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		Subject subject = null;
		List<StudentClass> stdClassList = subjectService.getAllClass();

		if (id != 0) {
			subject = subjectService.getByID(id);
			subject.setStatus(true);
			model.addAttribute("show", true);
		}
		if (subject == null) {
			subject= new Subject();
			model.addAttribute("stdClassList", stdClassList);
			model.addAttribute("show", false);
		}
		model.addAttribute("subject", subject);
		return "subject/addupdate";
		
	}
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String creatingProduct(@Valid Subject Subject, BindingResult result, Model model,RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			return "subject/addupdate";

		}
		System.out.println(Subject.isStatus());
		String message = subjectService.createOrUpdate(Subject);
		
		List<Subject> subjectList = subjectService.getAllSubject();
		model.addAttribute("subjectist", subjectList);
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/subject";
		
	}
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public String deleteUser(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		System.out.println(id);
		subjectService.deleteSubject(id);
		return "redirect:/subject";
	}
}
