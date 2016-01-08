package com.chitra.kms.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.kms.entity.Classroom;
import com.chitra.kms.service.ClassroomService;
import com.chitra.kms.utils.SSOIdUtil;

@RequestMapping("/dashboard")
@RestController
public class ClassroomRestController {
	
	
	@Autowired
	private ClassroomService classroomService;
	
	private SSOIdUtil ssoIdUtil;
	
	@RequestMapping(value="/classroom/save", method = RequestMethod.POST)
	public Map<String, Object> saveClassroom(){
		Map<String, Object> map = new HashMap<String, Object>();
		Classroom classroom = new Classroom();
		try{
			classroomService.save(classroom);
		}catch(Exception e){
			
		}
		
		return map;
	}

}
