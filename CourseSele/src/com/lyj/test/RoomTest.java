package com.lyj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyj.biz.RoomBiz;
import com.lyj.entity.Room;
import java.util.*;

public class RoomTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// System.out.println("-----------");
		RoomBiz roomBiz = (RoomBiz) context.getBean("roomBiz");
		Room conditon = new Room();
		// conditon.setRoomId(1);
		// 添加一个教室
		// conditon.setRoomScale(300);
		// conditon.setRoomType("多媒体教室");
		// roomBiz.AddRoom(conditon);
		List Rlist = roomBiz.GetAllRoom();
		System.out.println("---" + Rlist);
		// for(int i=0;i<Rlist.size();i++){
		// System.out.println(Rlist.get(i).toString());
		// }
		// for循环输出Rlist中的值
		for (Iterator iter = Rlist.iterator(); iter.hasNext();) {
			Room str = (Room) iter.next();
			System.out.println(str.getRoomId() + "--" + str.getRoomScale()
					+ "--" + str.getRoomType());
		}
	}

}
