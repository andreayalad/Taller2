package com.uca.trostes.controller;

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
import com.uca.trostes.model.Details;
import com.uca.trostes.model.Teacher;
import com.uca.trostes.repository.detailsRepository;

@Controller 
@RequestMapping("/")
public class DetailsController {
	@Autowired
	detailsRepository detailsrepository;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("details/index.jsp");
		return mv;
	}
	@RequestMapping(value = "/gridDetails", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody JqgridResponse<Details> gridDetails(
			 @RequestParam(value = "filters", required = false) String filters,
		       @RequestParam(value = "page", required = false) Integer page,
		       @RequestParam(value = "rows", required = false) Integer rows,
		       @RequestParam(value = "sidx", required = false) String sidx,
		       @RequestParam(value = "sord", required = false) String sord 
			){
		
		Page<Details> list = detailsrepository.findByFilters(
				   PageRequest.of(page - 1, rows, Sort.by(sord.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sidx))
		            ,JqgridFilter.getFieldInteger(filters, "idDetail") 
		            ,JqgridFilter.getField(filters, "group") 
		            ,JqgridFilter.getField(filters, "classroom") 
		            ,JqgridFilter.getField(filters, "signature") 
		            ,JqgridFilter.getField(filters, "idTeacher") 
		  
				);
		 JqgridResponse<Details> jqgridDetail = new JqgridResponse<Details>();
	       return jqgridDetail.jGridFill(list, page, rows);	
		
	}
	
	@RequestMapping(value = "/addDetails", method = RequestMethod.POST)
    public @ResponseBody String addDetails(@ModelAttribute("Details") @Validated Details details ) {
         detailsrepository.save(details);
         return null;
     }
	
    @RequestMapping(value = "/deleteDetails", method = RequestMethod.DELETE)
    public @ResponseBody String delteDetails(@ModelAttribute("Details")  Details details ) {
         detailsrepository.delete(details);
         return null;
     }
    
}
