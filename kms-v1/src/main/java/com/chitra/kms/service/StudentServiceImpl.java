package com.chitra.kms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.kms.dao.AbstractDao;
import com.chitra.kms.dao.StudentDao;
import com.chitra.kms.entity.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{	
	@Autowired
	StudentDao studentDao;

	public List<Student> findAll(
			String firstName, 
			String lastName,
			String searchName,
			int whereUserId,
			int maxResults, 
			int firstResults) {
		return studentDao.findAll(
				firstName, 
				lastName, 
				searchName, 
				whereUserId,
				maxResults, 
				firstResults);
	}
	public void save(Student student) {	
		studentDao.save(student);
	}

	public Student findById(int id) {
		return studentDao.findById(id);
	}

	public Student findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return studentDao.findByFirstName(firstName);
	}

	public long countRecordListl(
			String firstName, 
			String lastName, 
			String searchName,
			int whereUserId) {
		
		return studentDao.countRecordListl( 
				firstName, 
				lastName, 
				searchName,
				whereUserId);
	}


}
