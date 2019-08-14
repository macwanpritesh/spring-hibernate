package com.royal.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Question")
public class QuestionBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int queId;

	
	
	@Column(name = "QueName")
	private String queName;

	public String getQueName() {
		return queName;
	}

	public void setQueName(String queName) {
		this.queName = queName;
	}

	@Column(name = "Que")
	private String question;
	
	@Column(name = "Option_1")
	private String opt1;
	
	@Column(name = "Option_2")
	private String opt2;
	
	@Column(name = "Option_3")
	private String opt3;

	@Column(name = "Option_4")
	private String opt4;
	
	@Column(name = "examid")
	private int examid;
	

	
	public int getExamid() {
		return examid;
	}

	public void setExamid(int examid) {
		this.examid = examid;
	}

	public String getOpt4() {
		return opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	@Column(name = "Answer")
	private String answer;
	

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}


	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
