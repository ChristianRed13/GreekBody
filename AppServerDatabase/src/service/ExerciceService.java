package service;

import java.util.List;
import java.util.Random;

import javax.persistence.Persistence;

import dao.ExerciceDao;
import workoutData.Exercise;

public class ExerciceService {
	private ExerciceDao exerciceDao;

	public ExerciceService() {
		try {
			exerciceDao = new ExerciceDao(Persistence.createEntityManagerFactory("AppServer"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addExercice(Exercise newExercice) {
		exerciceDao.create(newExercice);
	}

	public void updateExercice(Exercise updatedExercice) {
		exerciceDao.update(updatedExercice);
	}

	public List<Exercise> getAllExercices() {
		return exerciceDao.findAll();
	}


	public Exercise findExerciceByNameReps(String name, String reps) throws Exception {
		List<Exercise> exercices = exerciceDao.findName(name);
		if (exercices.size() == 0) {
			throw new Exception("Name of the exercise not found!");
		}	
		Exercise ex = null;
		for(Exercise e:exercices) {
			if(e.getSetsReps() == reps)
			ex = e;	
		}
		if (ex == null) {
			throw new Exception("Reps and Sets of this exercise" + name + " not found  not found!");
		}
      return ex;
	}
	
	public Exercise findExerciceByID(Integer id) throws Exception {
		List<Exercise> exercices = exerciceDao.findID(id);
		if (exercices.size() == 0) {
			throw new Exception("Exercise with id " + id + " not found!");
		}	

      return exercices.get(0);
	}
}
