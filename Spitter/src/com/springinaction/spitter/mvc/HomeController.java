package com.springinaction.spitter.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springinaction.spitter.services.SpitterService;

@Controller("homeController")
@ManagedResource(objectName="spitter:name=HomeController")
public class HomeController {
	public static final int DEFAULT_SPITTLES_PER_PAGE = 5;

	private SpitterService spitterService;
	
	private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;

	@Autowired
	public HomeController(SpitterService spitterService) {
		this.spitterService = spitterService;
	}
	
	@RequestMapping({"/", "/home"})
	public String showHomePage(Map<String, Object> model) {
		model.put("spittles", spitterService.getRecentSpittles(getSpittlesPerPage()));
		return "home";
	}
	
	@ManagedAttribute
	public int getSpittlesPerPage() {
		return spittlesPerPage;
	}
	
	@ManagedAttribute
	public void setSpittlesPerPage(int spittlesPerPage) {
		this.spittlesPerPage = spittlesPerPage;
	}
	
	
	
}
