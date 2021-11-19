package userData;

import com.google.gson.Gson;

import foodData.CategoryFood;
import foodData.Food;
import foodData.FoodIngredient;
import foodData.Ingredient;
import service.FoodService;
import service.IngredientFoodService;
import service.IngredientService;
import service.UserFoodService;
import service.UserService;

public class UserTestAdder {
	
	public static void main(String[] args) throws Exception {
		UserFoodService ufs = new UserFoodService();
		FoodService fs = new FoodService();
		IngredientService is = new IngredientService();
		IngredientFoodService ifs = new IngredientFoodService();
		UserService us = new UserService();
		CalculatorCalorii c = new CalculatorCalorii();
//		us.addUser(new GreekUser("Sedentary", 30, Gender.Male, "Lose Weight", 170, "Hatz1313",
//				"CHRBOSS", 86.2, "Calisthenics"));
		GreekUser user = new GreekUser("Sedentary", 30, Gender.Male, "Lose Weight", 170, "Hatz1313",
				"CHRBOSS", 86.2, "Calisthenics");
		c.setCaloriesFromUserData(user);
		System.out.println(c.calculateCalories());
		System.out.println(c.getBreakfastCalories());
		System.out.println(c.getLunchCalories());
		System.out.println(c.getDinnerCalories());
		System.out.println(c.getSnackCalories());
		
	
	//	fs.addFood(new Food(400, CategoryFood.DINNER, "Chicken with broccoli", "Mix chick and cocoa and protein powder well"));
	//	is.addIngredient(new Ingredient("Chicken breast(raw)"));
	//	is.addIngredient(new Ingredient("Broccoli"));
//		ifs.addIngredientFood(new FoodIngredient(fs.findFoodWithName("Chicken with broccoli"), is.findIngredientByName("Chicken breast(raw)"), "200 g"));
//		ifs.addIngredientFood(new FoodIngredient(fs.findFoodWithName("Chicken with broccoli"), is.findIngredientByName("Broccoli"), "300 g"));
//		ifs.addIngredientFood(new FoodIngredient(fs.findFoodWithName("Oats"), is.findIngredientByName("Whey Protein"), "1 scoop"));
		
//     	ufs.addUserFood(new UserFood(fs.findFoodWithName("Chicken with broccoli"),us.findUserWithNamePassword("CHRBOSS", "Hatz1313")));
//		System.out.println(us.findUserWithNamePassword("CHRBOSS", "Hatz1313@").getIdUser());
		
//		System.out.println(fs.findFoodCaloriesCategory(c.getBreakfastCalories(),CategoryFood.DINNER));
//		System.out.println(ufs.findFoodDinnerByUserId(us.findUserWithNamePassword(user.getUsername(),user.getPassword()).getIdUser()));
		GreekUser userInput = new GreekUser();
		userInput.setPassword("Hatz1313");
		userInput.setUsername("CHRBOSS1");;
		System.out.print(userInput.toString());
		GreekUser gu = new GreekUser();
		String finalUser = "";
		try {
			gu = us.findUserWithNamePassword(userInput.getUsername(), userInput.getPassword());							
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(gu == null)
		System.out.println(gu);
		else
			System.out.println("gg");
		
//		String message = ufs.findFoodDinnerByUserId(us.findUserWithNamePassword("CHRBOSS", "Hatz1313").getIdUser());
//       System.out.println(message);
	}

}
