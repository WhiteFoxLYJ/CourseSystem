package com.lyj.biz;

import java.util.List;

import com.lyj.entity.Room;

public interface RoomBiz {

	public List FindRoom(Room condition);

	public void AddRoom(Room room);

	public void DeleteRoom(Room room);

	public void UpdateRoom(Room room);

	public List GetAllRoom();
}
