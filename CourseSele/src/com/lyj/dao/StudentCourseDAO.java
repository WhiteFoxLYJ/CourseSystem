package com.lyj.dao;

import java.util.List;

import com.lyj.entity.SelectCourse;
import com.lyj.entity.StudentCourse;

public interface StudentCourseDAO {

	public void AddStudentCourse(StudentCourse studentCourse);

	public List GetAllStudentCourse();

	public void DeleteStudentCourse(StudentCourse studentCourse);

	public void UpdateStudentCourse(StudentCourse studentCourse);

	public List GetStuCourse(StudentCourse studentCourse);
}
