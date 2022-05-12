package com.uca.trostes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.trostes.jqgrid.JqgridFilter;
import com.uca.trostes.jqgrid.JqgridResponse;
import com.uca.trostes.model.Teacher;
import com.uca.trostes.repository.detailsRepository;
import com.uca.trostes.repository.teacherRepository; 


@Controller
@RequestMapping("/")

public class TeacherController {
	@Autowired
	detailsRepository detailsrepository;
	teacherRepository teacherrepository;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("teacher/index.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/gridTeacher", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody JqgridResponse<Teacher> gridTeacher(
			 @RequestParam(value = "filters", required = false) String filters,
		       @RequestParam(value = "page", required = false) Integer page,
		       @RequestParam(value = "rows", required = false) Integer rows,
		       @RequestParam(value = "sidx", required = false) String sidx,
		       @RequestParam(value = "sord", required = false) String sord 
			){
		
		Page<Teacher> list = teacherrepository.findByFilters(
				   PageRequest.of(page - 1, rows, Sort.by(sord.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sidx))
		            ,JqgridFilter.getFieldInteger(filters, "idTeacher") 
		            ,JqgridFilter.getField(filters, "nombre") 
		            ,JqgridFilter.getField(filters, "apellido") 
		            ,JqgridFilter.getField(filters, "email") 
		            ,JqgridFilter.getField(filters, "telefono") 
		  
				);
		 JqgridResponse<Teacher> jqgridTeacher = new JqgridResponse<Teacher>();
	       return jqgridTeacher.jGridFill(list, page, rows);	
		
	}
	
	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public @ResponseBody String addTeacher(@ModelAttribute("Teacher") @Validated Teacher teacher ) {
         teacherrepository.save(teacher);
         return null;
     }
	
    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.DELETE)
    public @ResponseBody String deletePerson(@ModelAttribute("Person")  Teacher teacher ) {
         teacherrepository.delete(teacher);
         return null;
     }
    
}
