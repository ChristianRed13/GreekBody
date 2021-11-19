package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import foodData.CategoryFood;
import foodData.Food;

public class FoodDAO extends GenericDao<Food> {

	private EntityManagerFactory factory;

	public FoodDAO(EntityManagerFactory factory) {
		super(Food.class);
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

	// find if name = food
	public List<Food> find(CategoryFood name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Food> q = cb.createQuery(Food.class);

		Root<Food> c = q.from(Food.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("category"), paramName));
		TypedQuery<Food> query = em.createQuery(q);
		query.setParameter(paramName, name.toString());

		List<Food> results = query.getResultList();
		return results;
	}	
	
	public List<Food> findID(Integer id) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Food> q = cb.createQuery(Food.class);

		Root<Food> c = q.from(Food.class);
		ParameterExpression<Integer> paramName = cb.parameter(Integer.class);
		q.select(c).where(cb.equal(c.get("id_food"), paramName));
		TypedQuery<Food> query = em.createQuery(q);
		query.setParameter(paramName, id);

		List<Food> results = query.getResultList();
		return results;
	}	
	public List<Food> findName(String id) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Food> q = cb.createQuery(Food.class);

		Root<Food> c = q.from(Food.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("name"), paramName));
		TypedQuery<Food> query = em.createQuery(q);
		query.setParameter(paramName, id);

		List<Food> results = query.getResultList();
		return results;
	}	
	
}
