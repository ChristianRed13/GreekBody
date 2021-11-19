package workoutData;

import service.ExerciceService;
import service.ExerciseWorkoutService;
import service.UserService;
import service.UserWorkoutService;
import service.WorkoutService;
import userData.UserWorkout;

public class WorkoutAdder {

	
	
	public static void main(String[] args) throws Exception {
		UserWorkoutService uws = new UserWorkoutService();
		UserService us = new UserService();
		WorkoutService ws = new WorkoutService();
		ExerciceService es = new ExerciceService();
		ExerciseWorkoutService ews = new ExerciseWorkoutService();
		
/*		
		Exercise ex1 = new Exercise("Deadlift","4x5");
		Exercise ex2 = new Exercise("Bench press","4x6");
		Exercise ex3 = new Exercise("Squads","4x10");
		Exercise ex4 = new Exercise("Military press","4x12");
		Exercise ex5 = new Exercise("Pull ups","4xMAX");	
		Workout workout = new Workout(Category.CALISTHENICS, "Greek Gods Powers", 45);
		
		es.addExercice(ex1);es.addExercice(ex2);es.addExercice(ex3);es.addExercice(ex4);es.addExercice(ex5);
	    ws.addWorkout(workout);
				
		ExerciseWorkout ew1= new ExerciseWorkout(es.findExerciceByID(1),ws.findWorkoutID(1));
		ExerciseWorkout ew2= new ExerciseWorkout(es.findExerciceByID(2),ws.findWorkoutID(1));
		ExerciseWorkout ew3= new ExerciseWorkout(es.findExerciceByID(3),ws.findWorkoutID(1));
		ExerciseWorkout ew4= new ExerciseWorkout(es.findExerciceByID(4),ws.findWorkoutID(1));
		ExerciseWorkout ew5= new ExerciseWorkout(es.findExerciceByID(5),ws.findWorkoutID(1));
		

		ews.addExerciseWorkout(ew1);ews.addExerciseWorkout(ew2);ews.addExerciseWorkout(ew3);ews.addExerciseWorkout(ew4);ews.addExerciseWorkout(ew5);		
		uws.addUserWorkout(new UserWorkout(us.findUserWithNamePassword("CHRBOSS", "Hatz1313"),ws.findWorkoutID(1)));
		
*/	
		System.out.println(uws.findWorkoutWithUserID(us.findUserWithNamePassword("CHRBOSS", "Hatz1313").getIdUser()));
		
	}
}
