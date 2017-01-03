package com.skbh.robot.model;

import java.util.LinkedHashMap;
import java.util.Map;


public class LoginDetails {
	
	private String name;
	private String password;
	private String sex;
	private String skill;
	private String countryName;
	private Map<String,String> skills=new LinkedHashMap<String,String>();
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, String> getSkills() {
		return skills;
	}
	public void setSkills(Map<String, String> skills) {
		this.skills = skills;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
	
	

}
