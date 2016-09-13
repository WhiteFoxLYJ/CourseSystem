package com.lyj.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.lyj.biz.CourseTeacherBiz;
import com.lyj.biz.SelectCourseBiz;
import com.lyj.biz.StudentBiz;
import com.lyj.biz.StudentCourseBiz;
import com.lyj.entity.CourseTeacher;
import com.lyj.entity.SelectCourse;
import com.lyj.entity.Student;
import com.lyj.entity.StudentCourse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("json-default")
@Controller //用于标注控制层组件（如struts中的action）
@Scope("prototype")//每次请求都创建一个实例
//学生-课程操作
public class StuCouCtrlCAction extends ActionSupport {
	
	private int studentId;//学生的编号
	private int coursetId;//排课的编号
	private int teacherId;//教师的编号
	private int courseId;//课程编号
	private int selectId;//选课编号
	
	SelectCourse selectCourse;//学生选课类
	CourseTeacher courseTeacher;//教务排课类
	Student student;//学生类
	StudentCourse studentCourse;//学生课表类
	
	@Resource//依赖注入
	SelectCourseBiz selectCourseBiz;//学生选课Service
	StudentBiz studentBiz;//学生Service
	CourseTeacherBiz courseteacherBiz;//课程安排Service
	StudentCourseBiz studentcourseBiz;//学生课程表Service
	public void setStudentcourseBiz(StudentCourseBiz studentcourseBiz) {
		this.studentcourseBiz = studentcourseBiz;
	}
	public void setSelectCourseBiz(SelectCourseBiz selectCourseBiz) {
		this.selectCourseBiz = selectCourseBiz;
	}
	public void setStudentBiz(StudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}
	public void setCourseteacherBiz(CourseTeacherBiz courseteacherBiz) {
		this.courseteacherBiz = courseteacherBiz;
	}
	public SelectCourseBiz getSelectCourseBiz() {
		return selectCourseBiz;
	}
	public int getSelectId() {
		return selectId;
	}
	public void setSelectId(int selectId) {
		this.selectId = selectId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCoursetId() {
		return coursetId;
	}
	public void setCoursetId(int coursetId) {
		this.coursetId = coursetId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public SelectCourse getSelectCourse() {
		return selectCourse;
	}
	public void setSelectCourse(SelectCourse selectCourse) {
		this.selectCourse = selectCourse;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public CourseTeacher getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(CourseTeacher courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	Map<String, Object> request;//定义request 用于获取和存储登录信息
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	private List sclist;//定义一个存储信息的list，用于存储获取的list集合
	public List getSclist() {
		return sclist;
	}
	public void setSclist(List sclist) {
		this.sclist = sclist;
	}
	
	//show all what students select 
		//展示某个学生的所选的课程
	@Action(value="ShowStuSelect",results={
			@Result(name="success",type="json",params={"root","sclist"}),
			@Result(name="error",location="error.jsp")
	})
	public String ShowAllSelect()throws Exception{
		System.out.println("show student All select");
//		List sclist=null;
		request= (Map) ActionContext.getContext().getSession();//获取session
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");//获取applicationContext.xml
		int studentId=(Integer) request.get("login_id");//获取登录学生的登录编号
//		System.out.println("登录用户的ID:"+studentId);
		selectCourseBiz=(SelectCourseBiz) context.getBean("selectcourseBiz");//获取selectcourseBiz
		selectCourse=new SelectCourse();//选课
		student=new Student();//学生
		student.setStudentId(studentId);
		selectCourse.setStudent(student);
		try {
			sclist=selectCourseBiz.GetAllSCTS(selectCourse);//执行获取当前学生可选课程的方法
			System.out.println("获取的sclist的大小："+sclist.size());//测试获取到的list的大小
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
		System.out.println("------------6--sclist.size="+sclist.size());
		System.out.println("---------------------");
		return "success";
	}
	
	//Studnet Select Course
		//登录学生选课
	@Action(value="StuSelectCourse",results={
			@Result(name="success",type="redirectAction",location="ShowCourseToStudent"),
			@Result(name="error",location="error.jsp")
	})
	public String StuSelectC()throws Exception{
		System.out.println("StuSelectCourse");
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		studentId=(Integer) ActionContext.getContext().getSession().get("login_id");//获取登录学生的编号
		selectCourseBiz=(SelectCourseBiz) context.getBean("selectCourseBiz");
		courseteacherBiz=(CourseTeacherBiz) context.getBean("courseTeacherBiz");
		studentBiz=(StudentBiz) context.getBean("studentBiz");
		studentcourseBiz=(StudentCourseBiz) context.getBean("studentcourseBiz");
		StudentCourse stc=new StudentCourse();
		courseTeacher.setCtId(coursetId);
		student.setStudentId(studentId);
		selectCourse.setCourseTeacher(courseTeacher);
		selectCourse.setStudent(student);
		stc.setSelectCourse(selectCourse);
		stc.setStudent(student);
		//????
		try {
//			courseTeacherBiz.FindCourseTeacher(courseTeacher);
//			studentBiz.FindStudent(student);
			
			selectCourseBiz.SelectCourse(selectCourse);
			studentcourseBiz.AddStudentCourse(stc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("选课失败");
			return "error";
		}
		System.out.println("选课成功");
		return "succss";
		
	}
	
	
	private String Selmessage;//用于传递信息
	public String getSelmessage() {
		return Selmessage;
	}
	public void setSelmessage(String selmessage) {
		Selmessage = selmessage;
	}
		//Studnet Select Course
			//登录学生选课
		@Action(value="StuSelectCourseT",results={
				@Result(name="success",type="json",params={"root","Selmessage"}),
				@Result(name="error",location="error.jsp")
		})
		public String StuSelectC_test()throws Exception{
			System.out.println("课程安排编号:"+coursetId);
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			studentId=(Integer) ActionContext.getContext().getSession().get("login_id");
			System.out.println("选课人的编号："+studentId);
			selectCourseBiz=(SelectCourseBiz) context.getBean("selectcourseBiz");
			courseteacherBiz=(CourseTeacherBiz) context.getBean("courseteacherBiz");
			studentBiz=(StudentBiz) context.getBean("studentBiz");
			studentcourseBiz=(StudentCourseBiz) context.getBean("studentcourseBiz");
			StudentCourse stc=new StudentCourse();
			courseTeacher=new CourseTeacher();
			student=new Student();
			selectCourse=new SelectCourse();
			System.out.println("11111111111-------------------------------------------------1");
			courseTeacher.setCtId(coursetId);
			System.out.println("11111111111-------------------------------------------------2");
			student.setStudentId(studentId);
			System.out.println("11111111111-------------------------------------------------3");
			selectCourse.setCourseTeacher(courseTeacher);
			System.out.println("11111111111-------------------------------------------------4");
			selectCourse.setStudent(student);
			System.out.println("11111111111-------------------------------------------------5");
			stc.setSelectCourse(selectCourse);
			System.out.println("11111111111-------------------------------------------------6");
			stc.setStudent(student);
			System.out.println("-------------------------------------------------");
			//????
			try {
//				courseTeacherBiz.FindCourseTeacher(courseTeacher);
//				studentBiz.FindStudent(student);
				
				selectCourseBiz.SelectCourse(selectCourse);
				System.out.println("kolie");
				studentcourseBiz.AddStudentCourse(stc);//添加新的选课到课程表中
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("选课失败");
				Selmessage="1";
				return "error";
			}
			System.out.println("选课成功");
			Selmessage="0";
			return "success";
			
		}
	
	
	private String Amessage;	
	public String getAmessage() {
		return Amessage;
	}
	public void setAmessage(String amessage) {
		Amessage = amessage;
	}
	//student delete what course had seleted
		//登录学生进行退课
	@Action(value="StuDeleteCour",results={
			@Result(name="success",type="json",params={"root","Amessage"}),
			@Result(name="error",location="error.jsp")
	})
	public String StudentDeleteC()throws Exception{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		selectCourseBiz=(SelectCourseBiz) context.getBean("selectcourseBiz");
		studentcourseBiz=(StudentCourseBiz) context.getBean("studentcourseBiz");
		SelectCourse slc=new SelectCourse();
		StudentCourse stc=new StudentCourse();
		slc.setSelectId(selectId);
		stc.setSelectCourse(slc);
		try {
			studentcourseBiz.DeleteStudentCourse(stc);
			selectCourseBiz.DeleteSC(slc);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("退课失败");
			Amessage="1";
			return "error";
		}
		System.out.println("退课成功");
		Amessage="0";
		return "success";
	}
	
	List cplist=null;
	
	public List getCplist() {
		return cplist;
	}
	public void setCplist(List cplist) {
		this.cplist = cplist;
	}
	//展示学生的可选课程
	@Action(value="ShowCPTS",results={
			@Result(name="success",type="json",params={"root","cplist"}),
			@Result(name="error",location="error.jsp")
	})
	public String ShowCPTS_test()throws Exception{
		System.out.println("show cpts");
		request=ActionContext.getContext().getSession();
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		courseteacherBiz=(CourseTeacherBiz) context.getBean("courseteacherBiz");
		try {
			
			cplist=courseteacherBiz.GetAllCTTS();//获取学生的可选课程
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
		System.out.println("到这了吗？？？？？");
		System.out.println("获得的list的大小："+cplist.size());
		return "success";
		
	}
	
	
	//显示登录学生的课程表
	@Action(value="ShowStudentCourse",results={
			@Result(name="success",type="json",params={"root","sclist"}),
			@Result(name="error",location="error.jsp")
	})
	public String ShowStudentCourse()throws Exception{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		studentcourseBiz=(StudentCourseBiz) context.getBean("studentcourseBiz");
		student=new Student();
		studentCourse=new StudentCourse();
		request=ActionContext.getContext().getSession();
		int studentId=(Integer) request.get("login_id");//获取登录学生的编号
		String studentName=(String) request.get("login_name");
		System.out.println("获取课程表的学生ID为login_id="+studentId);
		student.setStudentId(studentId);//将获得的编号属性Set到Student类里
		student.setStudentName(studentName);
		studentCourse.setStudent(student);//把Student属性set到studentCourse对象里
		try {
			//通过studentCourse的获取当前学生课程方法获取信息存到list里面
			sclist=studentcourseBiz.GetStuCourse(studentCourse);
			//下面为打印检查获取的数据是否为空
			for (Iterator iterator = sclist.iterator(); iterator.hasNext();) {
				StudentCourse type = (StudentCourse) iterator.next();
				System.out.println("---"+type.getScId()+"--"+type.getStudent().getStudentName()+"--"+type.getSelectCourse().getCourseTeacher().getCourse().getCourseName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
