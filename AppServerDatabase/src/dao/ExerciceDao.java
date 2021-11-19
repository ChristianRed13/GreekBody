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
import workoutData.Exercise;

public class ExerciceDao extends GenericDao<Exercise>{

	private EntityManagerFactory factory;

	public ExerciceDao(EntityManagerFactory factory) {
		super(Exercise.class);
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

	// find by category 
	public List<Exercise> findName(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Exercise> q = cb.createQuery(Exercise.class);

		Root<Exercise> c = q.from(Exercise.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("name"), paramName));
		TypedQuery<Exercise> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Exercise> results = query.getResultList();
		return results;
	}
	
	public List<Exercise> findID(Integer id) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Exercise> q = cb.createQuery(Exercise.class);

		Root<Exercise> c = q.from(Exercise.class);
		ParameterExpression<Integer> paramName = cb.parameter(Integer.class);
		q.select(c).where(cb.equal(c.get("id_exercise"), paramName));
		TypedQuery<Exercise> query = em.createQuery(q);
		query.setParameter(paramName, id);

		List<Exercise> results = query.getResultList();
		return results;
	}
	
}
