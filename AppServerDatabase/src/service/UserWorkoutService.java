package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.UserDao;
import dao.UserWorkoutDao;
import userData.GreekUser;
import userData.UserPredicate;
import userData.UserWorkout;

public class UserWorkoutService {
	
	private UserWorkoutDao userWdao;
	
	public UserWorkoutService() {
		try {
			userWdao = new UserWorkoutDao(Persistence.createEntityManagerFactory("AppServer"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public void addUserWorkout(UserWorkout newFood) {
		userWdao.create(newFood);
	}

	public void updateUserWorkout(UserWorkout updatedFood) {
		userWdao.update(updatedFood);
	}

	public List<UserWorkout> getAllUserWorkouts() {
		return userWdao.findAll();
	}
	
	public String findWorkoutWithUserID(int id_user) throws Exception {
		List<UserWorkout> users = userWdao.findUserWithId(id_user);
		ExerciseWorkoutService ews = new ExerciseWorkoutService();
	
		if (users.size() == 0) {
			throw new Exception("User id "+ id_user + "not found!");
		}
		String message = users.get(0).getIdWorkout().toString();
		message += ews.findExerciseWithThisWorkoutId(users.get(0).getIdWorkout().getIdWorkout());
 
		return message;
	}
	
	public String findUsersWithSameWorkout(int id_workout) throws Exception {
		List<UserWorkout> users = userWdao.findWorkoutWithId(id_workout);
		
		if (users.size() == 0) {
			throw new Exception("Workout with this id "+ id_workout + " of the user not found!");
		}	
		String message = "";
		for(UserWorkout uw: users)
			message += uw.getIdUser().getUsername() + " " + uw.getIdUser().getIdUser();
 
		return message;
	}
}
