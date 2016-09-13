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

import com.lyj.dao.EduadminDAO;
import com.lyj.entity.Eduadmin;

@Repository("eduadminDAO")
public class EduadminDAOImpl implements EduadminDAO {

	@Resource
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	//查询某个教务的信息
	@Override
	public List FindEduadmin(Eduadmin condition) {
		System.out.println("condition.getId()=="+condition.getId());
		System.out.println("condition.getName()=="+condition.getName());
		List list=null;
		List finlist=null;
//		list.clear();
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Criteria c=session.createCriteria(Eduadmin.class);
			Example example=Example.create(condition);
			c.add(example);
			
			String hql="select ed from Eduadmin ed where ed.id='"+condition.getId()+"' and ed.name='"+condition.getName()+"' and ed.password='"+condition.getPassword()+"'";
			Query query = session.createQuery(hql);
			list=query.list();
//			list=c.list();
			System.out.println("----eduadmin.size----"+list.size());
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				  Eduadmin str = (Eduadmin)iter.next();
				  System.out.println(str.getId()+"--"+str.getName()+"--"+str.getSex());
				 }
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}

	//添加某个教务的信息
	@Override
	public void AddEduadmin(Eduadmin eduadmin) {
		Session session=sessionFactory.getCurrentSession();			
			session.save(eduadmin);
	}

	//获取所有教务的信息
	@Override
	public List GetAllEduadmin() {
		List list=null;
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(Eduadmin.class);
			list=c.list();
			System.out.println("-------"+list);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}

	
	//删除某个教务的信息
	@Override
	public void DeleteEduadmin(Eduadmin eduadmin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(eduadmin);
	}

	//修改某个教务的信息
	@Override
	public void UpdateEduadmin(Eduadmin eduadmin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(eduadmin);
	}

	
	
}
