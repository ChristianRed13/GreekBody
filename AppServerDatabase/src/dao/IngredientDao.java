package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import foodData.Ingredient;

public class IngredientDao extends GenericDao<Ingredient>{

	private EntityManagerFactory factory;

	public IngredientDao(EntityManagerFactory factory) {
		super(Ingredient.class);
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

	// find if id  = Ingredient
	public List<Ingredient> find(Integer name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Ingredient> q = cb.createQuery(Ingredient.class);

		Root<Ingredient> c = q.from(Ingredient.class);
		ParameterExpression<Integer> paramName = cb.parameter(Integer.class);
		q.select(c).where(cb.equal(c.get("id_ingredient"), paramName));
		TypedQuery<Ingredient> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Ingredient> results = query.getResultList();
		return results;
	}	
	public List<Ingredient> findName(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Ingredient> q = cb.createQuery(Ingredient.class);

		Root<Ingredient> c = q.from(Ingredient.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("name"), paramName));
		TypedQuery<Ingredient> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Ingredient> results = query.getResultList();
		return results;
	}
}
