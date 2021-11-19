package calculator;

public class CalculatorTest {

	public static void main(String[] args) {
	//	float height, float age, String gender, float weight, String goals, String activity
		
		CalculatorCalorii c1 = new CalculatorCalorii(145, 20, Gender.Male,  69, "Lose Weight", "Sedentary");
		System.out.println(c1.getDinnerCalories());

	}

}
