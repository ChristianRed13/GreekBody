package userData;


import workoutData.Workout;


/**
 * The persistent class for the user_workout database table.
 * 
 */

public class UserWorkout  {
	
	private int id_user_workout;


	private GreekUser id_user;
	
	private Workout id_workout;

	public UserWorkout() {
	}
	
	public UserWorkout(GreekUser id_user, Workout id_workout ) {
		this.id_user = id_user;
		this.id_workout = id_workout;		
	}

	public int getIdUserWorkout() {
		return this.id_user_workout;
	}

	public void setIdUserWorkout(int idUserWorkout) {
		this.id_user_workout = idUserWorkout;
	}

	public GreekUser getIdUser() {
		return this.id_user;
	}

	public void setIdUser(GreekUser idUser) {
		this.id_user = idUser;
	}

	public Workout getIdWorkout() {
		return this.id_workout;
	}

	public void setIdWorkout(Workout idWorkout) {
		this.id_workout = idWorkout;
	}

}