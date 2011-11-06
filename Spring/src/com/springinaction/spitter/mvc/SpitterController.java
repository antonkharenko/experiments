package com.springinaction.spitter.mvc;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springinaction.spitter.persistence.Spitter;
import com.springinaction.spitter.services.SpitterService;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	private final SpitterService spitterService;

	@Autowired
	public SpitterController(SpitterService spitterService) {
		this.spitterService=spitterService;
	}

	@RequestMapping(value = "/spittles", method = GET)
	public String listSpittlesForSpitter(
			@RequestParam("spitter") String username, Model model) {
		/*Spitter spitter = spitterService.getSpitter(username);
		model.addAttribute(spitter);
		model.addAttribute(spitterService.getSpittlesForSpitter(username));*/
		return"spittles/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "new")
	public String createSpitterProfile(Model model) {
		model.addAttribute(new Spitter());
		return "spitters/edit";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addSpitterFromForm(/*@Valid*/ Spitter spitter/*, 
			BindingResult bindingResult*/) {
		
		/*if(bindingResult.hasErrors()){
			return "spitters/edit";
		}
		*/
		
		//spitterService.saveSpitter(spitter);
		
		return "redirect:/spitters/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model){
		//model.addAttribute(spitterService.getSpitter(username));
		return "spitters/view";
	}
}
