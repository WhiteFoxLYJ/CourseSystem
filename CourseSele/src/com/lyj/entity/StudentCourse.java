package com.lyj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StudentCourse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student_course", catalog = "zs")
public class StudentCourse implements java.io.Serializable {

	// Fields

	private Integer scId;
	private Student student;
	private SelectCourse selectCourse;

	// Constructors

	/** default constructor */
	public StudentCourse() {
	}

	/** full constructor */
	public StudentCourse(Student student, SelectCourse selectCourse) {
		this.student = student;
		this.selectCourse = selectCourse;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sc_id", unique = true, nullable = false)
	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
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
	@JoinColumn(name = "slc_id")
	public SelectCourse getSelectCourse() {
		return this.selectCourse;
	}

	public void setSelectCourse(SelectCourse selectCourse) {
		this.selectCourse = selectCourse;
	}

}