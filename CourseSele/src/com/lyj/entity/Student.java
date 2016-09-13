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
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "zs")
public class Student implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private Classbj classbj;
	private String studentName;
	private Integer studentPid;
	private String studentSex;
	private String studentPassword;
//	private Set<StudentCourse> studentCourses = new HashSet<StudentCourse>(0);
//	private Set<SelectCourse> selectCourses = new HashSet<SelectCourse>(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(Classbj classbj, String studentName, Integer studentPid,
			String studentSex, String studentPassword,
			Set<StudentCourse> studentCourses, Set<SelectCourse> selectCourses) {
		this.classbj = classbj;
		this.studentName = studentName;
		this.studentPid = studentPid;
		this.studentSex = studentSex;
		this.studentPassword = studentPassword;
//		this.studentCourses = studentCourses;
//		this.selectCourses = selectCourses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "student_id", unique = true, nullable = false)
	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "class_id")
	public Classbj getClassbj() {
		return this.classbj;
	}

	public void setClassbj(Classbj classbj) {
		this.classbj = classbj;
	}

	@Column(name = "student_name")
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "student_pid")
	public Integer getStudentPid() {
		return this.studentPid;
	}

	public void setStudentPid(Integer studentPid) {
		this.studentPid = studentPid;
	}

	@Column(name = "student_sex", length = 10)
	public String getStudentSex() {
		return this.studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	@Column(name = "student_password", length = 20)
	public String getStudentPassword() {
		return this.studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
//	public Set<StudentCourse> getStudentCourses() {
//		return this.studentCourses;
//	}
//
//	public void setStudentCourses(Set<StudentCourse> studentCourses) {
//		this.studentCourses = studentCourses;
//	}
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
//	public Set<SelectCourse> getSelectCourses() {
//		return this.selectCourses;
//	}
//
//	public void setSelectCourses(Set<SelectCourse> selectCourses) {
//		this.selectCourses = selectCourses;
//	}

}