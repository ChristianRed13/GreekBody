package userData;


import foodData.Food;


/**
 * The persistent class for the user_food database table.
 * 
 */

public class UserFood {

	private int id_user_food;


	private Food id_food;


	private GreekUser id_user;

	public UserFood() {
	}
	
	

	public UserFood(Food id_food, GreekUser id_user) {
		this.id_food = id_food;
		this.id_user = id_user;
	}



	public int getIdUserFood() {
		return this.id_user_food;
	}

	public void setIdUserFood(int idUserFood) {
		this.id_user_food = idUserFood;
	}

	public Food getIdFood() {
		return this.id_food;
	}

	public void setIdFood(Food idFood) {
		this.id_food = idFood;
	}

	public GreekUser getGreekUser() {
		return this.id_user;
	}

	public void setGreekUser(GreekUser greekUser) {
		this.id_user = greekUser;
	}
	

}