package workoutData;


import java.util.List;


/**
 * The persistent class for the exercise database table.
 * 
 */

public class Exercise {

	private int id_exercise;

	private String name;


	private String sets_reps;

	private List<ExerciseWorkout> exerciseWorkouts;

	public Exercise() {
	}
	public Exercise(String name, String sets_reps) {
		this.name = name;
		this.sets_reps = sets_reps;
	}


	public int getIdExercise() {
		return this.id_exercise;
	}

	public void setIdExercise(int idExercise) {
		this.id_exercise = idExercise;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSetsReps() {
		return this.sets_reps;
	}

	public void setSetsReps(String setsReps) {
		this.sets_reps = setsReps;
	}

	public List<ExerciseWorkout> getExerciseWorkouts() {
		return this.exerciseWorkouts;
	}

	public void setExerciseWorkouts(List<ExerciseWorkout> exerciseWorkouts) {
		this.exerciseWorkouts = exerciseWorkouts;
	}

	public ExerciseWorkout addExerciseWorkout(ExerciseWorkout exerciseWorkout) {
		getExerciseWorkouts().add(exerciseWorkout);
		exerciseWorkout.setExercise(this);

		return exerciseWorkout;
	}

	public ExerciseWorkout removeExerciseWorkout(ExerciseWorkout exerciseWorkout) {
		getExerciseWorkouts().remove(exerciseWorkout);
		exerciseWorkout.setExercise(null);

		return exerciseWorkout;
	}

}