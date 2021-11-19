package UserLogin;

public class User {
private int userId;
private String username;
private String password;

private int height;
private int age;
private String gender;
private double weight;
private String goals ;
private String activity ;



public User(String username, String password, int height, int age, String gender, double weight,
		String goals, String activity) {
	this.username = username;
	this.password = password;
	this.height = height;
	this.age = age;
	this.gender = gender;
	this.weight = weight;
	this.goals = goals;
	this.activity = activity;
}


public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public String getGoals() {
	return goals;
}
public void setGoals(String goals) {
	this.goals = goals;
}
public String getActivity() {
	return activity;
}
public void setActivity(String activity) {
	this.activity = activity;
}
@Override
public String toString() {
	return "User [Username="+ username + ", password=" + password + ", height=" + height
			+ ", age=" + age + ", gender=" + gender + ", weight=" + weight + ", goals=" + goals + ", activity="
			+ activity + "]";
} 

}
