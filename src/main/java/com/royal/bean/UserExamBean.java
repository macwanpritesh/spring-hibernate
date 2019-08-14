package com.royal.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserExam")
public class UserExamBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ueid;
		
	private String userAns;
	
	private String status;
	
	@ManyToOne
	UserBean userBean;
	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public QuestionBean getQuestionBean() {
		return questionBean;
	}

	public void setQuestionBean(QuestionBean questionBean) {
		this.questionBean = questionBean;
	}

	public ExamBean getExamBean() {
		return examBean;
	}

	public void setExamBean(ExamBean examBean) {
		this.examBean = examBean;
	}

	@ManyToOne
	QuestionBean questionBean;
	
	@ManyToOne
	ExamBean examBean;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public int getUeid() {
		return ueid;
	}

	public void setUeid(int ueid) {
		this.ueid = ueid;
	}

	

	public String getUserAns() {
		return userAns;
	}

	public void setUserAns(String userAns) {
		this.userAns = userAns;
	}
	

}
