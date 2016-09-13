package com.lyj.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.biz.TeacherBiz;
import com.lyj.dao.TeacherDAO;
import com.lyj.entity.Teacher;

@Service("teacherBiz")
public class TeacherBizImpl implements TeacherBiz {
	@Resource
	TeacherDAO teacherDAO;

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public List FindTeacher(Teacher condition) {
		return teacherDAO.FindTeacher(condition);
	}

	@Override
	public void AddTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDAO.AddTeacher(teacher);
	}

	// @Override
	// public String AddRoom(Room room) {
	// // TODO Auto-generated method stub
	// return roomDAO.AddRoom(room);
	// }

	@Override
	public List GetAllTeacher() {
		return teacherDAO.GetAllTeacher();
	}

	@Override
	public void DeleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDAO.DeleteTeacher(teacher);
	}

	@Override
	public void UpdateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDAO.UpdateTeacher(teacher);
	}

}
