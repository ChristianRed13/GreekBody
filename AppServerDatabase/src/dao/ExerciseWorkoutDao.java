package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import service.ExerciceService;
import service.WorkoutService;
import workoutData.Exercise;
import workoutData.ExerciseWorkout;
import workoutData.Workout;

public class ExerciseWorkoutDao extends GenericDao<ExerciseWorkout> {

	private EntityManagerFactory factory;

	public ExerciseWorkoutDao(EntityManagerFactory factory) {
		super(ExerciseWorkout.class);
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

	// find all exercises by their workout id 
	public Map<String, String> find(Integer id) throws Exception {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ExerciseWorkout> q = cb.createQuery(ExerciseWorkout.class);

		Root<ExerciseWorkout> c = q.from(ExerciseWorkout.class);
		ParameterExpression<Workout> paramW = cb.parameter(Workout.class);
		q.select(c).where(cb.equal(c.get("id_workout"), paramW));
		  WorkoutService ws = new WorkoutService();
		TypedQuery<ExerciseWorkout> query = em.createQuery(q);
		query.setParameter(paramW, ws.findWorkoutID(id));

		List<ExerciseWorkout> results = query.getResultList();
		
		
		CriteriaQuery<Exercise> qi = cb.createQuery(Exercise.class);
		Root<Exercise> ci = qi.from(Exercise.class);
		Map<String, String> finalResults = new HashMap<String, String>();

		ParameterExpression<Exercise> paramE = cb.parameter(Exercise.class);
		for(ExerciseWorkout f : results){
		qi.select(ci).where(cb.equal(ci.get("id_exercise"), paramE));
		TypedQuery<Exercise> query2 = em.createQuery(qi);
		query2.setParameter(paramE, f.getExercise());
		finalResults.put(f.getExercise().getSetsReps(), f.getExercise().getName());
		}
	
		return finalResults ;
	}	
}

