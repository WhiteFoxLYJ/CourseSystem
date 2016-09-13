package com.lyj.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyj.biz.CourseTeacherBiz;
import com.lyj.dao.CourseTeacherDAO;
import com.lyj.entity.CourseTeacher;


@Service("courseteacherBiz")
public class CourseTeacherBizImpl implements CourseTeacherBiz {
	@Resource
	CourseTeacherDAO courseTeacherDAO;
	public void setCourseTeacherDAO(CourseTeacherDAO courseTeacherDAO) {
		this.courseTeacherDAO = courseTeacherDAO;
	}

	@Override
	public List FindCourseTeacher(CourseTeacher ct) {
		return courseTeacherDAO.FindCourseTeacher(ct);
	}

	@Override
	public void AddCourseTeacher(CourseTeacher ct) {
		// TODO Auto-generated method stub
		courseTeacherDAO.AddCourseTeacher(ct);;
	}

	@Override
	public List GetAllCourseTeacher() {
		return courseTeacherDAO.GetAllCourseTeacher();
	}

	@Override
	public void DeleteCourseTeacher(CourseTeacher ct) {
		// TODO Auto-generated method stub
		courseTeacherDAO.DeleteCourseTeacher(ct);
	}

	@Override
	public void UpdateCourseTeacher(CourseTeacher ct) {
		// TODO Auto-generated method stub
		courseTeacherDAO.UpdateCourseTeacher(ct);;
	}

	@Override
	public List GetAllCTTS() {
		// TODO Auto-generated method stub
		return courseTeacherDAO.GetAllCTTS();
	}
	
	

}
