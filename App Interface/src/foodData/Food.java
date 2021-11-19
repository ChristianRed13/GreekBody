package foodData;

import java.util.List;




public class Food  {


	private int id_food;

	private int calories;
	

	private CategoryFood category;

	private String name;

	private String preparation;	

	private List<FoodIngredient> foodIngredients;

	public Food() {
	}

	public Food(int calories, CategoryFood category, String name, String preparation) {
		this.calories = calories;
		this.category = category;
		this.name = name;
		this.preparation = preparation;
	}
	public int getIdFood() {
		return this.id_food;
	}

	public void setIdFood(int idFood) {
		this.id_food = idFood;
	}

	public int getCalories() {
		return this.calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public CategoryFood getCategory() {
		return this.category;
	}

	public void setCategory(CategoryFood category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreparation() {
		return this.preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public List<FoodIngredient> getFoodIngredients() {
		return this.foodIngredients;
	}

	public void setFoodIngredients(List<FoodIngredient> foodIngredients) {
		this.foodIngredients = foodIngredients;
	}

	public FoodIngredient addFoodIngredient(FoodIngredient foodIngredient) {
		getFoodIngredients().add(foodIngredient);
		foodIngredient.setFood(this);

		return foodIngredient;
	}

	public FoodIngredient removeFoodIngredient(FoodIngredient foodIngredient) {
		getFoodIngredients().remove(foodIngredient);
		foodIngredient.setFood(null);

		return foodIngredient;
	}
	@Override
	public String toString() {
		return name +"\nCalories: " + calories + "\nCategory: " + category + "\nPreparation:\n" + preparation + "\n";
	}

}