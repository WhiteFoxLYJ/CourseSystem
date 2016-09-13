package com.lyj.biz;

import java.util.List;

import com.lyj.entity.Teacher;

public interface TeacherBiz {

	public List FindTeacher(Teacher condition);

	public void AddTeacher(Teacher teacher);

	public void DeleteTeacher(Teacher teacher);

	public void UpdateTeacher(Teacher teacher);

	public List GetAllTeacher();
}
