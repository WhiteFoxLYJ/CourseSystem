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

import com.lyj.dao.CoursetimeDAO;
import com.lyj.entity.Coursetime;

@Repository("coursetimeDAO")
public class CoursetimeDAOImpl implements CoursetimeDAO {

	@Resource
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 查询时间
	@Override
	public List FindCoursetime(Coursetime ctime) {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(Coursetime.class);
			Example example = Example.create(ctime);
			c.add(example);
			list = c.list();
			System.out.println("----teacher----" + list);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Coursetime str = (Coursetime) iter.next();
				System.out
						.println(str.getTimeId() + "--" + str.getLessonTime());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return list;
	}

	// 添加时间
	@Override
	public void AddCoursetime(Coursetime ctime) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(ctime);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	// 获取全部时间的信息
	@Override
	public List GetAllCoursetime() {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(Coursetime.class);
			String hql="from Coursetime";
			Query query = session.createQuery(hql);
			list=query.list();
//			list = c.list();
			System.out.println("---Coursetime--size--" + list.size());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		return list;
	}

	// 删除时间的信息
	@Override
	public void DeleteCoursetime(Coursetime coursetime) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(coursetime);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	// 修改时间的信息
	@Override
	public void UpdateCoursetime(Coursetime coursetime) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(coursetime);
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
