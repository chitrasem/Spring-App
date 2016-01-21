package com.chitra.kms.service;

import java.util.List;

import com.chitra.kms.entity.Student;

public interface StudentService {
	
	List<Student> findAll(int userId, 
			String firstName, 
			String lastName,
			String searchName,
			String whereUser,
			int maxResult, 
			int firstResult);
	long countRecordListl(int userId, 
			String firstName, 
			String lastName,
			String searchName,
			String whereUser);
	void save(Student student);
	Student findById(int id);
	Student findByFirstName(String firstName);

}
