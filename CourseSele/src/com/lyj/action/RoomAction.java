package com.lyj.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.lyj.biz.RoomBiz;
import com.lyj.entity.Eduadmin;
import com.lyj.entity.Room;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("json-default")
@Controller//用于标注控制层组件（如struts中的action）
@Scope("prototype")//每次请求都创建一个实例
public class RoomAction extends ActionSupport {
	
	//定义Room类型的room对象
	private Room room;
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

	Map<String, Object> session;//定义Map类型的session用于存储或这获取当前用户的登录信息
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	Map<String, Object> request;
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Resource
	RoomBiz roomBiz;
	public void setRoomBiz(RoomBiz roomBiz){
		this.roomBiz=roomBiz;
	}
	
	private int room_id;//教室标号
	private int room_scale;//教室容量（可容纳人数）
	private String room_type;//教室类型
	private String Addmessage;//用于json传递的参数
	//set&get方法
	public String getAddmessage() {
		return Addmessage;
	}
	public void setAddmessage(String addmessage) {
		Addmessage = addmessage;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getRoom_scale() {
		return room_scale;
	}
	public void setRoom_scale(int room_scale) {
		this.room_scale = room_scale;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	private String Scale;
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}

	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private ArrayList<Room> conlist;
	public ArrayList<Room> getConlist() {
		return conlist;
	}
	public void setConlist(ArrayList<Room> conlist) {
		this.conlist = conlist;
	}
	List rlist;
	List frlist;
	
	public List getRlist() {
		return rlist;
	}
	public void setRlist(List rlist) {
		this.rlist = rlist;
	}
	public List getFrlist() {
		return frlist;
	}
	public void setFrlist(List frlist) {
		this.frlist = frlist;
	}
	//获取所有的教室信息
	@Action(value="getAllRoom",results={
//			@Result(name="success",location="/RoomInfo.jsp",params={"frlist","frlist"},type="json"),
			@Result(name="success",location="/RoomInfo.jsp"),
			@Result(name="error",location="/error.jsp")
			
	})
	public String FindAllRoom()throws Exception{
		request=(Map<String, Object>) ActionContext.getContext().get("request");//获取Session
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RoomBiz roomBiz=(RoomBiz) context.getBean("roomBiz");
//		frlist=roomBiz.GetAllRoom();
		try {
			frlist=roomBiz.GetAllRoom();//获取所有的教室的信息
			conlist=(ArrayList<Room>) roomBiz.GetAllRoom();//调用Biz层的获取所有教室信息的方法GetAllRoom()获取信息
			request.put("frlist", frlist);
			request.put("conlist", conlist);
			System.out.println("frlist size:"+frlist.size());
			System.out.println("colist size:"+conlist.size());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";	
	}
	
	//json方式获取全部教室的信息
	@Action(value="getRoomInfo",results={
			@Result(name="success",type="json",params={"root","frlist"}),
			@Result(name="error",location="error.jsp")
	})
	public String getAllRoom()throws Exception{

		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RoomBiz roomBiz=(RoomBiz) context.getBean("roomBiz");

			frlist=roomBiz.GetAllRoom();//获取所有教室信息的方法
			System.out.println("传回来了吗？？？？"+"frlist"+frlist.size());
		return "success";	
	}
	
	//删除某间教室的信息
	@Action(value="RoomDelete",results={
			@Result(name="success",type="redirectAction",location="getAllRoom"),
			@Result(name="error",location="error.jsp")
	})
	public String DelRoom() throws Exception{
		System.out.println("教室编号："+room_id);
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		roomBiz=(RoomBiz) context.getBean("roomBiz");
		Room roomD=new Room();
		roomD.setRoomId(room_id);
		try {
			roomBiz.DeleteRoom(roomD);//通过Biz层来调用删除某间教室的方法DeleteRoom()方法
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	//json的方式来添加教室的信息
	@Action(value="RoomAdd_test",results={
			@Result(name="success",type="json",params={"root","Addmessage"}),
			@Result(name="error",location="error.jsp")
	})
	public String AddRoom_test()throws Exception{
		System.out.println("-----------------------------------RoomAdd_test");
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		roomBiz=(RoomBiz) context.getBean("roomBiz");
		room_scale=Integer.parseInt(Scale);
		System.out.println("room_scale"+room_scale);
		System.out.println("room_type"+room_type);
		Room room1=new Room();
		room1.setRoomScale(room_scale);
		room1.setRoomType(room_type);
		try {
			roomBiz.AddRoom(room1);
			System.out.println("------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
			Addmessage="1";

			return "error";
		}
		Addmessage="0";

		System.out.println("到这里了吗");
		return "success";
	}
	
	@Action(value="RoomDelete_test",results={
			@Result(name="success",type="json",params={"root","Addmessage"}),
			@Result(name="error",location="error.jsp")
	})
	public String DelRoomtest() throws Exception{
		System.out.println("教室编号："+room_id);//测试是否获取jsp页面上传过来的教室id
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		roomBiz=(RoomBiz) context.getBean("roomBiz");
		Room roomD=new Room();
		roomD.setRoomId(room_id);
		try {
			roomBiz.DeleteRoom(roomD);//根据id来删除一个教室room信息
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Addmessage="1";
			return "error";
		}
		Addmessage="0";
		return "success";
	}
	
	//添加教室
	@Action(value="RoomAdd",results={
			@Result(name="success",type="redirectAction",location="getAllRoom"),
			@Result(name="error",location="error.jsp")
	})
	public String AddRoom()throws Exception{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		roomBiz=(RoomBiz) context.getBean("roomBiz");
		Room room1=new Room();
		room1.setRoomScale(room_scale);//教室的可容纳人数获取
		room1.setRoomType(room_type);//教室的类型获取
		try {
			roomBiz.AddRoom(room1);//添加一个新的教室room的信息
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
