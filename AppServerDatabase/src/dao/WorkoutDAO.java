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
import workoutData.Category;
import workoutData.Workout;

public class WorkoutDAO extends GenericDao<Workout> {

	private EntityManagerFactory factory;

	public WorkoutDAO(EntityManagerFactory factory) {
		super(Workout.class);
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

	// find if name = category
	public List<Workout> find(Category name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Workout> q = cb.createQuery(Workout.class);

		Root<Workout> c = q.from(Workout.class);
		ParameterExpression<Category> paramName = cb.parameter(Category.class);
		q.select(c).where(cb.equal(c.get("category"), paramName));
		TypedQuery<Workout> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Workout> results = query.getResultList();
		return results;
	}	
	
	public List<Workout> findID(Integer id) throws Exception {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Workout> q = cb.createQuery(Workout.class);

		Root<Workout> c = q.from(Workout.class);
		ParameterExpression<Integer> paramName = cb.parameter(Integer.class);
		q.select(c).where(cb.equal(c.get("id_workout"), paramName));
		TypedQuery<Workout> query = em.createQuery(q);
		query.setParameter(paramName, id);
		List<Workout> results = query.getResultList();
		return results;
	}	
}
