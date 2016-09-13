package com.lyj.biz;

import java.util.List;

import com.lyj.entity.SelectCourse;

public interface SelectCourseBiz {

	public void SelectCourse(SelectCourse sc);
	
	public List GetAllSelectC();
	
	public List GetAllSCTS(SelectCourse sc);
	
	public void DeleteSC(SelectCourse sc);
	
	public void UpdateSC(SelectCourse sc);
}
