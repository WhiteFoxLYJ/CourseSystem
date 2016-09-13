package com.lyj.dao;

import java.util.List;

import com.lyj.entity.Eduadmin;

public interface EduadminDAO {
	//
	public List FindEduadmin(Eduadmin condition);
	//
	public void AddEduadmin(Eduadmin teacher);
	//
	public void DeleteEduadmin(Eduadmin teacher);
	//
	public void UpdateEduadmin(Eduadmin teacher);
	//
	public List GetAllEduadmin();
}
