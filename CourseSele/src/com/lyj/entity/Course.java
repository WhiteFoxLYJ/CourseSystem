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
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course", catalog = "zs")
public class Course implements java.io.Serializable {

	// Fields

	private Integer courseId;
	private Float courseCredit;
	private String courseDesc;
	private String courseName;
	private Integer coursePeriod;
	private Integer courseType;
//	private Set<CourseTeacher> courseTeachers = new HashSet<CourseTeacher>(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(Float courseCredit, String courseDesc, String courseName,
			Integer coursePeriod, Integer courseType,
			Set<CourseTeacher> courseTeachers) {
		this.courseCredit = courseCredit;
		this.courseDesc = courseDesc;
		this.courseName = courseName;
		this.coursePeriod = coursePeriod;
		this.courseType = courseType;
//		this.courseTeachers = courseTeachers;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "course_id", unique = true, nullable = false)
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(name = "course_credit", precision = 12, scale = 0)
	public Float getCourseCredit() {
		return this.courseCredit;
	}

	public void setCourseCredit(Float courseCredit) {
		this.courseCredit = courseCredit;
	}

	@Column(name = "course_desc")
	public String getCourseDesc() {
		return this.courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	@Column(name = "course_name")
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name = "course_period")
	public Integer getCoursePeriod() {
		return this.coursePeriod;
	}

	public void setCoursePeriod(Integer coursePeriod) {
		this.coursePeriod = coursePeriod;
	}

	@Column(name = "course_type")
	public Integer getCourseType() {
		return this.courseType;
	}

	public void setCourseType(Integer courseType) {
		this.courseType = courseType;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "course")
//	public Set<CourseTeacher> getCourseTeachers() {
//		return this.courseTeachers;
//	}
//
//	public void setCourseTeachers(Set<CourseTeacher> courseTeachers) {
//		this.courseTeachers = courseTeachers;
//	}

}