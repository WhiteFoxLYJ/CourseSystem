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

import com.lyj.dao.RoomDAO;
import com.lyj.entity.Room;

@Repository("roomDAO")
public class RoomDAOImpl implements RoomDAO {

	//
	//
	@Resource
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	//
	@Override
	public List FindRoom(Room condition) {
		List list=null;
		//ͨ
		Session session=sessionFactory.getCurrentSession();
		//
		Transaction tx=session.beginTransaction();
		try {
			//
			Criteria c=session.createCriteria(Room.class);
			//
			Example example=Example.create(condition);
			//
			c.add(example);
			
//			String hql="from Room";
//			Query query = session.createQuery(hql);
//			list=query.list();
			list=c.list();
			//
			System.out.println("----------------room表查询的结果集大小："+list.size());
			tx.commit();
		} catch (Exception e) {
			//
			tx.rollback();
		}
		return list;
	}

	//添加信息的教室的信息
	@Override
	public void AddRoom(Room room) {
		Session session=sessionFactory.getCurrentSession();			
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(Room.class);
			session.save(room);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
//		session.save(room);
	}

	//获取所有的教室的信息
	@Override
	public List GetAllRoom() {
		List list=null;
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(Room.class);
			String hql="from Room";
			Query query = session.createQuery(hql);
			list=query.list();
//			list=c.list();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Room str = (Room) iterator.next();
			
					  System.out.println(str.getRoomId()+"--"+str.getRoomType()+"--"+str.getRoomScale());
				
			}
			System.out.println("-------"+list.size());
			session.clear();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}

	
	//删除某个教室的信息
	@Override
	public void DeleteRoom(Room room) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(Room.class);
			session.delete(room);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	//修改某个教室的信息
	@Override
	public void UpdateRoom(Room room) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Criteria c=session.createCriteria(Room.class);
			session.update(room);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	
	
}
