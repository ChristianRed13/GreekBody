package workoutData;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exercise_workout database table.
 * 
 */
@Entity
@Table(name="exercise_workout")
@NamedQuery(name="ExerciseWorkout.findAll", query="SELECT e FROM ExerciseWorkout e")
public class ExerciseWorkout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_exercise_workout")
	private int id_exercise_workout;

	//bi-directional many-to-one association to Exercise
	@ManyToOne
	@JoinColumn(name="id_exercise")
	private Exercise id_exercise;

	//bi-directional many-to-one association to Workout
	@ManyToOne
	@JoinColumn(name="id_workout")
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