package com.lyj.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.lyj.dao.StudentDAO;
import com.lyj.entity.Student;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Resource
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	//该方法用于学生的登录
	@Override
	public List FindStudent(Student condition) {
		System.out.println("condition.getId()=="+condition.getStudentId());
		System.out.println("condition.getName()=="+condition.getStudentName());
		List list=null;
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Criteria c=session.createCriteria(Student.class);
			Example example=Example.create(condition);
			c.add(example);
			list=c.list();
			System.out.println("----student----"+list);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				  Student str = (Student)iter.next();
				  System.out.println(str.getStudentId()+"--"+str.getStudentName()+"--"+str.getStudentSex()+"--"+str.getStudentPid());
				 }
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}

	//
	@Override
	public void AddStudent(Student student) {
		Session session=sessionFactory.getCurrentSession();			
		Transaction tx=session.beginTransaction();
		try {	
			session.save(student);
		tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
	}

	//
	@Override
	public List GetAllStudent() {
		List list=null;
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(Student.class);
			list=c.list();
			System.out.println("-------"+list);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		return list;
	}

	
	//
	@Override
	public void DeleteStudent(Student student) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.delete(student);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
	}

	//
	@Override
	public void UpdateStudent(Student student) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.update(student);
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
	}

	
	
}
