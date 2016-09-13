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
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacher", catalog = "zs")
public class Teacher implements java.io.Serializable {

	// Fields

	private Integer teacherId;
	private String teacherName;
	private Integer teacherPid;
	private String teacherSex;
//	private Set<CourseTeacher> courseTeachers = new HashSet<CourseTeacher>(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String teacherName, Integer teacherPid) {
		this.teacherName = teacherName;
		this.teacherPid = teacherPid;
	}

	/** full constructor */
	public Teacher(String teacherName, Integer teacherPid, String teacherSex,
			Set<CourseTeacher> courseTeachers) {
		this.teacherName = teacherName;
		this.teacherPid = teacherPid;
		this.teacherSex = teacherSex;
//		this.courseTeachers = courseTeachers;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "teacher_id", unique = true, nullable = false)
	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@Column(name = "teacher_name", nullable = false)
	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Column(name = "teacher_pid", nullable = false)
	public Integer getTeacherPid() {
		return this.teacherPid;
	}

	public void setTeacherPid(Integer teacherPid) {
		this.teacherPid = teacherPid;
	}

	@Column(name = "teacher_sex", length = 10)
	public String getTeacherSex() {
		return this.teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "teacher")
//	public Set<CourseTeacher> getCourseTeachers() {
//		return this.courseTeachers;
//	}
//
//	public void setCourseTeachers(Set<CourseTeacher> courseTeachers) {
//		this.courseTeachers = courseTeachers;
//	}

}