package com.uca.trostes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uca.trostes.model.Teacher;

@Repository
public interface teacherRepository extends JpaRepository<Teacher, Integer> {
    public Teacher findByID(String idTeacher);
    
    @Query("select u from Teacher u where u.idTeacher = :idTeacher")
    public Teacher findById(@Param("idTeacher") String idTeacher); 
    
}
