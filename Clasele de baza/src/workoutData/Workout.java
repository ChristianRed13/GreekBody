package workoutData;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*    1. int workoutId -> Id generat automat de tabela "workout" din baza de date, este PRIMARY KEY 
 *    2. String name -> vor fi 3 nume de workouturi:
 *        -pentru forta:"Power of the Greek Gods"
 *        -pentru hipertrofie musculara:"Greek God Physique"
 *        -pentru calisthenics:"Greek God Skills"
 *    3.  String program -> folosinf \n drept delimitator voi scrie workoutul in formule: exercitiu seturi x repetari urmand un \n
 *    4. int time -> timpul in care trebuie exercitile incadrate
 *    5. category -> aici sunt 3 de ales : strength, calisthenics si hypertrophy(put muscle)
 * 
 */

public class Workout {
	
	private int workoutId;
	
	
	private String name;
	
	private String program ;

	private int time;
	
	private String category;
	
	public Workout(String name, String program, int time, String category){
		
		this.name = name;
		this.program = program;
		this.time = time;
		this.setCategory(category);
	}

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

	@Override
	public String toString() {
		return name + "\nProgram:\n" + program + "\nTime:" + time + " minutes\n";
	}


	
	
	

}
