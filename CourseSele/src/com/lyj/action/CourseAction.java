package com.lyj.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.lyj.biz.CourseBiz;
import com.lyj.biz.CourseTeacherBiz;
import com.lyj.biz.SelectCourseBiz;
import com.lyj.biz.StudentCourseBiz;
import com.lyj.entity.Course;
import com.lyj.entity.CourseTeacher;
import com.lyj.entity.SelectCourse;
import com.lyj.entity.StudentCourse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("json-default")
@Controller//用于标注控制层组件（如struts中的action）
@Scope("prototype")//每次请求都创建一个实例
public class CourseAction extends ActionSupport {
	private int CourseId;//课程id
	private String CourseName;//课程名称
	private String CourseDESC;//课程描述
	private int CourseType;//课程类型
	private int CoursePeriod;//课程学时
	private float CourseCredit; //课程学分
	//用于参数传递的类型转换
	private String CourseTypeC;//课程类型
	private String CoursePeriodC;//课程学时
	Map<String,Object> request=null;
	//set&get方法
	public String getCourseTypeC() {
		return CourseTypeC;
	}
	public void setCourseTypeC(String courseTypeC) {
		CourseTypeC = courseTypeC;
	}
	public String getCoursePeriodC() {
		return CoursePeriodC;
	}
	public void setCoursePeriodC(String coursePeriodC) {
		CoursePeriodC = coursePeriodC;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getCourseDESC() {
		return CourseDESC;
	}
	public void setCourseDESC(String courseDESC) {
		CourseDESC = courseDESC;
	}
	public int getCourseType() {
		return CourseType;
	}
	public void setCourseType(int courseType) {
		CourseType = courseType;
	}
	public int getCoursePeriod() {
		return CoursePeriod;
	}
	public void setCoursePeriod(int coursePeriod) {
		CoursePeriod = coursePeriod;
	}
	public float getCourseCredit() {
		return CourseCredit;
	}
	public void setCourseCredit(float courseCredit) {
		CourseCredit = courseCredit;
	}

	@Resource//依赖注入
	CourseBiz courseBiz;
	CourseTeacherBiz courseteacherBiz;
	SelectCourseBiz selectcourseBiz;
	StudentCourseBiz studentcourseBiz;
	public void setCourseBiz(CourseBiz courseBiz){
		this.courseBiz=courseBiz;
	}
	public void setCourseteacherBiz(CourseTeacherBiz courseteacherBiz) {
		this.courseteacherBiz = courseteacherBiz;
	}
	public void setSelectcourseBiz(SelectCourseBiz selectcourseBiz) {
		this.selectcourseBiz = selectcourseBiz;
	}
	public void setStudentcourseBiz(StudentCourseBiz studentcourseBiz) {
		this.studentcourseBiz = studentcourseBiz;
	}
	//查询课程
	@Action(value="getAllCourse",results={
			@Result(name="success",location="/CourseInfo.jsp"),
			@Result(name="error",location="error.jsp")
	})
	public String FindCourse()throws Exception{
		request=(Map<String, Object>) ActionContext.getContext().get("request");
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		courseBiz=(CourseBiz) context.getBean("courseBiz");
		Course conditon=new Course();
		List clist=courseBiz.GetAllCourse();
		for (Iterator iterator = clist.iterator(); iterator.hasNext();) {
			Course object = (Course) iterator.next();
			System.out.println(object.getCourseId()+"--"+object.getCourseName()+"--"+object.getCourseDesc());
		}
		System.out.println("clist="+clist.size());
		request.put("clist", clist);
		if(clist.size()>0){
			return "success";
		}else{
			return "error";
		}
	}
	
	//添加新的课程
	@Action(value="CourseAdd",results={
			@Result(name="success",type="redirectAction",location="getAllCourse"),
			@Result(name="error",location="error.jsp")
	})
	public String AddCourse()throws Exception{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		courseBiz=(CourseBiz) context.getBean("courseBiz");
		Course courseA=new Course();
//		courseA.setCourseId(2);
		System.out.println("本次添加入库的课程信息");
		System.out.println("课程名称"+CourseName);
		System.out.println("课程学分"+CourseCredit);
		System.out.println("课程学时"+CoursePeriod);
		System.out.println("课程类型"+CourseType);
		System.out.println("课程描述"+CourseDESC);
		courseA.setCourseName(CourseName);
		courseA.setCourseDesc(CourseDESC);
		courseA.setCourseCredit(CourseCredit);//float
		courseA.setCoursePeriod(CoursePeriod);//int
		courseA.setCourseType(CourseType);//int
		try {
			courseBiz.AddCourse(courseA);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String DelCourse()throws Exception{
		System.out.println("课程编号："+CourseId);
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		courseBiz=(CourseBiz) context.getBean("courseBiz");
		Course courseD=new Course();
		courseD.setCourseId(CourseId);
		try {
			courseBiz.DeleteCourse(courseD);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	List clist=null;
	public List getClist() {
		return clist;
	}
	public void setClist(List clist) {
		this.clist = clist;
	}
		//JSON查询课程
		@Action(value="GetAllCourse",results={
				@Result(name="success",type="json",params={"root","clist"}),
				@Result(name="error",location="error.jsp")
		})
		public String GetAllCourse()throws Exception{
			System.out.println("GetAllCourse.action");
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			courseBiz=(CourseBiz) context.getBean("courseBiz");
			Course conditon=new Course();
			clist=courseBiz.GetAllCourse();
//			for (Iterator iterator = clist.iterator(); iterator.hasNext();) {
//				Course object = (Course) iterator.next();
//				System.out.println(object.getCourseId()+"--"+object.getCourseName()+"--"+object.getCourseDesc());
//			}
			System.out.println("clist="+clist.size());
			if(clist.size()>0){
				System.out.println("-----------");
				System.out.println("GetAllCourse success json");
				return "success";
			}else{
				System.out.println("GetAllCourse error json");
				return "error";
			}
		}
	
		String Amessage;
		public String getAmessage() {
			return Amessage;
		}
		public void setAmessage(String amessage) {
			Amessage = amessage;
		}
		
		//JSON添加新的课程
		@Action(value="AddNewCourse",results={
				@Result(name="success",type="json",params={"root","Amessage"}),
				@Result(name="error",location="error.jsp")
		})
		public String AddNewCourse()throws Exception{
			System.out.println("AddNewCourse()");
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			courseBiz=(CourseBiz) context.getBean("courseBiz");
			Course courseA=new Course();

			CourseType=Integer.parseInt(CourseTypeC);
			CoursePeriod=Integer.parseInt(CoursePeriodC);
			courseA.setCourseName(CourseName);
			courseA.setCourseDesc(CourseDESC);
			courseA.setCourseCredit(CourseCredit);//float
			courseA.setCoursePeriod(CoursePeriod);//int
			courseA.setCourseType(CourseType);//int
			try {
				courseBiz.AddCourse(courseA);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				Amessage="1";
				return "error";
			}
			System.out.println("录入新的课程啦~~");
			Amessage="0";
			return "success";
		}
		
		private String CouresID;
		public String getCouresID() {
			return CouresID;
		}
		public void setCouresID(String couresID) {
			CouresID = couresID;
		}
		//JSON删除课程信息
		@Action(value="DeleteCourse",results={
				@Result(name="success",type="json",params={"root","Amessage"}),
//				@Result(name="success",location="/CourseInfo.jsp"),
				@Result(name="error",location="error.jsp")
		})
		public String DeleteCourse()throws Exception{
			System.out.println("课程编号："+CouresID);
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			courseBiz=(CourseBiz) context.getBean("courseBiz");
			courseteacherBiz=(CourseTeacherBiz) context.getBean("courseteacherBiz");
			selectcourseBiz=(SelectCourseBiz) context.getBean("selectcourseBiz");
			studentcourseBiz=(StudentCourseBiz) context.getBean("studentcourseBiz");
			Course courseD=new Course();
			CourseTeacher ct=new CourseTeacher();
			SelectCourse slc=new SelectCourse();
			StudentCourse stc=new StudentCourse();
			CourseId=Integer.parseInt(CouresID);
			courseD.setCourseId(CourseId);
			ct.setCourse(courseD);
			slc.setCourseTeacher(ct);
			stc.setSelectCourse(slc);
			try {
				studentcourseBiz.DeleteStudentCourse(stc);
				selectcourseBiz.DeleteSC(slc);
				courseteacherBiz.DeleteCourseTeacher(ct);
				courseBiz.DeleteCourse(courseD);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				Amessage="1";
				return "error";
			}
			Amessage="0";
			System.out.println("删除课程成功");
			return "success";
		}
}
