package com.chitra.kms.kh.service;

import java.util.List;

import com.chitra.kms.kh.entities.UserProfile;

public interface UserProfileService {
	
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findByid(int id);

}
