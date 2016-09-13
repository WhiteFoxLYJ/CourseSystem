package com.lyj.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CourseTeacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course_teacher", catalog = "zs")
public class CourseTeacher implements java.io.Serializable {

	// Fields

	private Integer ctId;
	private Coursetime coursetime;
	private Course course;
	private Room room;
	private Teacher teacher;
	private Eduadmin eduadmin;
//	private Set<SelectCourse> selectCourses = new HashSet<SelectCourse>(0);

	// Constructors

	/** default constructor */
	public CourseTeacher() {
	}

	/** full constructor */
	public CourseTeacher(Coursetime coursetime, Course course,
			Room room, Teacher teacher, Eduadmin eduadmin,
			Set<SelectCourse> selectCourses) {
		this.coursetime = coursetime;
		this.course = course;
		this.room = room;
		this.teacher = teacher;
		this.eduadmin = eduadmin;
//		this.selectCourses = selectCourses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ct_id", unique = true, nullable = false)
	public Integer getCtId() {
		return this.ctId;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "time_id")
	public Coursetime getCoursetime() {
		return this.coursetime;
	}

	public void setCoursetime(Coursetime coursetime) {
		this.coursetime = coursetime;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_id")
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "teacher_id")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eduadmin_id")
	public Eduadmin getEduadmin() {
		return this.eduadmin;
	}

	public void setEduadmin(Eduadmin eduadmin) {
		this.eduadmin = eduadmin;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "courseTeacher")
//	public Set<SelectCourse> getSelectCourses() {
//		return this.selectCourses;
//	}
//
//	public void setSelectCourses(Set<SelectCourse> selectCourses) {
//		this.selectCourses = selectCourses;
//	}

}