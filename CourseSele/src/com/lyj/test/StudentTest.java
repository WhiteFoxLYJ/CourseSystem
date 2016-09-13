package com.lyj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyj.biz.StudentBiz;
import com.lyj.entity.Student;

import java.util.*;

public class StudentTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// System.out.println("-----------");
		StudentBiz studentBiz = (StudentBiz) context.getBean("studentBiz");
		Student conditon = new Student();
		// ����ݿ��Room�������һ�����
		// conditon.setStudentId(1);
		conditon.setStudentName("����");
		conditon.setStudentSex("��");
		conditon.setStudentPid(1252363);
		studentBiz.AddStudent(conditon);
		List Rlist = studentBiz.GetAllStudent();
		System.out.println("---" + Rlist);
		// for(int i=0;i<Rlist.size();i++){
		// System.out.println(Rlist.get(i).toString());
		// }
		// forѭ����ѯRoom����������
		for (Iterator iter = Rlist.iterator(); iter.hasNext();) {
			Student str = (Student) iter.next();
			System.out.println(str.getStudentId() + "--" + str.getStudentName()
					+ "--" + str.getStudentSex() + "--" + str.getStudentPid());
		}
	}

}
