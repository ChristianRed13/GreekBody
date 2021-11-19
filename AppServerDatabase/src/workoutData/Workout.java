package workoutData;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the workout database table.
 * 
 */
@Entity
@NamedQuery(name="Workout.findAll", query="SELECT w FROM Workout w")
public class Workout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_workout")
	private int id_workout;

	@Enumerated(EnumType.STRING)
	private Category category;

	private String name;

	private int time;
	
	//bi-directional many-to-one association to ExerciseWorkout
		@OneToMany(mappedBy="id_workout")
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