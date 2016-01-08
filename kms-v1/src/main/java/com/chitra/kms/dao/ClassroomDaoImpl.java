package com.chitra.kms.dao;

import org.springframework.stereotype.Repository;

import com.chitra.kms.entity.Classroom;

@Repository("classromDao")
public class ClassroomDaoImpl extends AbstractDao<Long,  Classroom> implements ClassroomDao{

	public void save(Classroom classroom) {
		persist(classroom);		
	}

}
