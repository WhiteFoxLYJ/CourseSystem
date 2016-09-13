package com.lyj.biz;

import java.util.List;

import com.lyj.entity.Course;

public interface CourseBiz {
	public List FindCourse(Course condition);

	public void AddCourse(Course course);

	//
	public void DeleteCourse(Course course);

	//
	public void UpdateCourse(Course course);

	//
	public List GetAllCourse();
}
