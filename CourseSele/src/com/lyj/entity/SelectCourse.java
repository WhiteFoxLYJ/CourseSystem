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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SelectCourse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "select_course", catalog = "zs")
public class SelectCourse implements java.io.Serializable {

	// Fields

	private Integer selectId;
	private Student student;
	private CourseTeacher courseTeacher;
	private Date selectTime;
//	private Set<StudentCourse> studentCourses = new HashSet<StudentCourse>(0);

	// Constructors

	/** default constructor */
	public SelectCourse() {
	}

	/** full constructor */
	public SelectCourse(Student student, CourseTeacher courseTeacher,
			Date selectTime, Set<StudentCourse> studentCourses) {
		this.student = student;
		this.courseTeacher = courseTeacher;
		this.selectTime = selectTime;
//		this.studentCourses = studentCourses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "select_id", unique = true, nullable = false)
	public Integer getSelectId() {
		return this.selectId;
	}

	public void setSelectId(Integer selectId) {
		this.selectId = selectId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ct_id")
	public CourseTeacher getCourseTeacher() {
		return this.courseTeacher;
	}

	public void setCourseTeacher(CourseTeacher courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "select_time", length = 10)
	public Date getSelectTime() {
		return this.selectTime;
	}

	public void setSelectTime(Date selectTime) {
		this.selectTime = selectTime;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "selectCourse")
//	public Set<StudentCourse> getStudentCourses() {
//		return this.studentCourses;
//	}
//
//	public void setStudentCourses(Set<StudentCourse> studentCourses) {
//		this.studentCourses = studentCourses;
//	}

}