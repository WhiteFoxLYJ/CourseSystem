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
 * Classbj entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "classbj", catalog = "zs")
public class Classbj implements java.io.Serializable {

	// Fields

	private Integer classId;
	private Major major;
	private String className;
	private Integer classNumber;
//	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public Classbj() {
	}

	/** full constructor */
	public Classbj(Major major, String className, Integer classNumber,
			Set<Student> students) {
		this.major = major;
		this.className = className;
		this.classNumber = classNumber;
//		this.students = students;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "class_id", unique = true, nullable = false)
	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "major_id")
	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@Column(name = "class_name")
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "class_number")
	public Integer getClassNumber() {
		return this.classNumber;
	}

	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "classbj")
//	public Set<Student> getStudents() {
//		return this.students;
//	}
//
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}

}