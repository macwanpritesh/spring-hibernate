package com.royal.dao;

import java.util.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.royal.bean.ExamBean;
import com.royal.bean.QuestionBean;
import com.royal.bean.UserExamBean;
import com.royal.bean.UserExamBeanList;

@Repository
public class ExamDao {
	
	@Autowired
	SessionFactory factory;
	
	public void insertExam(ExamBean bean)
	{
			Session session=factory.openSession();
			Transaction transaction=session.getTransaction();
			try {
			session.save(bean);
			transaction.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
		
	}

	public List<ExamBean> getExam() {

		Session session=factory.openSession();
			List<ExamBean> list=session.createQuery("From ExamBean").list();
			session.close();
		
		return list;
	}
	
	public ExamBean getById(int examid)
	{
		Session session=factory.openSession();
		ExamBean bean=session.get(ExamBean.class, examid);
		session.close();
		return bean;
	}	

	public void deleteExam(ExamBean bean) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
		session.delete(bean);
		transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	public void update(ExamBean bean) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
		session.update(bean);
		transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	public void insertQuestion(QuestionBean bean) {
		
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
		session.save(bean);
		transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	
		
	}

	public List<ExamBean> getExamByCode(String examCode) {
	
			Session session=factory.openSession();
			List<ExamBean>list=session.createQuery("From ExamBean where examCode='"+examCode+"'").list();
			session.close();
			return  list;	
		
	}

	public List<QuestionBean> getQuestion(int id) {
		
		Session session=factory.openSession();
		List<QuestionBean>list=session.createQuery("From QuestionBean where examid='"+id+"'").list();
		session.close();
		return list;
	}
	
	public List<QuestionBean> getQuestion()
	{
		Session session=factory.openSession();
		List<QuestionBean> bean=session.createQuery("From QuestionBean").list();
		session.close();
		return bean;
	}

	public void insertUserExam(UserExamBean examBean)
	{
	
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
		session.save(examBean);
		transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	

}
