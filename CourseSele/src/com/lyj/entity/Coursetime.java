package com.lyj.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Coursetime entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "coursetime", catalog = "zs")
public class Coursetime implements java.io.Serializable {

	// Fields

	private Integer timeId;
	private Date lessonTime;
	private String timeDesc;
	private Integer timeNum;
//	private Set<CourseTeacher> courseTeachers = new HashSet<CourseTeacher>(0);

	// Constructors

	/** default constructor */
	public Coursetime() {
	}

	/** full constructor */
	public Coursetime(Date lessonTime, String timeDesc, Integer timeNum,
			Set<CourseTeacher> courseTeachers) {
		this.lessonTime = lessonTime;
		this.timeDesc = timeDesc;
		this.timeNum = timeNum;
//		this.courseTeachers = courseTeachers;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "time_id", unique = true, nullable = false)
	public Integer getTimeId() {
		return this.timeId;
	}

	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lesson_time", length = 10)
	public Date getLessonTime() {
		return this.lessonTime;
	}

	public void setLessonTime(Date lessonTime) {
		this.lessonTime = lessonTime;
	}

	@Column(name = "time_desc")
	public String getTimeDesc() {
		return this.timeDesc;
	}

	public void setTimeDesc(String timeDesc) {
		this.timeDesc = timeDesc;
	}

	@Column(name = "time_num")
	public Integer getTimeNum() {
		return this.timeNum;
	}

	public void setTimeNum(Integer timeNum) {
		this.timeNum = timeNum;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "coursetime")
//	public Set<CourseTeacher> getCourseTeachers() {
//		return this.courseTeachers;
//	}
//
//	public void setCourseTeachers(Set<CourseTeacher> courseTeachers) {
//		this.courseTeachers = courseTeachers;
//	}

}