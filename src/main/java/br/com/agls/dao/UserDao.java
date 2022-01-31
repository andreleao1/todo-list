package br.com.agls.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.agls.entity.User;

@Stateless
public class UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(User user) {
		this.entityManager.persist(user);
	}
	
	public void update(User user) {
		this.entityManager.merge(user);
	}
	
	public void remove(User user) {
		this.entityManager.remove(user);
	}
	
	public User findById(Long userId) {
		return this.entityManager.find(User.class, userId);
	}
	
	public List<User> list() {
		return this.entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
	}
	
	public boolean existsByEmail(String email) {
		try {
			String query = 
					"SELECT CASE WHEN "
					+ "email IS NOT NULL "
					+ "THEN TRUE ELSE FALSE "
					+ "END FROM todolistdb.user WHERE email = '" + email + "'";
			Object result = this.entityManager.createNativeQuery(query).getSingleResult();
			return treatResult(result);
		}catch(NoResultException e) {
			return true;
		}
	}
	
	private boolean treatResult(Object result) {
		if(result instanceof BigInteger) {
			result = Integer.parseInt(result.toString());
			return result.equals(1) ? false:true;
		}
		return false;
	}
	
	public void delete(User user) {
		this.entityManager.remove(user);
	}

}
