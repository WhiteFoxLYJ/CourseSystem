package com.lyj.action;

import java.util.Iterator;
import java.util.List;


import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.lyj.biz.CourseTeacherBiz;
import com.lyj.biz.SelectCourseBiz;
import com.lyj.biz.StudentBiz;
import com.lyj.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@Controller//用于标注控制层组件（如struts中的action）
@Scope("prototype")//每次请求都创建一个实例
public class StudentAction extends ActionSupport {

	private Student student;
	private int studentId;
	private String studentName;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Resource
	StudentBiz studentBiz;
	CourseTeacherBiz courseteacherBiz;
	SelectCourseBiz selectcourseBiz;
	public void setSelectcourseBiz(SelectCourseBiz selectcourseBiz) {
		this.selectcourseBiz = selectcourseBiz;
	}
	public void setCourseteacherBiz(CourseTeacherBiz courseteacherBiz) {
		this.courseteacherBiz = courseteacherBiz;
	}
	public void setStudentBiz(StudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}
	
	
	Map<String, Object> request;
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//学生登录
	public String StudnetLogin()throws Exception{
		
		List stulist=null;
		
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		stulist=studentBiz.FindStudent(student);
		for (Iterator iterator = stulist.iterator(); iterator.hasNext();) {
			Student stu = (Student) iterator.next();
			System.out.println(stu.getStudentId()+"--"+stu.getStudentName()+"--"+stu.getStudentSex());
			
		}
		if(stulist.size()>0){
			System.out.println("学生帐号"+studentId+"登录成功");
			return "success";
		}else{
			System.out.println("学生帐号"+studentId+"登录失败");
			return "error";
		}
	}
	
	//学生选课
//	public String StudentSel()throws Exception{
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		List sc=null;
//		
////		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		
//		return "success";
//	}
	
	Map<String,Object> mapMap; 
	public void setMapMap(Map<String, Object> mapMap) {
		this.mapMap = mapMap;
	}
	
	//显示可选的课程
	@Action(value="showStudentCourse",results={
			@Result(name="success",location="ShowPlanToStu.jsp"),
			@Result(name="error",location="error")
	})
	public String ShowToStuCourse()throws Exception{
		List ctlist=null;
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		courseteacherBiz=(CourseTeacherBiz) context.getBean("courseteacherBiz");
		studentBiz=(StudentBiz) context.getBean("studentBiz");
//		ctlist=courseteacherBiz.GetAllCTTS(ct);
		mapMap=(Map<String, Object>) ActionContext.getContext().getSession().put("ctlist", ctlist);
		return "success";
	}
}
