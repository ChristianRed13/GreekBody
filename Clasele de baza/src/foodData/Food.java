package foodData;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

/*Parametri:
 *   1. int foodId -> o sa fie salvat de catre tabelul din baza de date pe numele "food", este PRIMARY KEY
 *   3. String foodName -> numele retetei
 *   2. String -> o sa fie o variabila care salveaza ingredientele drept String cu \n-uri
 *   3. String preparation -> un mesaj care afiseaza modul de preparare al acestui fel de mancare
 *   4. float calories -> numarul total de calorii pentru acest fel de mancare
 *   5. String category -> breakfast, lunch, dinner si snack 
 * 
 * 
 * 
 */

public class Food {
	private int foodId;
	private String foodName;
	private String ingredients ;
	private String preparation;
	private float calories;
	private String category;
	
	public Food(String foodName, String ingredients, String preparation, float calories, String category) {
		this.ingredients = ingredients;
		this.calories = calories;
		this.preparation = preparation;
		this.foodName = foodName;
		this.setCategory(category);

	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients( String ingredients) {
		this.ingredients = ingredients;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public float getCalories() {
		return calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return foodName + "\nIngredients:\n" + ingredients + "\nPreparation:\n" + preparation + "\nCalories: " + calories
				+ "\n";
	}

}
