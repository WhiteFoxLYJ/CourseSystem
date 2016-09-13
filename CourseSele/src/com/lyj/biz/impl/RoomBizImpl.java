package com.lyj.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.biz.RoomBiz;
import com.lyj.dao.RoomDAO;
import com.lyj.entity.Room;

@Service("roomBiz")
public class RoomBizImpl implements RoomBiz {
	@Resource
	RoomDAO roomDAO;

	public void setRoomDAO(RoomDAO roomDAO) {
		// TODO Auto-generated method stub
		this.roomDAO = roomDAO;
	}

	@Override
	public List FindRoom(Room condition) {
		// TODO Auto-generated method stub
		return roomDAO.FindRoom(condition);
	}

	@Override
	public void AddRoom(Room room) {
		// TODO Auto-generated method stub
		roomDAO.AddRoom(room);
	}

	// @Override
	// public String AddRoom(Room room) {
	// // TODO Auto-generated method stub
	// return roomDAO.AddRoom(room);
	// }

	@Override
	public List GetAllRoom() {

		return roomDAO.GetAllRoom();
	}

	@Override
	public void DeleteRoom(Room room) {
		// TODO Auto-generated method stub
		roomDAO.DeleteRoom(room);
	}

	@Override
	public void UpdateRoom(Room room) {
		// TODO Auto-generated method stub
		roomDAO.UpdateRoom(room);
	}

}
