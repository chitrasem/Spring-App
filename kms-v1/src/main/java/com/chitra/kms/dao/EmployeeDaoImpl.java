package com.chitra.kms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.chitra.kms.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao{

	public Employee findById(int id) {
		return getByKey(id);
	}

	public void saveEmployee(Employee employee) {
		
		persist(employee);
		
	}

	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createQuery(
				"delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		
		Criteria crit = createEntityCriteria();
		return (List<Employee>) crit.list();
	}

	public Employee findEmployeeBySsn(String ssn) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssn", ssn));
		
		return (Employee) crit.uniqueResult();
	}

}
