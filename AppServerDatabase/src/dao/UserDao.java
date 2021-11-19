package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import userData.GreekUser;

public class UserDao extends GenericDao<GreekUser>{
	
	EntityManagerFactory factory;

	public UserDao(EntityManagerFactory factory) {
		super(GreekUser.class);
		this.factory = factory;
	}

	@Override
	public EntityManager getEntityManager() {
		try {
			return factory.createEntityManager();
		} catch (Exception ex) {
			System.out.println("The entity manager cannot be created!");
			return null;
		}
	  
	}
	
	public List<GreekUser> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<GreekUser> q = cb.createQuery(GreekUser.class);

		Root<GreekUser> c = q.from(GreekUser.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("username"), paramName));
		TypedQuery<GreekUser> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<GreekUser> results = query.getResultList();
		return results;
	}	
	
	public List<GreekUser> findID(Integer id) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<GreekUser> q = cb.createQuery(GreekUser.class);

		Root<GreekUser> c = q.from(GreekUser.class);
		ParameterExpression<Integer> paramName = cb.parameter(Integer.class);
		q.select(c).where(cb.equal(c.get("id_user"), paramName));
		TypedQuery<GreekUser> query = em.createQuery(q);
		query.setParameter(paramName, id);

		List<GreekUser> results = query.getResultList();
		return results;
	}	

}



