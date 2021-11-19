package service;

import java.util.List;
import foodData.FoodsPredicate;
import java.util.Random;

import javax.persistence.Persistence;

import dao.FoodDAO;
import foodData.CategoryFood;
import foodData.Food;

public class FoodService {
	private FoodDAO foodDao;

	public FoodService() {
		try {
			foodDao = new FoodDAO(Persistence.createEntityManagerFactory("AppServer"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addFood(Food newFood) {
		foodDao.create(newFood);
	}

	public void updateFood(Food updatedFood) {
		foodDao.update(updatedFood);
	}

	public List<Food> getAllFoods() {
		return foodDao.findAll();
	}

	/// for login
	public Food findFoodCaloriesCategory(int calories, CategoryFood category) throws Exception {
		List<Food> foods = foodDao.find(category);
		if (foods.size() == 0) {
			throw new Exception("Category not found!");
		}
		foods.removeIf(FoodsPredicate.isInCalorieRange(calories));
	//	List<Food> newFoodsfoods.stream().filter(FoodsPredicate.isInCalorieRange(calories));
		if (foods.size() == 0) {
			throw new Exception("Not in calorie range!");
		}				
	    Random randomNumber = new Random();    
		return foods.get(randomNumber.nextInt(foods.size()));
	}
	
	public Food findFoodWithID(int ID) throws Exception {
		List<Food> foods = foodDao.findID(ID);
	
		if (foods.size() == 0) {
			throw new Exception("ID not found!");
		}	
		if (foods.size() > 1) {
			throw new Exception("ID is not unique, database error!");
		}	
		Food food = foods.get(0);
  
		return food;
	}
	public Food findFoodWithName(String name) throws Exception {
		List<Food> foods = foodDao.findName(name);
	
		if (foods.size() == 0) {
			throw new Exception("ID not found!");
		}	
		if (foods.size() > 1) {
			throw new Exception("Name is not unique, database error!");
		}	
		Food food = foods.get(0);
  
		return food;
	}
}
