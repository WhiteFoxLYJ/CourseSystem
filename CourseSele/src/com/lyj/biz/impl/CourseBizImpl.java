package com.lyj.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.biz.CourseBiz;
import com.lyj.dao.CourseDAO;
import com.lyj.entity.Course;

@Service("courseBiz")
public class CourseBizImpl implements CourseBiz {
	@Resource
	CourseDAO courseDAO;

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List FindCourse(Course condition) {
		// TODO Auto-generated method stub
		return courseDAO.FindCourse(condition);
	}

	@Override
	public void AddCourse(Course course) {
		// TODO Auto-generated method stub
		courseDAO.AddCourse(course);
	}

	@Override
	public void DeleteCourse(Course course) {
		// TODO Auto-generated method stub
		courseDAO.DeleteCourse(course);
	}

	@Override
	public void UpdateCourse(Course course) {
		// TODO Auto-generated method stub
		courseDAO.UpdateCourse(course);
	}

	@Override
	public List GetAllCourse() {
		// TODO Auto-generated method stub
		return courseDAO.GetAllCourse();
	}

}
