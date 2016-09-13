package com.lyj.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lyj.entity.SelectCourse;

public class test {
	
	static SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public static void main(String[] args) {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		String test_001="select sc.courseTeacher.ctId from SelectCourse sc where sc.student.studentId=1";
		Query query=session.createQuery(test_001);
		list = query.list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			SelectCourse object = (SelectCourse) iterator.next();
			System.out.println("--" + object.getSelectId() + "--"
					);
		}
	}
}
