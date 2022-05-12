package com.uca.trostes.repository;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uca.trostes.model.Details;
import com.uca.trostes.model.Teacher;

@Repository
public interface detailsRepository extends JpaRepository<Details, Integer> {
public Details findByID(Integer idTeacher);

@Query("select u from Teacher u where u.idTeacher = :idTeacher")
public Details findById(@Param("idTeacher") String idTeacher); 

@Query("SELECT x "
        + " FROM Detail d "
        + "WHERE"  
        + "  (:idDetail is null or :idDetail = d.idDetail )   "
        + " and (:group is null or d.group = :group ) "
        + " and (:classroom is null or d.classroom = :classroom ) "
        + " and (:signature is null or d.siganture = :signature ) "
        + " and (:fkidTeacherteacher is null or :fkidTeacherteacher = u.teacher.idTeacher)"
       )
Page<Details> findByFilters(Pageable page  ,@Param("idDetail")  Integer idDetail ,@Param("group")  String group ,@Param("classroom")  String classroom ,@Param("signature")  String signature ,@Param("fkidTeacherteacher")  Integer idTeacher);


}


