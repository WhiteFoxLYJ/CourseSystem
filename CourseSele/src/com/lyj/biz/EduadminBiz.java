package com.lyj.biz;

import java.util.List;

import com.lyj.entity.Eduadmin;

public interface EduadminBiz {

	public List FindEduadmin(Eduadmin condition);

	public void AddEduadmin(Eduadmin eduadmin);

	public void DeleteEduadmin(Eduadmin eduadmin);

	public void UpdateEduadmin(Eduadmin eduadmin);

	public List GetAllEduadmin();
}
