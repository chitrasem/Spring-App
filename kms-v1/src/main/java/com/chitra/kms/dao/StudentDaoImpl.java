package com.chitra.kms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.chitra.kms.entity.State;
import com.chitra.kms.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao{

	@SuppressWarnings("unchecked")
	public List<Student> findAll( 
			String firstName, 
			String lastName, 
			String searchName, 		
			int whereUserId,
			int maxResults, 
			int firstResult) {
		String status = "Inactive";
		
		Criteria crit = getSession().
				createCriteria(Student.class, "student");				
				crit.setProjection(Projections.projectionList().
						add(Projections.property("student.id"),"id").
						add(Projections.property(lastName),"lastName").
						add(Projections.property(firstName), "firstName").
						add(Projections.property("student.dateOfBirth"), "dateOfBirth").
						add(Projections.property("student.phoneNumber"), "phoneNumber").
						add(Projections.property("student.gender"), "gender"));
		Criterion cFirstName = Restrictions.like(firstName, searchName);
		Criterion cLastName = Restrictions.like(lastName, searchName);
		LogicalExpression orExp = Restrictions.or(cFirstName, cLastName);
				crit.add(orExp);
				if(status == State.INACTIVE.getState()){
					crit.add(Restrictions.eq("student.state", State.INACTIVE.getState()));
					crit.addOrder(Order.desc("student.id"));
					
				}else if(status==State.ACTIVE.getState()){ 
					if(whereUserId > 0){
						crit.add(Restrictions.eq("student.user.id", whereUserId));
						crit.add(Restrictions.eq("student.state",State.ACTIVE.getState()));
					}
					crit.addOrder(Order.asc(lastName));
					
				}
				
				
				crit.setMaxResults(maxResults);
				crit.setFirstResult(firstResult);				
				//Convert to Student list
				crit.setResultTransformer(new AliasToBeanResultTransformer(Student.class));			
		return (List<Student>)crit.list();		
	}

	public void save(Student student) {
		persist(student);
		
	}

	public Student findById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		
		return (Student) crit.uniqueResult();
	}

	public Student findByFirstName(String firstName) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("firstName", firstName));
        return (Student) crit.uniqueResult();
	}
	
	/**
	 * 
	 */
	public long countRecordListl(
			String firstName, 
			String lastName, 
			String searchName,
			int whereUserId) {
		
		Criteria query = getSession().
				createCriteria(Student.class, "student");
				query.setProjection(Projections.projectionList().
				add(Projections.rowCount()));				
				
		Criterion cFirstName = Restrictions.like(firstName, searchName);
		Criterion cLastName = Restrictions.like(lastName, searchName);
		LogicalExpression orExp = Restrictions.or(cFirstName, cLastName);
				query.add(orExp);			

				if(whereUserId > 0){
					query.add(Restrictions.eq("student.user.id", whereUserId));						
				}
				//query.add(Restrictions.eq("student.user.id", userId));
				
		return (Long) query.uniqueResult();
	}

}
