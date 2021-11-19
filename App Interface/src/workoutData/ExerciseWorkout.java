package workoutData;




/**
 * The persistent class for the exercise_workout database table.
 * 
 */

public class ExerciseWorkout {

	private int id_exercise_workout;


	private Exercise id_exercise;


	private Workout id_workout;

	public ExerciseWorkout() {
	}
	public ExerciseWorkout(Exercise id_exercise, Workout id_workout) {
		this.id_exercise = id_exercise;
		this.id_workout = id_workout;
		
		
	}
	

	public int getIdExerciseWorkout() {
		return this.id_exercise_workout;
	}

	public void setIdExerciseWorkout(int idExerciseWorkout) {
		this.id_exercise_workout = idExerciseWorkout;
	}

	public Exercise getExercise() {
		return this.id_exercise;
	}

	public void setExercise(Exercise exercise) {
		this.id_exercise = exercise;
	}

	public Workout getWorkout() {
		return this.id_workout;
	}

	public void setWorkout(Workout workout) {
		this.id_workout = workout;
	}

}