package com.lyj.biz;

import java.util.List;

import com.lyj.entity.Coursetime;

public interface CoursetimeBiz {

	public List FindCoursetime(Coursetime coursetime);

	public void AddCoursetime(Coursetime coursetime);

	public void DeleteCoursetime(Coursetime coursetime);

	public void UpdateCoursetime(Coursetime coursetime);

	public List GetAllCoursetime();
}
