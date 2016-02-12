package com.chitra.kms.kh.dao;

import java.util.List;

import com.chitra.kms.kh.entities.User;

public interface UserDao {
	 
    User findById(int id);
     
    User findByUsername(String username);
    
    void save(User user);
    
    List<User> findAllUsers(Boolean areTeachers);
    
    void deleteUserById(int id);
     
}
