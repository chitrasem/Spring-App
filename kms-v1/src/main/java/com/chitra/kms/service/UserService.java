package com.chitra.kms.service;

import java.util.List;

import com.chitra.kms.entity.User;

public interface UserService {
	 
    User findById(int id);
     
    User findBySso(String sso);
    
    void save(User user);
    
    List<User> findAllUsers(Boolean areTeachers);
    
    void deleteUserById(int id);
     
}
