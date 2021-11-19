package userData;

import java.io.Serializable;
import javax.persistence.*;

import workoutData.Workout;


/**
 * The persistent class for the user_workout database table.
 * 
 */
@Entity
@Table(name="user_workout")
@NamedQuery(name="UserWorkout.findAll", query="SELECT u FROM UserWorkout u")
public class UserWorkout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user_workout")
	private int id_user_workout;

	//bi-directional many-to-one association to GreekUser
	@ManyToOne
	@JoinColumn(name="id_user")
	private GreekUser id_user;
	
	//bi-directional many-to-one association to GreekUser
	@ManyToOne
	@JoinColumn(name="id_workout")
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