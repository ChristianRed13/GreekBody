package service;

import java.util.List;
import java.util.Random;

import javax.persistence.Persistence;

import dao.WorkoutDAO;
import workoutData.Category;
import workoutData.Workout;

public class WorkoutService {
	private WorkoutDAO workoutDao;

	public WorkoutService() {
		try {
			workoutDao = new WorkoutDAO(Persistence.createEntityManagerFactory("AppServer"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addWorkout(Workout newWorkout) {
		workoutDao.create(newWorkout);
	}

	public void updateWorkout(Workout updatedWorkout) {
		workoutDao.update(updatedWorkout);
	}

	public List<Workout> getAllWorkouts() {
		return workoutDao.findAll();
	}

	/// for finding the workout in the users category
	public Workout findWorkoutCategory(Category category) throws Exception {
		List<Workout> workouts = workoutDao.find(category);
		if (workouts.size() == 0) {
			throw new Exception("No Workouts for you !");
		}
			Random rn = new Random();			
		return workouts.get(rn.nextInt(workouts.size()));
	}
	
	//find workout id 
	public Workout findWorkoutID(Integer id) throws Exception {
		List<Workout> workout = workoutDao.findID(id);
		if(workout.size() == 0 ){
			throw new Exception("ID not found :( !");
		}			
		Workout finish = workout.get(0);
		return finish;
				
	}
}
