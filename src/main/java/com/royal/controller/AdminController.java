package com.royal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.royal.bean.ExamBean;
import com.royal.bean.QuestionBean;
import com.royal.dao.ExamDao;


@Controller
public class AdminController {
	
	@Autowired
	ExamDao dao;
	
	@RequestMapping(value = "/adminLogin",method = RequestMethod.GET)
	public String adminLogin()
	{
		return "Admin";
	}
	
	
	@RequestMapping(value = "/addExam",method = RequestMethod.GET)
	public String addExam(Model model)
	{
		ExamBean bean=new ExamBean();
		model.addAttribute("ExamBean",bean);
		return "Exam";
	}	
	
	@RequestMapping(value = "insertExam",method =RequestMethod.POST)
	public String insertExam(ExamBean bean)
	{
		dao.insertExam(bean);
		return  "redirect:/adminLogin";
	}
	@RequestMapping(value = "/showexam",method = RequestMethod.GET)
	public String showExam(Model model)
	{
		List<ExamBean>list=dao.getExam();
		model.addAttribute("examList",list);
		return "showExam";
	}
	@RequestMapping(value = "deleteExam/{examid}",method = RequestMethod.GET)
	public String deleteExam(@PathVariable("examid")int examid,ExamBean bean)
	{
		bean=dao.getById(examid);
		dao.deleteExam(bean);
		return "redirect:/showexam";
		
	}	
	
	@RequestMapping(value = "editExam/{id}",method = RequestMethod.GET)
	public String editExam(@PathVariable("id")int examid,ExamBean bean,Model model)
	{
		bean=dao.getById(examid);
		model.addAttribute("examBean",bean);
		return "Update";
		
	}	
	
	@RequestMapping(value = "updateExam",method = RequestMethod.POST)
	public String updateExam(ExamBean bean)
	{
		dao.update(bean);
		return "redirect:/showexam";
		
	}	
	
	@RequestMapping(value = "/loadexam",method =RequestMethod.GET)
	public String loadExam(Model model)
	{
		QuestionBean bean=new QuestionBean();
		List<ExamBean> list=dao.getExam();
		model.addAttribute("examList",list);
		model.addAttribute("questionBean",bean);
		return"QuestionInsert";
	}
	
	@RequestMapping(value = "/insertQuestion",method =RequestMethod.POST)
	public String insertQuestion(QuestionBean bean)
	{
		dao.insertQuestion(bean);
		return"redirect:/loadexam";
	}
	
	@RequestMapping(value = "/exit",method =RequestMethod.GET)
	public String exit()
	{
		return"redirect:/adminLogin";
	}
}
