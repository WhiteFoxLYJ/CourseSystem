package com.lyj.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.lyj.dao.CourseTeacherDAO;
import com.lyj.entity.CourseTeacher;
import com.opensymphony.xwork2.ActionContext;

@Repository("courseteacherDAO")
public class CouseTeacherDAOImpl implements CourseTeacherDAO {

	@Resource
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 查询
	@Override
	public List FindCourseTeacher(CourseTeacher condition) {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(CourseTeacher.class);
			Example example = Example.create(condition);
			c.add(example);
			list = c.list();
			System.out.println("----teacher----" + list);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				CourseTeacher str = (CourseTeacher) iter.next();
				System.out.println(str.getCtId() + "--"
						+ str.getCourse().getCourseName() + "--"
						+ str.getTeacher().getTeacherName());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return list;
	}

	// 添加
	@Override
	public void AddCourseTeacher(CourseTeacher ct) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			System.out.println("--" + ct.getCourse().getCourseId() + "--"
					+ ct.getRoom().getRoomId() + "--"
					+ ct.getTeacher().getTeacherId());
			// Criteria c=session.createCriteria(CourseTeacher.class);
			session.save(ct);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	// 查询全部
	@Override
	public List GetAllCourseTeacher() {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(CourseTeacher.class);
//			list = c.list();
			String hql="from CourseTeacher";
			Query query=session.createQuery(hql);
			list=query.list();
			System.out.println("---CourseTeacher----" + list);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}

	// 删除
	@Override
	public void DeleteCourseTeacher(CourseTeacher ct) {
		// TODO Auto-generated method stub
		System.out.println("deleteCourse..");
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(CourseTeacher.class);
			session.delete(ct);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	// 修改
	@Override
	public void UpdateCourseTeacher(CourseTeacher ct) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(ct);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	// 获取学生的可选课程
	@Override
	public List GetAllCTTS() {
		// TODO Auto-generated method stub

		List listA = null;
		List listB = null;
		Session session = sessionFactory.getCurrentSession();
		Map request = ActionContext.getContext().getSession();
		// request.get("login_id");
		int student_id = (Integer) request.get("login_id");
		System.out.println("获取当前学生：id=" + student_id
				+ " 的 可选课程（GetAllCTTS()方法）");
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(CourseTeacher.class);
//			String hql = "select ct from CourseTeacher ct,SelectCourse sc where ct.ctId!=sc.courseTeacher.ctId and sc.student.studentId="+ student_id;
			String ql="select ct from CourseTeacher ct where ct.ctId =any (select sc.courseTeacher.ctId from SelectCourse sc where sc.student.studentId="+student_id+")"  ;
			String hq="select ct from CourseTeacher ct,SelectCourse sc where ct.ctId!=sc.courseTeacher.ctId and sc.student.studentId="+ student_id;
//			String test_001="select sc.courseTeacher.ctId from SelectCourse sc where sc.student.studentId="+student_id;
			String hql="from CourseTeacher";
			Query query1 = session.createQuery(ql);
			Query query2 = session.createQuery(hql);
//			Query query=session.createQuery(test_001);
//			Query query=session.createQuery(hq);
			System.out.println("??????????????????????");
			listA = query1.list();
			listB = query2.list();
			listB.removeAll(listA);
			if (listA.equals(null)) {
				System.out.println("获取的Courseteacher内容为空");
			}
//			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//				CourseTeacher object = (CourseTeacher) iterator.next();
//				System.out.println("--" + object.getCtId() + "--"
//						+ object.getCourse().getCourseName() + "--"
//						+ object.getTeacher().getTeacherName());
//			}
			System.out.println("-------" + listB.size());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		System.out.println("返回的list的大小：" + listB.size());
		return listB;
	}

}
