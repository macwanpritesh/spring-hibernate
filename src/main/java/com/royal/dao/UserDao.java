package com.royal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.royal.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	SessionFactory factory;
	
	public void insert(UserBean bean) {
		
		Session session=factory.openSession();
		session.save(bean);
		session.close();
	}

	public List<UserBean> validateUser(UserBean bean) {
		boolean flag=false;
		Session session=factory.openSession();
		List<UserBean> list=session.createQuery("From UserBean where emailId='"+bean.getEmailId()+"' and password='"+bean.getPassword()+"'").list();
		return list;
	
	}

}
