package com.uca.trostes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TEACHER")
@Getter 
@Setter 

public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_TEACHER")
	Integer idTeacher;
	@Column(name = "NAME")
	String teacherName;
	@Column(name = "LASTNAME")
	String teacherLastname;
	@Column(name = "EMAIL")
	String teacherEmail;
	@Column (name = "PHONE")
	String teacherPhone;
}