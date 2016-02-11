package com.chitra.kms.kh.dao;

import java.util.List;

import com.chitra.kms.kh.entities.User;

public interface UserDao {
	 
    User findById(int id);
     
    User findBySSO(String sso);
    
    void save(User user);
    
    List<User> findAllUsers(Boolean areTeachers);
    
    void deleteUserById(int id);
     
}