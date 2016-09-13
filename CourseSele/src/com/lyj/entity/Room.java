package com.lyj.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "room", catalog = "zs")
public class Room implements java.io.Serializable {

	// Fields

	private Integer roomId;
	private Integer roomScale;
	private String roomType;
//	private Set<CourseTeacher> courseTeachers = new HashSet<CourseTeacher>(0);

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** full constructor */
	public Room(Integer roomScale, String roomType,
			Set<CourseTeacher> courseTeachers) {
		this.roomScale = roomScale;
		this.roomType = roomType;
//		this.courseTeachers = courseTeachers;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "room_id", unique = true, nullable = false)
	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Column(name = "room_scale")
	public Integer getRoomScale() {
		return this.roomScale;
	}

	public void setRoomScale(Integer roomScale) {
		this.roomScale = roomScale;
	}

	@Column(name = "room_type")
	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "room")
//	public Set<CourseTeacher> getCourseTeachers() {
//		return this.courseTeachers;
//	}
//
//	public void setCourseTeachers(Set<CourseTeacher> courseTeachers) {
//		this.courseTeachers = courseTeachers;
//	}

}