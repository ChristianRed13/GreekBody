package foodData;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the foods database table.
 * 
 */
@Entity
@Table(name="foods")
@NamedQuery(name="Food.findAll", query="SELECT f FROM Food f")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_food")
	private int id_food;

	private int calories;	

	private String category;

	private String name;

	private String preparation;

	//bi-directional many-to-one association to FoodIngredient
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true,
	    mappedBy="id_food")
	private List<FoodIngredient> foodIngredients;

	public Food() {
	}

	public Food(int calories, CategoryFood category, String name, String preparation) {
		this.calories = calories;
		this.category = category.toString();
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

	public String getCategory() {
		return this.category;
	}

	public void setCategory(CategoryFood category) {
		this.category = category.toString();
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