package com.chitra.kms.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chitra.kms.kh.utils.SSOIdUtil;

@Controller
@RequestMapping("admin/dashboard")
public class MainController {
	/**
	 * SSOIdUtils
	 */
	SSOIdUtil sSOIdUtil = new SSOIdUtil();
	
	@RequestMapping(value="")
	public ModelAndView dashboard(ModelAndView m){
		m.setViewName("/dashboard/balnk");
		m.addObject("user", sSOIdUtil.getUser());
		return m;
	}
	
	

}
