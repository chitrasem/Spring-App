package com.chitra.kms.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.kms.entity.State;
import com.chitra.kms.entity.User;
import com.chitra.kms.service.UserService;

@RestController
@RequestMapping("/action/service")
public class UserRestController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/user/all")
	public Map<String, Object> getAllUser(){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<User> users = (List<User>)service.findAllUsers();
			map.put("SUCCESS", true);
			map.put("MESSAGE", users);
		}catch(Exception e){
			map.put("SUCCESS", false);
			map.put("ERROR", e.getMessage());
		}
		
		return map;
	}
	@RequestMapping(value="checkUsername", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getUserName(@RequestParam("ssoId") String userName
			){
		
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			User user = service.findBySso(userName);
			System.out.println(user);			
			if(user == null){
				map.put("Message", true);
			}else{
				map.put("Message", false);
			}
		}catch(Exception e){
			map.put("Message", false);
			map.put("error", e.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping(value="/newUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> addNew(@RequestBody() User user){
		Map<String,Object> map = new HashMap<String, Object>();
		user.setState(State.INACTIVE.getState());
		try{
			service.save(user);
			map.put("Message", "User "+user.getSsoId()+ " added successfully!");
		}catch(Exception e){
			map.put("Message", e.getMessage());
		}	
		
		return map;
	}

}
