package com.chitra.kms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitra.kms.dao.ClassroomDao;
import com.chitra.kms.entity.Classroom;

@Service("classroomService")
@Transactional
public class ClassroomServiceImpl implements ClassroomService{
	
	@Autowired
	private ClassroomDao classroomDao;

	public void save(Classroom classroom) {
		classroomDao.save(classroom);
		
	}

}
