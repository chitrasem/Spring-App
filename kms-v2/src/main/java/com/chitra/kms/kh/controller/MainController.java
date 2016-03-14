package com.chitra.kms.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin/dashboard")
public class MainController {
	
	@RequestMapping(value="")
	public ModelAndView dashboard(ModelAndView m){
		m.setViewName("/dashboard/balnk");
		
		return m;
	}
	
	

}
