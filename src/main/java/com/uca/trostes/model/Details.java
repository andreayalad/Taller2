package com.uca.trostes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DETAILS")
@Getter 
@Setter 

public class Details implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_DETAIL")
	Integer idDetail;
	@Column(name = "ID_TEACHER")
	Integer idTeacher;
	@Column(name = "GROUP")
	Integer group;
	@Column(name = "CLASSROOM")
	Integer classroom;
	@Column (name = "SIGNATURE")
	String signature;
}
