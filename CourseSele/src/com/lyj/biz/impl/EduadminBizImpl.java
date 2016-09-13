package com.lyj.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyj.biz.EduadminBiz;
import com.lyj.dao.EduadminDAO;
import com.lyj.dao.TeacherDAO;
import com.lyj.entity.Eduadmin;
import com.lyj.entity.Teacher;

@Service("eduadminBiz")
public class EduadminBizImpl implements EduadminBiz {
	@Resource
	EduadminDAO eduadminDAO;

	public void setEduadminDAO(EduadminDAO eduadminDAO) {
		this.eduadminDAO = eduadminDAO;
	}

	@Override
	public List FindEduadmin(Eduadmin eduadmin) {
		return eduadminDAO.FindEduadmin(eduadmin);
	}

	@Override
	public void AddEduadmin(Eduadmin eduadmin) {
		// TODO Auto-generated method stub
		eduadminDAO.AddEduadmin(eduadmin);
	}

	@Override
	public List GetAllEduadmin() {
		return eduadminDAO.GetAllEduadmin();
	}

	@Override
	public void DeleteEduadmin(Eduadmin eduadmin) {
		// TODO Auto-generated method stub
		eduadminDAO.DeleteEduadmin(eduadmin);
	}

	@Override
	public void UpdateEduadmin(Eduadmin eduadmin) {
		// TODO Auto-generated method stub
		eduadminDAO.UpdateEduadmin(eduadmin);
	}

}
