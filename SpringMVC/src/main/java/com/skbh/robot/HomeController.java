package com.skbh.robot;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skbh.robot.model.Employee;
import com.skbh.robot.model.Items;
import com.skbh.robot.model.LoginDetails;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private String className;
	
	
	@RequestMapping(value="/admin/securedpage", method=RequestMethod.GET)
	public ModelAndView securedPage(){
		ModelAndView view=new ModelAndView("securedpage");
		return view;
	}
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	public HomeController() {
		
	}
	
	@ModelAttribute
	public void ModelAttribute(Model model){
		model.addAttribute("common", "Spring Module");
	}
	
	@RequestMapping(value="/admin/register",method=RequestMethod.GET)
	public ModelAndView register(){
		ModelAndView model=new ModelAndView("register");
		LoginDetails login=new LoginDetails();
		login.getSkills().put("Ja","Core Java");
		login.getSkills().put("S","Spring");
		login.getSkills().put("H","Hibernate");
		login.getSkills().put("R","Restful");
		login.getSkills().put("Js","Json");
		login.getSkills().put("Boo","BootStrap");
		
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("IN", "India");
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		
		model.addObject("loginDetails", login);
		model.addObject("country", country);
		model.addObject("actionUri", "/admin/registeruser");
		return model;
		
	}
		
	@RequestMapping(value="/admin/registeruser",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("loginDetails") LoginDetails loginDetails,HttpServletResponse response,@CookieValue(value = "hitCounter", defaultValue = "1") Long hitCounter){
		System.out.println("userName " + loginDetails.getName());
		System.out.println("password " + loginDetails.getPassword());
		System.out.println("Skill " + loginDetails.getSkill());
		System.out.println("gender " + loginDetails.getSex());
		
		
		ModelAndView model=new ModelAndView("success");
		model.addObject("successMessage", "Welcome User!");
		Items obj=new Items();
		obj.setId(115001);
		obj.setItemBrand("Relience Digital");
		obj.setItemName("Laptop X859");
		obj.setItemMfd(new Date());
		obj.setItemPrice(256999.00);
		obj.setItemDescription("Brand new Laptop");
		Items obj2=new Items();
		obj2.setId(118901);
		obj2.setItemBrand("Samsung Electronics");
		obj2.setItemName("Mobile Phone");
		obj2.setItemMfd(new Date());
		obj2.setItemPrice(26999.00);
		obj2.setItemDescription("Samsung S4 edge");
		
		Items obj3=new Items();
		obj3.setId(119601);
		obj3.setItemBrand("Microsoft");
		obj3.setItemName("Gadgets Phone");
		obj3.setItemMfd(new Date());
		obj3.setItemPrice(35999.00);
		obj3.setItemDescription("Microsoft E900 Sharp");
		
		List<Items> item=new ArrayList<Items>();
		item.add(obj);
		item.add(obj2);
		item.add(obj3);
		List<String> itemsIndex=new ArrayList<String>();
		itemsIndex.add("id");
		itemsIndex.add("itemBrand");
		itemsIndex.add("itemName");
		itemsIndex.add("itemPrice");
		itemsIndex.add("itemMfd");
		itemsIndex.add("itemDescription");
		
		
		model.addObject("itemsIndex",itemsIndex);
		model.addObject("items",item);
		model.addObject("loginDetails",loginDetails);
		Employee emp=new Employee();
		emp.setNameOfEmployee("sushil kumar bhaskar");
		emp.setId(1001);
		className="Controller.class";
		model.addObject("emp",emp);
		model.addObject("controller", className);
		model.addObject("date", new Date());
		hitCounter++;
		Cookie cookie = new Cookie("hitCounter", hitCounter.toString());
        response.addCookie(cookie);
		
		return model;
		
		
		
	}
	
}

