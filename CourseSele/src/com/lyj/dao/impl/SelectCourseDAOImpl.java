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

import com.lyj.dao.SelectCourseDAO;
import com.lyj.entity.SelectCourse;

@Repository("selectcourseDAO")
public class SelectCourseDAOImpl implements SelectCourseDAO {

	@Resource
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void SelectCourse(SelectCourse sc) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(sc);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	// 获取学生选课阶段的选课结果，该结果并非最终的学生课程
	@Override
	public List GetAllSelectC() {
		// TODO Auto-generated method stub
		List sslist = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(SelectCourse.class);
			sslist = c.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return sslist;
	}

	// 退课，选课阶段可以有学生进行退课
	@Override
	public void DeleteSC(SelectCourse sc) {
		// TODO Auto-generated method stub
		System.out.println("删除选课表中的该项记录");
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// Criteria c=session.createCriteria(SelectCourse.class);
			session.delete(sc);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	// 课程信息信息更新之后可以对该选课表的信息进行更新
	@Override
	public void UpdateSC(SelectCourse sc) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(SelectCourse.class);
			session.update(sc);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public List GetAllSCTS(SelectCourse sc) {
		// TODO Auto-generated method stub
		List sslist = null;
		System.out.println("所查询学生的id" + sc.getStudent().getStudentId());
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(SelectCourse.class);
			Example ex = Example.create(sc);
			c.add(ex);
			
			int studentid=sc.getStudent().getStudentId();
			String hql="select sc from SelectCourse sc where sc.student.studentId="+studentid;
			Query query=session.createQuery(hql);
			sslist = query.list();
//			sslist = c.list();
			System.out.println("查询后获取list的大小为：" + sslist.size());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return sslist;
	}

}
