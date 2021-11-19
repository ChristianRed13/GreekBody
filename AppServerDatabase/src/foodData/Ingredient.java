package foodData;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ingredients database table.
 * 
 */
@Entity
@Table(name="ingredients")
@NamedQuery(name="Ingredient.findAll", query="SELECT i FROM Ingredient i")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ingredient")
	private int id_ingredient;

	private String name;

	//bi-directional many-to-one association to FoodIngredient
	@OneToMany(  cascade = CascadeType.ALL,
	        orphanRemoval = true,
	        mappedBy="id_ingredient")
	private List<FoodIngredient> foodIngredients;

	public Ingredient() {
	}
	public Ingredient(String name) {
		this.name = name;
	}
	public int getIdIngredient() {
		return this.id_ingredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.id_ingredient = idIngredient;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FoodIngredient> getFoodIngredients() {
		return this.foodIngredients;
	}

	public void setFoodIngredients(List<FoodIngredient> foodIngredients) {
		this.foodIngredients = foodIngredients;
	}

	public FoodIngredient addFoodIngredient(FoodIngredient foodIngredient) {
		getFoodIngredients().add(foodIngredient);
		foodIngredient.setIngredient(this);

		return foodIngredient;
	}

	public FoodIngredient removeFoodIngredient(FoodIngredient foodIngredient) {
		getFoodIngredients().remove(foodIngredient);
		foodIngredient.setIngredient(null);

		return foodIngredient;
	}
	@Override
	public String toString() {
		return  name ;
	}
	
	

}