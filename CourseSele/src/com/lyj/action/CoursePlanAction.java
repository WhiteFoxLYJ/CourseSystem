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
import com.lyj.biz.CoursetimeBiz;
import com.lyj.biz.RoomBiz;
import com.lyj.biz.SelectCourseBiz;
import com.lyj.biz.StudentCourseBiz;
import com.lyj.biz.TeacherBiz;
import com.lyj.entity.Course;
import com.lyj.entity.CourseTeacher;
import com.lyj.entity.Coursetime;
import com.lyj.entity.Eduadmin;
import com.lyj.entity.Room;
import com.lyj.entity.SelectCourse;
import com.lyj.entity.StudentCourse;
import com.lyj.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("json-default")
@Controller//用于标注控制层组件（如struts中的action）
@Scope("prototype")//每次请求都创建一个实例
//教务-课程安排操作
public class CoursePlanAction extends ActionSupport {

	private Course course;//课程类
	private Teacher teacher;//教师类
	private Coursetime coursetime;//授课时间类
	private Room room;//教室类

	private int ct_id;//排课id
	private int room_id;//教室id
	private int course_id;//课程id
	private int teacher_id;//教师id
	private int time_id;//授课时间id
	private int openTime_id;

	//传参以及参数转换使用
	private String courseId;//课程id
	private String roomId;//教室id
	private String teacherId;//教师id
	private String timeId;//授课时间id
	//set&get方法
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTimeId() {
		return timeId;
	}

	public void setTimeId(String timeId) {
		this.timeId = timeId;
	}

	public int getOpenTime_id() {
		return openTime_id;
	}

	public void setOpenTime_id(int openTime_id) {
		this.openTime_id = openTime_id;
	}

	public int getCt_id() {
		return ct_id;
	}

	public void setCt_id(int ct_id) {
		this.ct_id = ct_id;
	}

	public int getTime_id() {
		return time_id;
	}

	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Coursetime getCoursetime() {
		return coursetime;
	}

	public void setCoursetime(Coursetime coursetime) {
		this.coursetime = coursetime;
	}

	public void setCourseteacherBiz(CourseTeacherBiz courseteacherBiz) {
		this.courseteacherBiz = courseteacherBiz;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Resource//依赖注入
	CourseTeacherBiz courseteacherBiz;//排课
	StudentCourseBiz studentcourseBiz;//学生课程表
	SelectCourseBiz selectcourseBiz;//学生选课
	TeacherBiz teacherBiz;//教师
	CourseBiz courseBiz;//课程
	RoomBiz roomBiz;//教室
	CoursetimeBiz coursetimeBiz;//授课时间

	public void setStudentcourseBiz(StudentCourseBiz studentcourseBiz) {
		this.studentcourseBiz = studentcourseBiz;
	}

	public void setSelectcourseBiz(SelectCourseBiz selectcourseBiz) {
		this.selectcourseBiz = selectcourseBiz;
	}

	public void setTeacherBiz(TeacherBiz teacherBiz) {
		this.teacherBiz = teacherBiz;
	}

	public void setCourseBiz(CourseBiz courseBiz) {
		this.courseBiz = courseBiz;
	}

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}

	public void setCoursetimeBiz(CoursetimeBiz coursetimeBiz) {
		this.coursetimeBiz = coursetimeBiz;
	}

	Map<String, Object> session;//session用于存储和获取登录信息

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// 添加课程计划
	/*
	 * @Action(value="AddCoursePlan",results={
	 * 
	 * @Result(name="success",type="redirectAction",location="getAllPlan"),
	 * 
	 * @Result(name="error",location="error.jsp") }) public String
	 * CoursePla()throws Exception{ ApplicationContext context=new
	 * ClassPathXmlApplicationContext("applicationContext.xml");
	 * courseteacherBiz=(CourseTeacherBiz) context.getBean("courseTeacherBiz");
	 * CourseTeacher ct=new CourseTeacher(); course.setCourseId(course_id);
	 * room.setRoomId(room_id); teacher.setTeacherId(teacher_id);
	 * coursetime.setTimeId(time_id); ct.setCourse(course); ct.setRoom(room);
	 * ct.setTeacher(teacher); ct.setCoursetime(coursetime); try {
	 * courseteacherBiz.AddCourseTeacher(ct); } catch (Exception e) { // TODO:
	 * handle exception e.printStackTrace(); return "error"; } return "success";
	 * }
	 */

