package com.lyj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyj.biz.TeacherBiz;
import com.lyj.entity.Teacher;

import java.util.*;

public class TeacherTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		System.out.println("-----------");
		TeacherBiz teacherBiz=(TeacherBiz) context.getBean("teacherBiz");
		Teacher conditon=new Teacher();
		//
//		conditon.setTeacherId(1);
//		conditon.setTeacherName("");
//		conditon.setTeacherSex("");
//		teacherBiz.AddTeacher(conditon);
		List Rlist=teacherBiz.GetAllTeacher();
		System.out.println("---"+Rlist);
//		for(int i=0;i<Rlist.size();i++){
//			System.out.println(Rlist.get(i).toString());
//		}
		//
		 for (Iterator iter = Rlist.iterator(); iter.hasNext();) {
			  Teacher str = (Teacher)iter.next();
			  System.out.println(str.getTeacherId()+"--"+str.getTeacherName()+"--"+str.getTeacherSex());
			 }
	}
	
}
