package com.skbh.robot;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


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
}
