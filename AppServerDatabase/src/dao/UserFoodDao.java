package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import foodData.Food;
import service.FoodService;
import service.UserService;
import userData.GreekUser;
import userData.UserFood;

public class UserFoodDao extends GenericDao<UserFood>{
	EntityManagerFactory factory;

	public UserFoodDao(EntityManagerFactory factory) {
		super(UserFood.class);
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
	
	public List<UserFood> findUserWithId(Integer user_id) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserFood> q = cb.createQuery(UserFood.class);


		Root<UserFood> c = q.from(UserFood.class);
		ParameterExpression<GreekUser> paramName = cb.parameter(GreekUser.class);
		q.select(c).where(cb.equal(c.get("id_user"), paramName));
		TypedQuery<UserFood> query = em.createQuery(q);
		UserService us = new UserService();
	
		try {
			query.setParameter(paramName, us.findGreekUserWithID(user_id));
		} catch (Exception e) {
			System.out.println("Food ID not found in UserFood Table");
			e.printStackTrace();
		}

		List<UserFood> results = query.getResultList();
		return results;
	}	
	
	public List<UserFood> findFoodWithId(Integer food_id) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserFood> q = cb.createQuery(UserFood.class);
		FoodService fs = new FoodService();

		Root<UserFood> c = q.from(UserFood.class);
		ParameterExpression<Food> paramName = cb.parameter(Food.class);
		q.select(c).where(cb.equal(c.get("id_food"), paramName));
		TypedQuery<UserFood> query = em.createQuery(q);
		try {
			query.setParameter(paramName, fs.findFoodWithID(food_id));
		} catch (Exception e) {
			System.out.println("Food ID not found in UserFood Table");
			e.printStackTrace();
		}

		List<UserFood> results = query.getResultList();
		return results;
	}
}
