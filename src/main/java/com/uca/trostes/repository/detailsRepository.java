package com.uca.trostes.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.trostes.model.Details;
import com.uca.trostes.model.Teacher;


public interface detailsRepository  extends JpaRepository <Details,    Integer >,PagingAndSortingRepository<Details,    Integer >{

	 	/**
	    * Metodo para obtener y filtrar el query y paginar la entidad
	    * @return Lista de tipo entidad
	    * @author 00094119@uca.edu.sv
	    * @version 1.0
	    **/
	
	    @Query("SELECT x "
	            + " FROM Teacher u "
	            + "WHERE"  
	            + "  (:idTeacher is null or :idTeacher = u.idTeacher )   "
	            + " and (:teacherName is null or u.teacherName = :teacherName ) "
	            + " and (:teacherLastname is null or u.teacherLastname = :teacherLastname ) "
	            + " and (:teacherEmail is null or u.teacherEmail = :teacherEmail ) "
	            + " and (:teacherPhone is null or u.teacherPhone = :teacherPhone ) "
	           )
	    Page<Teacher> findByFilters(Pageable page  ,@Param("idTeacher")  Integer idTeacher ,@Param("teacherName")  String teacherName ,@Param("teacherLastname")  String teacherLastname ,@Param("teacherEmail")  String teacherEmail ,@Param("teacherPhone")  String teacherPhone);

	    /**
	    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
	    * @return Lista de tipo entidad
	    * @author 00094119@uca.edu.sv
	    * @version 1.0
	    **/
	    
	    @Query(value ="SELECT  u.idTeacher  ,  u.teacherName  ,  u.teacherLastname  ,  u.teacherEmail , u.teacherPhone  "
	            + " FROM Teacher u "
	            + "WHERE"  
	            + "  (:idTeacher is null or :idTeacher = u.idTeacher )"
	            +  " and (:teacherName is null or u.teacherName = :teacherName )"
	            + "  and (:teacherLastname is null or u.teacherLastname = :teacherLastname )"
	            + "	 and (:teacherEmail is null or u.teacherEmail = :teacherEmail )"
	            + "	 and (:teacherPhone is null or u.teacherPhone = :teacherPhone )" 
	            + " ORDER BY u.idTeacher ASC ",nativeQuery=true
	            )
	    
	     List<Object[]> findByFilters( @Param("idTeacher")  Integer idTeacher ,@Param("teacherName")  String teacherName ,@Param("teacherLastname")  String teacherLastname ,@Param("teacherEmail")  String teacherEmail ,@Param("teacherPhone")  String teacherPhone);
	
}