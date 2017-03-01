package com.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.school.model.Exam;
import com.school.model.Marks;
import com.school.model.Report;
import com.school.model.Student;
import com.school.model.StudentClass;
import com.school.model.Subject;
import com.school.service.ExamService;
import com.school.service.MarksService;
import com.school.service.ReportService;
import com.school.service.StudentClassService;
import com.school.service.StudentService;
import com.school.service.SubjectService;

@Controller
@RequestMapping("marks")
public class MarksController  {

	private MarksService marksService;
	private StudentClassService studentClassService;
	private ExamService examService;
	private SubjectService subjectService;
	private StudentService studentService;
	private ReportService reportService;
	
	@Autowired
	public void setMarksService(MarksService marksService) {
		this.marksService = marksService;
	}
	@Autowired
	public void setStudentClassService(StudentClassService studentClassService) {
		this.studentClassService = studentClassService;
	}
	@Autowired
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	@Autowired
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
	@RequestMapping
	public String show(Model model){
		List<StudentClass> stdClassList = studentClassService.getAllClass();
		List<Exam> examList = examService.getAllExam();
		model.addAttribute("stdClassList",stdClassList);
		model.addAttribute("examList",examList);
		return "marks/marks";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addMarks(Model model,@RequestParam("classId") int classId,@RequestParam("examId") int examId) {
		if(classId!=0){
		List<Student> studentList = studentService.getAllStudentByClass(classId);
		List<Subject> subjectList = subjectService.getByClassID(classId);
		Exam exam = examService.getByID(examId);
		StudentClass studentClass= studentClassService.getByID(classId);
		
		List<Student> filterStdList = filterToAddtMarks(studentList, classId, examId);
		
		model.addAttribute("studentList",filterStdList);
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("exam",exam);
		model.addAttribute("studentClass",studentClass);
		}
		
		return "marks/add";
		
	}
	
    private List<Student> filterToAddtMarks(List<Student> stdList,int classId,int examId){
		 List<Student> filterStdList = new ArrayList<>();
		  for(Student s:stdList){
			  if(!marksService.isMarksSubmitted(examId, classId,s.getStudentId())){
				  filterStdList.add(s);
			  }
		  }
		 return filterStdList;
   }
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editMarks(Model model,@RequestParam("classId") int classId,@RequestParam("examId") int examId) {
		if(classId!=0){
		List<Student> studentList = studentService.getAllStudentByClass(classId);
		List<Subject> subjectList = subjectService.getByClassID(classId);
		Exam exam = examService.getByID(examId);
		StudentClass studentClass= studentClassService.getByID(classId);
		
		List<Student> filterStdList = filterToEditMarks(studentList, classId, examId);
		
		model.addAttribute("studentList",filterStdList);
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("exam",exam);
		model.addAttribute("studentClass",studentClass);
		}
		
		return "marks/edit";
		
	}
	
    private List<Student> filterToEditMarks(List<Student> stdList,int classId,int examId){
    	 List<Student> filterStdList = new ArrayList<>();
		  for(Student s:stdList){
			  if(marksService.isMarksSubmitted(examId, classId,s.getStudentId())){
				  filterStdList.add(s);
			  }
		  }
		 return filterStdList;
	 }
	
	@RequestMapping(value = "/addMarks", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody  
	public Map<String,Object> addNewMarks(@RequestBody  List<Marks> marksList){
		marksService.addList(marksList);
	    Map<String,Object> response = new HashMap<>();
	    response.put("status", "success");
		return response;
	}
	
	
	
	 @RequestMapping(value = "/marks_sheet", method = RequestMethod.GET)
	public ModelAndView generateExcel(@RequestParam("classId") int classId,@RequestParam("examId") int examId) throws Exception {
		 List<Student> studentList = studentService.getAllStudentByClass(classId);		 
		 List<Subject> subjectList = subjectService.getByClassID(classId);
		 StudentClass studentClass= studentClassService.getByID(classId);
		 Exam exam = examService.getByID(examId);
	     ModelAndView modelAndView = new ModelAndView("marksView");
	     modelAndView.addObject("students",studentList);
	     modelAndView.addObject("exam",exam);
	     modelAndView.addObject("studentClass",studentClass);
	     modelAndView.addObject("subjects",subjectList);
	     return modelAndView;
	 
	}
	 
	
	 @RequestMapping(value = "/editMarks", method = RequestMethod.GET)
		public String ediUpdateMarks(Model model,@RequestParam("classId") int classId,@RequestParam("examId") int examId,@RequestParam("studentId") int studentId) {
		 Student student = studentService.getByID(studentId);
			Exam exam = examService.getByID(examId);
			StudentClass studentClass= studentClassService.getByID(classId);
			List<Report> reportList = reportService.getReport(examId, classId, studentId);
			model.addAttribute("student",student);
			model.addAttribute("exam",exam);
			model.addAttribute("studentClass",studentClass);
			model.addAttribute("reportList",reportList);
			return "marks/editupdate";
			
		}
	 
	 
	 @RequestMapping(value = "/updateMarks", method = RequestMethod.POST,produces = "application/json")
		@ResponseBody  
		public Map<String,Object> updateMarks(@RequestBody  List<Marks> marksList){
			marksService.edit(marksList);
		    Map<String,Object> response = new HashMap<>();
		    response.put("status", "success");
			return response;
		}
	 
	






}
