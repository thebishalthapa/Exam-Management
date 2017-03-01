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

import com.school.model.Exam;
import com.school.service.ExamService;

@Controller
@RequestMapping("exam")
public class ExamController {

	private ExamService examService;
	
	@Autowired
	public void setStudentClassService( ExamService examService) {
		this.examService =examService;
	}
	
	
	@RequestMapping
	public String show(Model model){
		List<Exam> examList = examService.getAllExam();
		model.addAttribute("examList",examList);
		return "exam/exam";
	}

	@RequestMapping(value = "/addupdate", method = RequestMethod.GET)
	public String addUpdateStudent(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		Exam exam = null;
		List<Exam> examList = examService.getAllExam();

		if (id != 0) {
			exam= examService.getByID(id);
			exam.setStatus(true);
			model.addAttribute("show", true);
		}
		if (exam == null) {
			exam= new Exam();
			model.addAttribute("examList", examList);
			model.addAttribute("show", false);
		}
		model.addAttribute("exam", exam);
		return "exam/addupdate";
		
	}
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String creatingProduct(@Valid Exam exam, BindingResult result, Model model,RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			return "exam/addupdate";

		}
		
		String message = examService.createOrUpdate(exam);
		List<Exam> examList = examService.getAllExam();
		model.addAttribute("examList", examList);
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/exam";
		
	}
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public String deleteExam(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
		examService.deleteExam(id);
		return "redirect:/exam";
	}

	
}
