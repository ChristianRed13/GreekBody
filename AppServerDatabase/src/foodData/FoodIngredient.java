package foodData;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the food_ingredient database table.
 * 
 */
@Entity
@Table(name="food_ingredient")
@NamedQuery(name="FoodIngredient.findAll", query="SELECT f FROM FoodIngredient f")
public class FoodIngredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_food_ingredient")
	private int idFoodIngredient;

	private String cantity;

	//bi-directional many-to-one association to Food
	@ManyToOne
	@JoinColumn(name="id_food")
	private Food id_food;

	//bi-directional many-to-one association to Ingredient
	@ManyToOne
	@JoinColumn(name="id_ingredient")
	private Ingredient id_ingredient;

	public FoodIngredient() {
	}
	public FoodIngredient(Food id_food, Ingredient id_ingredient, String cantity) {
		this.cantity = cantity;
		this.id_food = id_food;
		this.id_ingredient = id_ingredient;
	}
	public int getIdFoodIngredient() {
		return this.idFoodIngredient;
	}

	public void setIdFoodIngredient(int idFoodIngredient) {
		this.idFoodIngredient = idFoodIngredient;
	}

	public String getCantity() {
		return this.cantity;
	}

	public void setCantity(String cantity) {
		this.cantity = cantity;
	}

	public Food getFood() {
		return this.id_food;
	}

	public void setFood(Food food) {
		this.id_food = food;
	}

	public Ingredient getIngredient() {
		return this.id_ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.id_ingredient = ingredient;
	}

}