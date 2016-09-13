package com.lyj.entity;

import java.sql.Timestamp;
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
 * Eduadmin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "eduadmin", catalog = "zs")
public class Eduadmin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String address;
	private Timestamp birthday;
	private String eduadminTyoeId;
	private Timestamp inSchoolDate;
	private Integer partycalTypeId;
	private String sex;
	private String password;
//	private Set<CourseTeacher> courseTeachers = new HashSet<CourseTeacher>(0);

	// Constructors

	/** default constructor */
	public Eduadmin() {
	}

	/** full constructor */
	public Eduadmin(String name, String address, Timestamp birthday,
			String eduadminTyoeId, Timestamp inSchoolDate,
			Integer partycalTypeId, String sex, String password,
			Set<CourseTeacher> courseTeachers) {
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.eduadminTyoeId = eduadminTyoeId;
		this.inSchoolDate = inSchoolDate;
		this.partycalTypeId = partycalTypeId;
		this.sex = sex;
		this.password = password;
//		this.courseTeachers = courseTeachers;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "birthday", length = 19)
	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "eduadminTyoeId")
	public String getEduadminTyoeId() {
		return this.eduadminTyoeId;
	}

	public void setEduadminTyoeId(String eduadminTyoeId) {
		this.eduadminTyoeId = eduadminTyoeId;
	}

	@Column(name = "inSchoolDate", length = 19)
	public Timestamp getInSchoolDate() {
		return this.inSchoolDate;
	}

	public void setInSchoolDate(Timestamp inSchoolDate) {
		this.inSchoolDate = inSchoolDate;
	}

	@Column(name = "partycalTypeId")
	public Integer getPartycalTypeId() {
		return this.partycalTypeId;
	}

	public void setPartycalTypeId(Integer partycalTypeId) {
		this.partycalTypeId = partycalTypeId;
	}

	@Column(name = "sex")
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "eduadmin")
//	public Set<CourseTeacher> getCourseTeachers() {
//		return this.courseTeachers;
//	}
//
//	public void setCourseTeachers(Set<CourseTeacher> courseTeachers) {
//		this.courseTeachers = courseTeachers;
//	}

}