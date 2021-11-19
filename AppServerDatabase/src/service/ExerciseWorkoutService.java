package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Persistence;

import dao.ExerciseWorkoutDao;
import workoutData.ExerciseWorkout;

public class ExerciseWorkoutService {
	private ExerciseWorkoutDao exerciseWorkoutDao;

	public ExerciseWorkoutService() {
		try {
			exerciseWorkoutDao = new ExerciseWorkoutDao(Persistence.createEntityManagerFactory("AppServer"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addExerciseWorkout(ExerciseWorkout newIF) {
		exerciseWorkoutDao.create(newIF);
	}

	public void updateExerciseWorkout(ExerciseWorkout updatedIF) {
		exerciseWorkoutDao.update(updatedIF);
	}

	public List<ExerciseWorkout> getAllExerciseWorkouts() {
		return exerciseWorkoutDao.findAll();
	}


	public String findExerciseWithThisWorkoutId(Integer workoutid) throws Exception {
		Map<String, String> ex = exerciseWorkoutDao.find(workoutid);
	   	if (ex.size() == 0) {
			throw new Exception("Exercise ID not found!");
		}
	   	String message = "Exercises:\n";
	   	for (Map.Entry<String,String> entry : ex.entrySet())
          message += "->" + entry.getKey() + " " + entry.getValue() + "\n";
    	 
    	  return message;
		
	}
}

