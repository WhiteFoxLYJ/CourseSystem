package com.lyj.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.biz.CoursetimeBiz;
import com.lyj.dao.CoursetimeDAO;
import com.lyj.entity.Coursetime;

@Service("coursetimeBiz")
public class CoursetimeBizImpl implements CoursetimeBiz {
	@Resource
	CoursetimeDAO coursetimeDAO;
	public void setCoursetimeDAO(CoursetimeDAO coursetimeDAO) {
		this.coursetimeDAO = coursetimeDAO;
	}

	@Override
	public List FindCoursetime(Coursetime time) {
		return coursetimeDAO.FindCoursetime(time);
	}

	@Override
	public void AddCoursetime(Coursetime time) {
		// TODO Auto-generated method stub
		coursetimeDAO.AddCoursetime(time);
	}

	@Override
	public List GetAllCoursetime() {
		return coursetimeDAO.GetAllCoursetime();
	}

	@Override
	public void DeleteCoursetime(Coursetime time) {
		// TODO Auto-generated method stub
		coursetimeDAO.DeleteCoursetime(time);
	}

	@Override
	public void UpdateCoursetime(Coursetime time) {
		// TODO Auto-generated method stub
		coursetimeDAO.UpdateCoursetime(time);
	}
	
	

}