	// 获取所有安排的课程
	@Action(value = "getAllPlan", results = {
			@Result(name = "success", location = "/CoursePlanShow.jsp"),
			@Result(name = "error", location = "error.jsp") })
	public String FindAllCP() throws Exception {
		List cplist = null;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		courseteacherBiz = (CourseTeacherBiz) context
				.getBean("courseteacherBiz");
		cplist = courseteacherBiz.GetAllCourseTeacher();
		for (Iterator iter = cplist.iterator(); iter.hasNext();) {
			CourseTeacher str = (CourseTeacher) iter.next();
			System.out.println(str.getCtId() + "--"
					+ str.getCourse().getCourseName() + "--"
					+ str.getTeacher().getTeacherName());
		}
		session = ActionContext.getContext().getSession();
		try {
			session.put("cplist", cplist);
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
		// System.out.println("到这了吗？？？？？");
		return "success";

	}

	// 在页面上显示teacher course room time（用于编排新的课程）
	@Action(value = "getCTRInfo", results = {
			@Result(name = "success", location = "/CoursePlan.jsp"),
			@Result(name = "error", location = "error.jsp") })
	public String Getinfo() throws Exception {
		List clist = null;
		List tlist = null;
		List rlist = null;
		List ctlist = null;
		List timelist = null;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		roomBiz = (RoomBiz) context.getBean("roomBiz");
		teacherBiz = (TeacherBiz) context.getBean("teacherBiz");
		courseBiz = (CourseBiz) context.getBean("courseBiz");
		coursetimeBiz = (CoursetimeBiz) context.getBean("coursetimeBiz");
		rlist = roomBiz.GetAllRoom();
		tlist = teacherBiz.GetAllTeacher();
		clist = courseBiz.GetAllCourse();
		ctlist = coursetimeBiz.GetAllCoursetime();
		// 测试输入的信息
//		for (Iterator iterator = ctlist.iterator(); iterator.hasNext();) {
//			Coursetime object = (Coursetime) iterator.next();
//			System.out.println("时间：" + object.getTimeDesc());
//		}

		session = ActionContext.getContext().getSession();
		try {
			session.put("rlist", rlist);
			session.put("tlist", tlist);
			session.put("clist", clist);
			session.put("ctlist", ctlist);
			session.put("timelist", timelist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	// 安排一门课程
	@Action(value = "AddCoursePlan", results = {
			@Result(name = "success", type = "redirectAction", location = "getAllPlan"),
			@Result(name = "error", location = "error.jsp") })
	public String Plan() throws Exception {
		
		List Elist = null;
		List Plist = null;
		List rlist = null;
		List clist = null;
		List tlist = null;
		List ctlist = null;

		List xlist = null;

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		session = ActionContext.getContext().getSession();
		try {
			Room rc = new Room();
			rc.setRoomId(room_id);

			Course cc = new Course();
			cc.setCourseId(course_id);

			Teacher tc = new Teacher();
			tc.setTeacherId(teacher_id);

			Coursetime ct = new Coursetime();
			ct.setTimeId(time_id);// 上课时间

			Eduadmin ed = new Eduadmin();
			session = (Map<String, Object>) ActionContext.getContext()
					.getSession();
			Object obj = new Object();
			obj = session.get("login_id");
			System.out.println("obj:" + obj);
			ed.setId(Integer.parseInt(String.valueOf(obj)));
			// ctlist=coursetimeBiz.FindCoursetime(ct);

			System.out.println("courseID:" + course_id);
			System.out.println("roomID:" + room_id);
			System.out.println("teacherID:" + teacher_id);
			System.out.println("timeID:" + time_id);
			System.out.println("eduadminID:" + obj);
			System.out.println("openTimeID:" + openTime_id);

			CourseTeacher ctc = new CourseTeacher();
			ctc.setRoom(rc);
			ctc.setTeacher(tc);
			ctc.setCourse(cc);
			ctc.setCoursetime(ct);
			ctc.setEduadmin(ed);
			// List findctlist=courseteacherBiz.FindCourseTeacher(ctc);
			// if(findctlist.size()>0){
			// courseteacherBiz.UpdateCourseTeacher(ctc);
			// return "error";
			// }else{
			courseteacherBiz.AddCourseTeacher(ctc);
			return "success";
			// }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}

	}
	//添加新课程安排
	@Action(value="SetNewPlan",results={
			@Result(name="success",type="json",params={"root","message"}),
			@Result(name="error",location="error.jsp")
	})
	public String SetNewPlan() throws Exception {
		
		System.out.println("course_id:"+courseId);
		System.out.println("room_id:"+roomId);
		System.out.println("teacher_id:"+teacherId);
		System.out.println("time_id:"+timeId);
		course_id=Integer.parseInt(courseId);
		room_id=Integer.parseInt(roomId);
		teacher_id=Integer.parseInt(teacherId);
		time_id=Integer.parseInt(timeId);
		System.out.println("course_id:"+courseId);
		System.out.println("room_id:"+roomId);
		System.out.println("teacher_id:"+teacherId);
		System.out.println("time_id:"+timeId);
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("--------AddPlan-------");
		System.out.println("---------------------");
		System.out.println("---------------------");
		List Elist = null;
		List Plist = null;
		List rlist = null;
		List clist = null;
		List tlist = null;
		List ctlist = null;

		List xlist = null;
		String message=null;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		session = ActionContext.getContext().getSession();
		try {
			Room rc = new Room();
			rc.setRoomId(room_id);

			Course cc = new Course();
			cc.setCourseId(course_id);

			Teacher tc = new Teacher();
			tc.setTeacherId(teacher_id);

			Coursetime ct = new Coursetime();
			ct.setTimeId(time_id);// 上课时间

			Eduadmin ed = new Eduadmin();
			session = (Map<String, Object>) ActionContext.getContext()
					.getSession();
			Object obj = new Object();
			obj = session.get("login_id");
			System.out.println("obj:" + obj);
			ed.setId(Integer.parseInt(String.valueOf(obj)));
			// ctlist=coursetimeBiz.FindCoursetime(ct);

			System.out.println("courseID:" + course_id);
			System.out.println("roomID:" + room_id);
			System.out.println("teacherID:" + teacher_id);
			System.out.println("timeID:" + time_id);
			System.out.println("eduadminID:" + obj);
			System.out.println("openTimeID:" + openTime_id);

			CourseTeacher ctc = new CourseTeacher();
			ctc.setRoom(rc);
			ctc.setTeacher(tc);
			ctc.setCourse(cc);
			ctc.setCoursetime(ct);
			ctc.setEduadmin(ed);
			// List findctlist=courseteacherBiz.FindCourseTeacher(ctc);
			// if(findctlist.size()>0){
			// courseteacherBiz.UpdateCourseTeacher(ctc);
			// return "error";
			// }else{
			courseteacherBiz.AddCourseTeacher(ctc);
			message="0";
			return "success";
			// }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message="1";
			return "error";
		}

	}

	//删除课程安排
	@Action(value = "DeletePlan", results = {
			@Result(name = "success", type = "redirectAction", location = "getAllPlan"),
			@Result(name = "error", location = "error.jsp") })
	public String DeletePlan() throws Exception {
		System.out.println("ct_id:" + ct_id);
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		courseteacherBiz = (CourseTeacherBiz) context
				.getBean("courseteacherBiz");
		courseBiz = (CourseBiz) context.getBean("courseBiz");
		studentcourseBiz = (StudentCourseBiz) context
				.getBean("studentcourseBiz");
		selectcourseBiz = (SelectCourseBiz) context.getBean("selectcourseBiz");
		SelectCourse slc = new SelectCourse();
		StudentCourse stc = new StudentCourse();
		CourseTeacher ctc = new CourseTeacher();
		Course cour = new Course();
		cour.setCourseId(course_id);
		ctc.setCtId(ct_id);
		ctc.setCourse(cour);
		slc.setCourseTeacher(ctc);
		stc.setSelectCourse(slc);
		try {
			studentcourseBiz.DeleteStudentCourse(stc);
			selectcourseBiz.DeleteSC(slc);
			courseteacherBiz.DeleteCourseTeacher(ctc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	List acplist = null;

	public List getAcplist() {
		return acplist;
	}

	public void setAcplist(List acplist) {
		this.acplist = acplist;
	}

	//获取所有的课程安排
	@Action(value="getCoursePlan",results={
			// @Result(name="success",location="/CoursePlanShow.jsp",type="json",params={"root","cplist"}),
			@Result(name="success",type ="json",params={"root","acplist"})
			})
	public String FindAllCoursePlan() throws Exception {
		System.out.println("getCoursePlan");
//		acplist=null;
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		courseteacherBiz = (CourseTeacherBiz) context.getBean("courseteacherBiz");
//		session = ActionContext.getContext().getSession();
//		session.put("acplist", acplist);
		acplist = courseteacherBiz.GetAllCourseTeacher();
		System.out.println("getCoursePlan----size：" + acplist.size());
		for (Iterator iter = acplist.iterator(); iter.hasNext();) {
			CourseTeacher str = (CourseTeacher) iter.next();
			System.out.println(str.getCtId() + "--"
					+ str.getCourse().getCourseName() + "--"
					+ str.getTeacher().getTeacherName());
		}
		System.out.println("到这了吗？？？？？");
		
		return "success";

	}

	//获取用于进行课程安排的教室，教师，课程，授课时间的信息
	@Action(value = "getCTRTInfo", results = {
			@Result(name = "success", type = "json", params = { "rootclist",
					"clist", "rootctlist", "ctlist", "rootrlist", "rlist",
					"roottlist", "tlist" }),
			@Result(name = "error", location = "error.jsp") })
	public String GetCTRTInfo() throws Exception {
		List clist = null;
		List tlist = null;
		List rlist = null;
		List ctlist = null;

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		roomBiz = (RoomBiz) context.getBean("roomBiz");
		teacherBiz = (TeacherBiz) context.getBean("teacherBiz");
		courseBiz = (CourseBiz) context.getBean("courseBiz");
		coursetimeBiz = (CoursetimeBiz) context.getBean("coursetimeBiz");

		session = ActionContext.getContext().getSession();
		try {
			rlist = roomBiz.GetAllRoom();
			tlist = teacherBiz.GetAllTeacher();
			clist = courseBiz.GetAllCourse();
			ctlist = coursetimeBiz.GetAllCoursetime();
			// 测试输入的信息
			for (Iterator iterator = ctlist.iterator(); iterator.hasNext();) {
				Coursetime object = (Coursetime) iterator.next();
				System.out.println("时间：" + object.getTimeDesc());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

}
