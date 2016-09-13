package com.lyj.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.lyj.dao.TeacherDAO;
import com.lyj.entity.Teacher;

@Repository("teacherDAO")
public class TeacherDAOImpl implements TeacherDAO {

	@Resource
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 查询某位教师，该方法用于教师的登录
	@Override
	public List FindTeacher(Teacher condition) {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(Teacher.class);
			Example example = Example.create(condition);
			c.add(example);
			list = c.list();
			System.out.println("----teacher----" + list.size());
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Teacher str = (Teacher) iter.next();
				System.out.println(str.getTeacherId() + "--"
						+ str.getTeacherName() + "--" + str.getTeacherSex());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return list;
	}

	// 添加某位教师
	@Override
	public void AddTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(teacher);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	// 获取全部教师的信息
	@Override
	public List GetAllTeacher() {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(Teacher.class);
			String hql="from Teacher";
			Query query = session.createQuery(hql);
			list=query.list();
//			list = c.list();
			System.out.println("---Teacher----" + list.size());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		return list;
	}

	// 删除教师的信息
	@Override
	public void DeleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(teacher);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	// 修改教室的信息
	@Override
	public void UpdateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(teacher);
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
