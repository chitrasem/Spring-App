package com.chitra.kms.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.kms.entity.Student;
import com.chitra.kms.entity.User;
import com.chitra.kms.service.StudentService;
import com.chitra.kms.service.UserService;
import com.chitra.kms.utils.SSOIdUtil;

@RestController
@RequestMapping("/dashboard")
public class ContactRestController {
	@Autowired
	StudentService studentService;
	@Autowired
	UserService userService;
	
	
	SSOIdUtil sSOIdUtil;
	
	@RequestMapping(value = { "/contactlist"}, method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public@ResponseBody Map<String, Object> findAllStudnet() {
		sSOIdUtil = new SSOIdUtil();
		
		User user = userService.findBySso(sSOIdUtil.getPrincipal());
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//List<Student> students = studentService.findAll(user.getId());
		
		map.put("MESSAGE", "TESTING");
		
		return map;
	}

}
