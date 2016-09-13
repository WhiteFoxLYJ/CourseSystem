package com.lyj.biz;

import java.util.List;

import com.lyj.entity.Student;

public interface StudentBiz {

	public List FindStudent(Student condition);

	public void AddStudent(Student student);

	public void DeleteStudent(Student student);

	public void UpdateStudent(Student student);

	public List GetAllStudent();
}
