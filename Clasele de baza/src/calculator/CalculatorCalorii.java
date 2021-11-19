package calculator;

/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * IN FIECARE DIETA NR DE CALORII O SA FIE IMPARTIT ASTFEL:
 * -35% BREAKFAST
 * -25% LUNCH
 * -25% DINNER
 * -15% SNACK
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * */


public class CalculatorCalorii {
private int height;
private int age;
private Gender gender ;
private double weight;
private String goals ;
private String activity ; 

public CalculatorCalorii() {
	
}


	public CalculatorCalorii(int height, int age, Gender gender, double weight, String goals, String activity) {
	super();
	this.height = height;
	this.age = age;
	this.gender = gender;
	this.weight = weight;
	this.goals = goals;
	this.activity = activity;
}





//{"Sedentary", "Sport 1-3 days/week", "Sport 3-5 days/week", "Sport 6-7 days/week"};

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





	public Gender getGender() {
		return gender;
	}





	public void setGender(Gender gender) {
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





	public int calculateCalories() {
		int MC = 0;
		if(this.getGender().equals(Gender.Female)) 
			MC = (int) (10 * this.getWeight() + 6.25 * this.getHeight() - 5 * this.getAge() + 5);
			else if(this.getGender().equals(Gender.Male))
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
		return (int) this.calculateCalories() * 35 / 100;
		}
	public int getLunchCalories() {
		return (int) this.calculateCalories() * 25 / 100 ;
		}
	public int getDinnerCalories() {
		return (int) this.calculateCalories() * 25 / 100 ;
		}
	public int getSnackCalories() {
		return (int) this.calculateCalories() * 15 / 100;
		}
	
	@Override
	public String toString() {
		return "CalculatorCalorii [height=" + height + ", age=" + age + ", gender=" + gender + ", weight=" + weight
				+ ", goals=" + goals + ", activity=" + activity + "]";
	}
	
	
}
