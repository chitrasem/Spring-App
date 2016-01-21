package com.chitra.kms.dao;

import java.util.List;

import com.chitra.kms.entity.Student;

public interface StudentDao {
	// Find only specific teacher
	List<Student> findAll(
			String firstName, 
			String lastName,
			String searchName, 
			int whereUserId, 
			int maxResult, 
			int firstResult);
	long countRecordListl( 
			String firstName, 
			String lastName, 
			String searchName,
			int whereUserId);
	
	void save(Student student);
	Student findById(int id);
	Student findByFirstName(String firstName);

}
