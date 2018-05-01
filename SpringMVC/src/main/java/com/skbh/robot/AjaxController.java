package com.skbh.robot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.skbh.robot.model.EmpList;
import com.skbh.robot.model.Employee;


@Controller
public class AjaxController {
	
	@RequestMapping(value="/ajax",method=RequestMethod.GET)
	public ModelAndView ajaxCall(){
		ModelAndView modelAndView=new ModelAndView("ajaxcall");
		return modelAndView;
	}
	
	@RequestMapping(value="/call",method=RequestMethod.GET)
	@ResponseBody
	public String ajaxResponse(){
		return new Date().toString();
	}

	@RequestMapping(value="/getname/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String ajaxResponseParam(@PathVariable("name") String name){
		return "Hello " + name;
	}
	
	@RequestMapping(value="/json/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String ajaxResponseJson(@PathVariable("name") String name){
		Employee emp=new Employee();
		emp.setId(10);
		emp.setNameOfEmployee(name);
		List<Employee> ee=new ArrayList<Employee>();
		EmpList empList=new EmpList();
		Employee emp1=new Employee();
		emp1.setId(11);
		emp1.setNameOfEmployee("ram");
		ee.add(emp1);
		ee.add(emp);
		empList.setEe(ee);
		System.out.println(new Gson().toJson(ee).toString());
		 Date d = new Date(0);
		 System.out.println(d);
		return new Gson().toJson(ee).toString();
		
	}
	
}
