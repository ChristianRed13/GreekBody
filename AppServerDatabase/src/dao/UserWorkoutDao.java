package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import service.UserService;
import service.WorkoutService;
import userData.GreekUser;
import userData.UserWorkout;
import workoutData.Workout;

public class UserWorkoutDao extends GenericDao<UserWorkout>{
	EntityManagerFactory factory;

	public UserWorkoutDao(EntityManagerFactory factory) {
		super(UserWorkout.class);
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
	
	public List<UserWorkout> findWorkoutWithId(Integer id_workout) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserWorkout> q = cb.createQuery(UserWorkout.class);
		WorkoutService ws = new WorkoutService();
		Root<UserWorkout> c = q.from(UserWorkout.class);
		ParameterExpression<Workout> paramName = cb.parameter(Workout.class);
		q.select(c).where(cb.equal(c.get("id_workout"), paramName));
		TypedQuery<UserWorkout> query = em.createQuery(q);
		try {
			query.setParameter(paramName, ws.findWorkoutID(id_workout));
		} catch (Exception e) {
			System.out.println("Workout with this id " + id_workout + "not found in UserFood Table");
			e.printStackTrace();
		}
		List<UserWorkout> results = query.getResultList();
		return results;
	}	
	
	
	
	public List<UserWorkout> findUserWithId(Integer id_user) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserWorkout> q = cb.createQuery(UserWorkout.class);
        UserService us = new UserService();
		Root<UserWorkout> c = q.from(UserWorkout.class);
		ParameterExpression<GreekUser> paramName = cb.parameter(GreekUser.class);
		q.select(c).where(cb.equal(c.get("id_user"), paramName));
		TypedQuery<UserWorkout> query = em.createQuery(q);
		try {
			query.setParameter(paramName, us.findGreekUserWithID(id_user));
		} catch (Exception e) {
			System.out.println("User Id " + id_user + "does not exist in UserWorkout Table!");
			e.printStackTrace();
		}

		List<UserWorkout> results = query.getResultList();
		return results;
	}	

}
