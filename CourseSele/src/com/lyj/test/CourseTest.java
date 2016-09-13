package com.lyj.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyj.biz.CourseBiz;
import com.lyj.entity.Course;
import com.lyj.entity.Room;

public class CourseTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CourseBiz courseBiz = (CourseBiz) context.getBean("courseBiz");
		Course conditon = new Course();
		// conditon.setCourseId(1);
		conditon.setCourseName("רҵ���");
		// conditon.setCourseDesc("���޿γ�");
		List list = courseBiz.FindCourse(conditon);
		if (list.size() > 0) {
			System.out.println("��ѯ�ɹ�");
			// System.out.println();
		} else {
			System.out.println("��ѯʧ��");
		}
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Course str = (Course) iter.next();
			System.out.println(str.getCourseId() + "--" + str.getCourseName()
					+ "--" + str.getCourseDesc());
		}
	}
}
