package com.lyj.dao;

import java.util.List;

import com.lyj.entity.Coursetime;

public interface CoursetimeDAO {
	//
	public List FindCoursetime(Coursetime ctime);

	//
	public void AddCoursetime(Coursetime ctime);

	//
	public void DeleteCoursetime(Coursetime ctime);

	//
	public void UpdateCoursetime(Coursetime ctime);

	//
	public List GetAllCoursetime();
}
