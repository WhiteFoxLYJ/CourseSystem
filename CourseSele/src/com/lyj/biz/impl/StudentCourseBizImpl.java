package com.lyj.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.biz.StudentBiz;
import com.lyj.biz.StudentCourseBiz;
import com.lyj.dao.StudentCourseDAO;
import com.lyj.entity.Student;
import com.lyj.entity.StudentCourse;

@Service("studentcourseBiz")
public class StudentCourseBizImpl implements StudentCourseBiz {

	@Resource
	StudentCourseDAO studentCourseDAO;	
	public StudentCourseDAO getStudentCourseDAO() {
		return studentCourseDAO;
	}
	public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}
	@Override
	public void AddStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		studentCourseDAO.AddStudentCourse(studentCourse);
	}
	@Override
	public List GetAllStudentCourse() {
		// TODO Auto-generated method stub
		return studentCourseDAO.GetAllStudentCourse();
	}
	@Override
	public void DeleteStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		studentCourseDAO.DeleteStudentCourse(studentCourse);
	}
	@Override
	public void UpdateStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		studentCourseDAO.UpdateStudentCourse(studentCourse);
	}
	@Override
	public List GetStuCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		return studentCourseDAO.GetStuCourse(studentCourse);
	}

	

}
