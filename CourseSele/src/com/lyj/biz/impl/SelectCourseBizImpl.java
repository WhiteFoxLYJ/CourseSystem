package com.lyj.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.biz.SelectCourseBiz;
import com.lyj.dao.SelectCourseDAO;
import com.lyj.entity.SelectCourse;

@Service("selectcourseBiz")
public class SelectCourseBizImpl implements SelectCourseBiz {
	@Resource
	SelectCourseDAO selectCourseDAO;

	public SelectCourseDAO getSelectCourseDAO() {
		return selectCourseDAO;
	}

	public void setSelectCourseDAO(SelectCourseDAO selectCourseDAO) {
		this.selectCourseDAO = selectCourseDAO;
	}

	@Override
	public void SelectCourse(SelectCourse sc) {
		// TODO Auto-generated method stub
		selectCourseDAO.SelectCourse(sc);
	}

	@Override
	public List GetAllSelectC() {
		// TODO Auto-generated method stub
		return selectCourseDAO.GetAllSelectC();
	}

	@Override
	public void DeleteSC(SelectCourse sc) {
		// TODO Auto-generated method stub
		selectCourseDAO.DeleteSC(sc);
	}

	@Override
	public void UpdateSC(SelectCourse sc) {
		// TODO Auto-generated method stub
		selectCourseDAO.UpdateSC(sc);
	}

	@Override
	public List GetAllSCTS(SelectCourse sc) {
		// TODO Auto-generated method stub
		return selectCourseDAO.GetAllSCTS(sc);
	}

}
