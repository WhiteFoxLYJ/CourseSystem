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
 * Major entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "major", catalog = "zs")
public class Major implements java.io.Serializable {

	// Fields

	private Integer majorId;
	private String majorName;
	private String majorTel;
//	private Set<Classbj> classbjs = new HashSet<Classbj>(0);

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** full constructor */
	public Major(String majorName, String majorTel, Set<Classbj> classbjs) {
		this.majorName = majorName;
		this.majorTel = majorTel;
//		this.classbjs = classbjs;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "major_id", unique = true, nullable = false)
	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	@Column(name = "major_name")
	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Column(name = "major_tel")
	public String getMajorTel() {
		return this.majorTel;
	}

	public void setMajorTel(String majorTel) {
		this.majorTel = majorTel;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "major")
//	public Set<Classbj> getClassbjs() {
//		return this.classbjs;
//	}
//
//	public void setClassbjs(Set<Classbj> classbjs) {
//		this.classbjs = classbjs;
//	}

}