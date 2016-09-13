package com.lyj.biz;

import java.util.List;

import com.lyj.entity.StudentCourse;

public interface StudentCourseBiz {

	public void AddStudentCourse(StudentCourse studentCourse);
	
	public List GetAllStudentCourse();
	
	public void DeleteStudentCourse(StudentCourse studentCourse);
	
	public void UpdateStudentCourse(StudentCourse studentCourse);
	
	public List GetStuCourse(StudentCourse studentCourse);
}
