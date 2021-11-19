package userData;

import java.util.List;


/**
 * The persistent class for the greek_user database table.
 * 
 */

public class GreekUser{


	private int id_user;

	private String activity;

	private int age;

	private String gender;

	private String goals;

	private int height;

	private String password;

	private String username;

	private double weight;

	private String workoutType;
	
	private List<UserFood> userFoods;

	public GreekUser() {
	}
	
	public GreekUser(String username, String password) {
		this.password = password;
		this.username = username;
	}
	
	
	

	public GreekUser(String activity, int age, Gender gender, String goals, int height, String password,
			String username, double weight, String workoutType) {
		this.activity = activity;
		this.age = age;
		this.gender = gender.toString();
		this.goals = goals;
		this.height = height;
		this.password = password;
		this.username = username;
		this.weight = weight;
		this.workoutType = workoutType;
	}




	public int getIdUser() {
		return this.id_user;
	}

	public void setIdUser(int idUser) {
		this.id_user = idUser;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = Integer.parseInt (age);
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender.toString();
	}
	
	public void setGenderString(String gender) {
		this.gender = gender;
	}

	public String getGoals() {
		return this.goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = Integer.parseInt (height);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = Double.parseDouble(weight);
	}

	public String getWorkoutType() {
		return this.workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	public List<UserFood> getUserFoods() {
		return this.userFoods;
	}

	public void setUserFoods(List<UserFood> userFoods) {
		this.userFoods = userFoods;
	}

	public UserFood addUserFood(UserFood userFood) {
		getUserFoods().add(userFood);
		userFood.setGreekUser(this);

		return userFood;
	}

	public UserFood removeUserFood(UserFood userFood) {
		getUserFoods().remove(userFood);
		userFood.setGreekUser(null);

		return userFood;
	}

	@Override
	public String toString() {
		return "GreekUser [id_user=" + id_user + ", activity=" + activity + ", age=" + age + ", gender=" + gender
				+ ", goals=" + goals + ", height=" + height + ", password=" + password + ", username=" + username
				+ ", weight=" + weight + ", workoutType=" + workoutType + "]";
	}



	

}