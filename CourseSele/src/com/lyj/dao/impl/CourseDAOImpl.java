package com.lyj.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.lyj.dao.CourseDAO;
import com.lyj.entity.Course;

@Repository("courseDAO")
public class CourseDAOImpl implements CourseDAO {

	@Resource
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//
	@Override
	public List FindCourse(Course condition) {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(Course.class);
			Example example = Example.create(condition);
			c.add(example);
			list = c.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}

	//
	@Override
	public void AddCourse(Course course) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println("course--"+course.getCourseName()+"--"+course.getCourseType()+"--"+course.getCourseDesc());
		try {
			session.save(course);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}

	}

	//
	@Override
	public List GetAllCourse() {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(Course.class);
			String hql="from Course";
			Query query = session.createQuery(hql);
			list=query.list();
//			list = c.list();
			System.out.println("---Course----" + list.size());
			tx.commit();
		} catch (Exception e) {
			// // TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}

	//
	@Override
	public void DeleteCourse(Course course) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(course);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}

	}

	//
	@Override
	public void UpdateCourse(Course course) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(course);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

}
