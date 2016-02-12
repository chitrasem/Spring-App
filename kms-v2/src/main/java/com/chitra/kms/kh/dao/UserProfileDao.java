package com.chitra.kms.kh.dao;

import java.util.List;

import com.chitra.kms.kh.entities.UserProfile;

public interface UserProfileDao {
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
	

}
