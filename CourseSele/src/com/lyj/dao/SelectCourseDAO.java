package com.lyj.dao;

import java.util.List;

import com.lyj.entity.SelectCourse;

public interface SelectCourseDAO {

	public void SelectCourse(SelectCourse sc);

	public List GetAllSelectC();

	public List GetAllSCTS(SelectCourse sc);

	public void DeleteSC(SelectCourse sc);

	public void UpdateSC(SelectCourse sc);
}
