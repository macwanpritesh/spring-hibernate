package com.royal.controller;



import java.util.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.royal.bean.ExamBean;
import com.royal.bean.QuestionBean;
import com.royal.bean.UserBean;
import com.royal.bean.UserExamBean;
import com.royal.bean.UserExamBeanList;
import com.royal.dao.*;

@Controller
public class UserController {
	
	@Autowired
	UserDao dao;
	@Autowired
	ExamDao dao1;
	
	@RequestMapping(value = "/registerUser",method = RequestMethod.GET)
	public String login(Model model)
	{
		UserBean bean=new UserBean();
		model.addAttribute("userBean",bean);
		return "Register";
	}
	
	@RequestMapping(value = "/insertUser",method =RequestMethod.POST)
	public String insertUser(UserBean bean,Model model)
	{
		dao.insert(bean);

		ExamBean examBean=new ExamBean();
		 List<ExamBean> list=dao1.getExam();
		 model.addAttribute("examList",list);
		 model.addAttribute("examBean",examBean);
		return "User";
	}
	
	@RequestMapping(value = "/loginUser",method =RequestMethod.GET)
	public String loginUser(Model model)
	{
		UserBean bean=new UserBean();
		model.addAttribute("userBean",bean);
		return "Login";
	}
	
	@RequestMapping(value = "/enrollUser",method =RequestMethod.POST)
	public String enrollUser(UserBean bean,Model model,HttpSession session)
	{
		List<UserBean>userBeans=dao.validateUser(bean);
		int size=userBeans.size();
		if(size==0)
		{
			return "redirect:/registerUser";
		}
		else {
		bean=userBeans.get(0);
		System.out.println("userId:"+bean.getUserId());
		int userId=bean.getUserId();
		session.setAttribute("userId", userId);
		ExamBean examBean=new ExamBean();
		 List<ExamBean> list=dao1.getExam();
		 model.addAttribute("examList",list);
		 model.addAttribute("examBean",examBean);
		return "User";
		}
	}	
	
	@RequestMapping(value = "enterExam",method =RequestMethod.POST )
	public String enterExam(ExamBean bean,Model model,HttpSession session)
	{
		
		int id=bean.getExamid();
		ExamBean examBean =dao1.getById(id);
		int userId=(Integer)session.getAttribute("userId");
		UserBean userBean=new UserBean();
		userBean.setUserId(userId);
	    System.out.println("size:"+examBean.getQueBean().size());
		UserExamBeanList examBeanList=new UserExamBeanList();
		List<UserExamBean>examBeans=new ArrayList<UserExamBean>();
		for(QuestionBean questionBean:examBean.getQueBean())
		{
			UserExamBean userExamBean=new UserExamBean();
			userExamBean.setExamBean(examBean);
			System.out.println("question:"+questionBean);
			userExamBean.setQuestionBean(questionBean);
			userExamBean.setUserBean(userBean);
			examBeans.add(userExamBean);
		}
		examBeanList.setUserExams(examBeans);
		model.addAttribute("userExam",examBeanList);	
		return "questionPaper";
	}
	
	@RequestMapping(value = "finishExam", method = RequestMethod.POST)
	public String finishExam(UserExamBeanList examBeanList,Model model,HttpRequest request)
	{
		int ques=0;
		int pass=0;
		System.out.println("Size of list:"+examBeanList.getUserExams().size());
		List<UserExamBean> beanLists=examBeanList.getUserExams();
	
			for(UserExamBean userExamBean:beanLists)
			{
				
				if(userExamBean.getUserAns().equals(userExamBean.getQuestionBean().getAnswer()))
				{
					
					userExamBean.setStatus("true");
					dao1.insertUserExam(userExamBean);
					pass++;
				}
				else
				{
					userExamBean.setStatus("false");
					dao1.insertUserExam(userExamBean);
				}
				
				ques++;
			}
			
			if(ques/2<=pass)
			{
				
			}
		model.addAttribute("beanLists",beanLists);
		return"ExamResult";
	}
}
