package calculator;

/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * IN FIECARE DIETA NR DE CALORII O SA FIE IMPARTIT ASTFEL:
 * -35% BREAKFAST
 * -25% LUNCH
 * -25% DINNER
 * -15% SNACK
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * */


public class CalculatorCalorii2 {
private int height;
private int age;
private String gender ;
private double weight;
private String goals ;
private String activity ; 

public CalculatorCalorii2() {
	
}

	public CalculatorCalorii2(int height, int age, Gender gender, double weight, String goals, String activity) {
	super();
	this.height = height;
	this.age = age;
	this.gender = gender.toString();
	this.weight = weight;
	this.goals = goals;
	this.activity = activity;
}

	public double getHeight() {
	return height;
}



public void setHeight(String height) {
		this.height = Integer.parseInt (height);
	}


public int getAge() {
	return age;
}



public void setAge(String age) {
	this.age = Integer.parseInt (age);
}



public String getGender() {
	return gender;
}



public void setGender(Gender gender) {
	this.gender = gender.toString();
}



public double getWeight() {
	return weight;
}



public void setWeight(String weight) {
	this.weight = Double.parseDouble(weight);
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



//{"Sedentary", "Sport 1-3 days/week", "Sport 3-5 days/week", "Sport 6-7 days/week"};

	public int calculateCalories() {
		int MC = 0;
		if(this.getGender() == Gender.Female.toString()) 
			      MC = (int) (10 * this.getWeight() + 6.25 * this.getHeight() - 5 * this.getAge() + 5);
			else if(this.getGender() == Gender.Male.toString())
			      MC =  (int) (10 * this.getWeight() + 6.25 * this.getHeight() - 5 * this.getAge() - 150);
		
		
		switch(this.getActivity()) {
		case "Sedentary":
			MC =  (int)(MC * 1.2);
			break;
		case "Sport 1-3 days/week":
			MC =  (int)(MC * 1.35);
			break;
		case "Sport 3-5 days/week":
			MC =  (int)(MC * 1.5);
			break;
		case "Sport 6-7 days/week":
			MC =  (int)(MC * 1.7);
			break;
		}
		
		switch(this.getGoals()) {
		case "Put Muscle":
			MC =  (int)(MC + 0.15 * MC);
			break;
		case "Lose Weight":
			MC =  (int)(MC - 0.15 * MC);
			break;
		
		}
		
		return MC;
	}
	public int getBreakfastCalories() {
		return (int)(35 / 100) * this.calculateCalories();
		}
	public int getLunchCalories() {
		return (int)(25 / 100) * this.calculateCalories();
		}
	public int getDinnerCalories() {
		return (int)(25 / 100) * this.calculateCalories();
		}
	public int getSnackCalories() {
		return (int)(15 / 100) * this.calculateCalories();
		}
	
	
}
