package com.royal.bean;



import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.context.annotation.Lazy;

@Entity
@Table(name = "Exam")
public class ExamBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int examid;
	
	private String title;
	
	private String totalMarks;
	
	private String duration;
	
	private String date;
	
	private String examCode;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "examid")
	List<QuestionBean> queBean;
	
	
	
	public int getExamid() {
		return examid;
	}

	public List<QuestionBean> getQueBean() {
		return queBean;
	}

	public void setQueBean(List<QuestionBean> queBean) {
		this.queBean = queBean;
	}

	public void setExamid(int examid) {
		this.examid = examid;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date=date;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	

}
