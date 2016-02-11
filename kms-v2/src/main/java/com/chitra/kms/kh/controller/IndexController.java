package com.chitra.kms.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value="/")
	public ModelAndView indexController(){		
		return new ModelAndView("redirect:home");
	}
	@RequestMapping(value="/home")
	public ModelAndView homePage(){
		return new ModelAndView("/pages/welcome");
	}
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}

}
