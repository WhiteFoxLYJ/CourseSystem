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

import com.lyj.dao.StudentCourseDAO;
import com.lyj.entity.StudentCourse;

@Repository("studentcourseDAO")
public class StudentCourseDAOImpl implements StudentCourseDAO {

	@Resource
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	//添加到学生课程表
		//这是学生选课结束之后的最终结果存放处
	@Override
	public void AddStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		System.out.println("AddStudentCourse事务开启");
		Transaction tx=session.beginTransaction();
		try {
//			Criteria c=session.createCriteria(StudentCourse.class);
			System.out.println("AddStudentCourse添加入表");
			session.save(studentCourse);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	//用于显示所有学生的选课的结果
	@Override
	public List GetAllStudentCourse() {
		// TODO Auto-generated method stub
		List stuclist=null;
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(StudentCourse.class);
			stuclist=c.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
		return stuclist;
	}

	//用于删除某项已选课程（可能是上课上着就突然退课了）
	@Override
	public void DeleteStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		System.out.println("删除学生课表中的该项记录");
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(StudentCourse.class);
			String hql="delete StudentCourse as sc where sc.selectCourse.selectId ="+studentCourse.getSelectCourse().getSelectId();
			Query query=session.createQuery(hql);
			query.executeUpdate();
//			session.delete(studentCourse);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	//该方法可能为跟新课程信息后，用于更新学生的课程信息
	@Override
	public void UpdateStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(StudentCourse.class);
			session.update(studentCourse);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public List GetStuCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		List stuclist=null;
		System.out.println("查询个人课表的学生id==="+studentCourse.getStudent().getStudentId());
		System.out.println("查询个人课表的学生Name==="+studentCourse.getStudent().getStudentName());
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(StudentCourse.class);
			Example ex=Example.create(studentCourse);
			
			String hql="from StudentCourse sc where sc.student.studentId='"+studentCourse.getStudent().getStudentId()+"'";
			stuclist=session.createQuery(hql).list();
//			stuclist=c.list();
			System.out.println("查询后list 的大小:"+stuclist.size());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
		return stuclist;
	}

}
