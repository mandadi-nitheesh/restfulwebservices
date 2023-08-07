package com.nitheesh.restfulwebservices.Filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterbeanService {

   public  static List<FilterBean> filterBeans=new ArrayList<>();
   
   @GetMapping("/filter")
   public MappingJacksonValue getfilterbean() {
	   
	   FilterBean filterBean=new FilterBean("nitheesh", "vazeem","naveen");	 
	   
	   MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(filterBean);
	   
       SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field-1","field3");
		   
	   FilterProvider filters =new SimpleFilterProvider().addFilter("filter",filter);
	   
	    mappingJacksonValue.setFilters(filters );
	    
	    return mappingJacksonValue;
	   
   }
   
   
   
   @GetMapping("/filters")
   public List<FilterBean> getfilterbeans() {
	   
	   return filterBeans;
   }
   
   
   	
   @PostMapping("/postfilter")
   public List<FilterBean> postFilterBeans(@RequestBody FilterBean filterBean){
	   
	   filterBeans.add(filterBean);
	   
	   return filterBeans;
   }
   
   
	
}
