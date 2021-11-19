package foodData;

import service.FoodService;
import service.IngredientService;
import service.IngredientFoodService;

import java.util.ArrayList;
import java.util.List;

import foodData.Food;
public class FoodAdder {

	public static void main(String[] args) throws Exception {
		FoodService fs = new FoodService();
		IngredientService is = new IngredientService();
		IngredientFoodService ifs = new IngredientFoodService();
/*			
		//create ingredient
		Ingredient ingredient1 = new Ingredient("Oats");
		Ingredient ingredient2 = new Ingredient("Skimmed-Milk");
		//add ingredient in database
		is.addIngredient(ingredient1);
		is.addIngredient(ingredient2);
		
		//create food
			Food food = new Food( 420, CategoryFood.BREAKFAST,  "Protein Oatmeal Vanilla", "put oats in bowl and pur milk and mix :) ");
		//add food in database
	      fs.addFood(food);
	
*/	
//	      ifs.addIngredientFood(new FoodIngredient(fs.findFoodWithName("Protein Oatmeal"), is.findIngredientByName("Oats"), "100 g"));
//	      ifs.addIngredientFood(new FoodIngredient(fs.findFoodWithName("Protein Oatmeal"), is.findIngredientByName("Skimmed-Milk"), "200 g"));
	      

       //output : ingredients
//		Food f = fs.findFoodCaloriesCategory(500,"lunch");
//		ifs.findIngredientsWithThisFoodId(f.getIdFood());
	   //output : all food information 
//		System.out.println(f.toString());


ifs.findIngredientsWithThisFoodId(fs.findFoodCaloriesCategory(480, CategoryFood.BREAKFAST).getIdFood());
	       
  }
}