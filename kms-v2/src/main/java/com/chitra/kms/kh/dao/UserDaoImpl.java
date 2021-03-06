package com.chitra.kms.kh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.chitra.kms.kh.entities.User;
 

 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
 
    public User findById(int id) {
        return getByKey(id);
    }
 
    public User findByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        return (User) crit.uniqueResult();
    }

	public void save(User user) {
		 persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(Boolean areTeachers) {
		 Criteria crit = getSession().createCriteria(User.class, "u")
				 .setProjection(Projections.projectionList()
						 .add(Projections.property("u.firstName"),"firstName")
						 .add(Projections.property("id"),"id")
						 .add(Projections.property("lastName"),"lastName")								 
						 );

		 crit.createAlias("userProfiles", "profile");
		 if(areTeachers==true){
			 
			 crit.add(Restrictions.eq("profile.type", "TEACHER"));
		 }
		 crit.setResultTransformer(new AliasToBeanResultTransformer(User.class));
		
		return (List<User>) crit.list();
	}

	public void deleteUserById(int id) {

		Query query = getSession().createQuery(
				"delete from Employee where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
		
	}
 
     
}
