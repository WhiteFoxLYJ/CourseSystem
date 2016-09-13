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

import com.lyj.biz.EduadminBiz;
import com.lyj.biz.StudentBiz;
import com.lyj.biz.TeacherBiz;
import com.lyj.entity.Eduadmin;
import com.lyj.entity.Student;
import com.lyj.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@Controller//用于标注控制层组件（如struts中的action）
@Scope("prototype")//每次请求都创建一个实例
public class LoginAction extends ActionSupport {
	private int Id;//登录编号
	private String name;//登录名字
	private int login_pwd;//登录密码
	private Student student;//学生类
	private Eduadmin eduadmin;//教务类
	private Teacher teacher;//教师类
	private String type;//登录用户类型
	//用于参数的接受以及类型的转换
	private String Password;//登录密码
	//set&get方法
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLogin_pwd() {
		return login_pwd;
	}
	public void setLogin_pwd(int login_pwd) {
		this.login_pwd = login_pwd;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Eduadmin getEduadmin() {
		return eduadmin;
	}
	public void setEduadmin(Eduadmin eduadmin) {
		this.eduadmin = eduadmin;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Resource//依赖注入
	TeacherBiz teacherBiz;
	StudentBiz studentBiz;
	EduadminBiz eduadminBiz;
	public void setTeacherBiz(TeacherBiz teacherBiz) {
		this.teacherBiz = teacherBiz;
	}
	public void setStudentBiz(StudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}
	public void setEduadminBiz(EduadminBiz eduadminBiz) {
		this.eduadminBiz = eduadminBiz;
	}
	
	Map<String,Object> mapMap; 
	public void setMapMap(Map<String, Object> mapMap) {
		this.mapMap = mapMap;
	}
	
	//登录
	@Action(value="loginAction",results={
			@Result(name="eduadmin",location="/Eduadmin.jsp"),
			@Result(name="student",location="/Student.jsp"),
			@Result(name="error",location="/index.jsp")
	})
	public String Login() throws Exception{
		List slist=null;
		System.out.println("----------Id:"+Id);
		System.out.println("----------Name:"+name);
		System.out.println("----------Password:"+Password);
		System.out.println("----------signal:"+type);
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		studentBiz=(StudentBiz) context.getBean("studentBiz");
		if(type.equals("学生")){//当前登录用户的类型为学生的时候
			Student conStudent=new Student();
			conStudent.setStudentId(Id);//获取登录的Id
			conStudent.setStudentName(name);//获取登录的名字
			conStudent.setStudentPassword(Password);//获取登录的密码
//			System.out.println("-----------------------------------------");
			slist=studentBiz.FindStudent(conStudent);//匹配当前学生的登录信息
			System.out.println("slist.size="+slist.size());
			//测试获取的学生的信息
			for (Iterator iterator = slist.iterator(); iterator.hasNext();) {
				Student object = (Student) iterator.next();
				System.out.println(object.getStudentId()+"--"+object.getStudentName()+"--"+object.getStudentSex());
			}
//			System.out.println("slist.size()=="+slist.size());
			if(slist.size()>0){//当slist中存在记录的时候
				System.out.println("登录成功-->");
				System.out.println("登录Id："+Id);
				System.out.println("登录密码:"+Password);
				System.out.println("登录name："+name);
				ActionContext.getContext().getSession().clear();
				mapMap=(Map<String, Object>) ActionContext.getContext().getSession().put("login_id", Id);
				mapMap=(Map<String, Object>) ActionContext.getContext().getSession().put("login_name", name);
				return "student";
			}else{//不存在记录的时候
				System.out.println("登录失败<--");
				return "error";
			}
		}else if(type.equals("教务")){//当当前的登录用户类型为教务的时候
//			Teacher conTeacher=new Teacher();
			Eduadmin conEduadmin=new Eduadmin();
			conEduadmin.setId(Id);//获取当前登录的id
			conEduadmin.setName(name);//获取当前登录的用户名称
			conEduadmin.setPassword(Password);//获取当前登录的用户的密码
			slist=eduadminBiz.FindEduadmin(conEduadmin);//匹配当前用户的所有信息
//			System.out.println("slist.size="+slist.size());
			//测试输出当前的教务的信息
			for (Iterator iter = slist.iterator(); iter.hasNext();) {
				  Eduadmin str = (Eduadmin)iter.next();
				  System.out.println(str.getId()+"--"+str.getName()+"--"+str.getSex());
				 }
//			System.out.println("elist.get(0)="+slist.get(0).toString());
			if(slist.size()>0){//当slist的存在教务信息内容
				System.out.println("登录成功-->");
				System.out.println("登录Id："+Id);
				System.out.println("登录密码:"+Password);
				System.out.println("登录name："+name);
				ActionContext.getContext().getSession().clear();
				mapMap=(Map<String, Object>) ActionContext.getContext().getSession().put("login_id", Id);
				mapMap=(Map<String, Object>) ActionContext.getContext().getSession().put("login_name", name);
				return "eduadmin";
			}else{
				System.out.println("登录失败<--");
				return "error";
			}
		}else{
			return "error";
		}
//		
//		System.out.println("Map:"+mapMap);
//		if(slist.size()>0){
//			System.out.println("登录成功-->");
//			System.out.println("登录Id："+Id);
//			System.out.println("登录name："+name);
//			ActionContext.getContext().getSession().clear();
//			mapMap=(Map<String, Object>) ActionContext.getContext().getSession().put("login_id", Id);
//			mapMap=(Map<String, Object>) ActionContext.getContext().getSession().put("login_name", name);
//			return "success";
//		}else{
//			System.out.println("登录失败<--");
//			return "error";
//		}
		
		
	}
	
}
