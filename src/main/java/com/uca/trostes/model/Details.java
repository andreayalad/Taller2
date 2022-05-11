package com.uca.trostes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name = "GROUP")
	Integer group;
	@Column(name = "CLASSROOM")
	Integer classroom;
	@Column (name = "SIGNATURE")
	String signature;
	 @OneToOne(fetch = FetchType.LAZY)
	    @JsonIgnore
	    @JoinColumns({@JoinColumn(name = "ID_TEACHER", referencedColumnName = "ID_TEACHER")})
	    Teacher teacher;
	 
	 /**
	    * Metodo para obtener la llave primaria del padre de la entidad
	    * @return el tipo de dato de la llave primaria
	    * @author Generador-Safi
	    * @version 1.0
	    **/
	 public    Integer getTeacherToDetails(){
	        return (this.teacher== null) ? null : this.teacher.getIdTeacher();
	    }
}