package workoutData;


import java.util.List;



/**
 * The persistent class for the workout database table.
 * 
 */

public class Workout  {


	private int id_workout;
	
	private Category category;

	private String name;

	private int time;
	

		private List<ExerciseWorkout> exerciseWorkouts;

	public Workout() {
	}
	public Workout(Category category, String name, int time) {
		this.category = category;
		this.name = name;
		this.time = time;
	}

	public int getIdWorkout() {
		return this.id_workout;
	}

	public void setIdWorkout(int idWorkout) {
		this.id_workout = idWorkout;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	@Override
public String toString() {
	return name +"\nCategory: " + category + "\nTime: " + time +"\n";
}
}