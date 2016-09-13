package com.lyj.biz;

import java.util.List;

import com.lyj.entity.CourseTeacher;

;

public interface CourseTeacherBiz {
	//
	public List FindCourseTeacher(CourseTeacher condition);

	//
	public void AddCourseTeacher(CourseTeacher ct);

	//
	public void DeleteCourseTeacher(CourseTeacher ct);

	//
	public void UpdateCourseTeacher(CourseTeacher ct);

	//
	public List GetAllCourseTeacher();

	//
	public List GetAllCTTS();
}
