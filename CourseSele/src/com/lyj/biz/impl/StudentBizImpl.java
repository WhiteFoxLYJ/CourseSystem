package com.lyj.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyj.biz.StudentBiz;
import com.lyj.dao.StudentDAO;
import com.lyj.entity.Student;

@Service("studentBiz")
public class StudentBizImpl implements StudentBiz {
	@Resource
	StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public List FindStudent(Student condition) {
		return studentDAO.FindStudent(condition);
	}

	@Override
	public void AddStudent(Student student) {
		studentDAO.AddStudent(student);
	}

	// @Override
	// public String AddRoom(Room room) {
	// // TODO Auto-generated method stub
	// return roomDAO.AddRoom(room);
	// }

	@Override
	public List GetAllStudent() {
		return studentDAO.GetAllStudent();
	}

	@Override
	public void DeleteStudent(Student student) {
		studentDAO.DeleteStudent(student);
	}

	@Override
	public void UpdateStudent(Student student) {
		studentDAO.UpdateStudent(student);
	}

}
