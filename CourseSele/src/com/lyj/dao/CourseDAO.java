package com.lyj.dao;

import java.util.List;

import com.lyj.entity.Course;

public interface CourseDAO {
	//
	public List FindCourse(Course condition);
	//
	public void AddCourse(Course course);
	//
	public void DeleteCourse(Course course);
	//
	public void UpdateCourse(Course course);
	//
	public List GetAllCourse();
}
