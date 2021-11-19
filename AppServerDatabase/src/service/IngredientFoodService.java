package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.Persistence;

import dao.FoodDAO;
import dao.IngredientFoodDao;
import foodData.CantityPredicate;
import foodData.Food;
import foodData.FoodIngredient;
import foodData.FoodsPredicate;
import foodData.Ingredient;


public class IngredientFoodService {
	private IngredientFoodDao ingredientFoodDao;

	public IngredientFoodService() {
		try {
			ingredientFoodDao = new IngredientFoodDao(Persistence.createEntityManagerFactory("AppServer"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addIngredientFood(FoodIngredient newIF) {
		ingredientFoodDao.create(newIF);
	}

	public void updateIngredientsFood(FoodIngredient updatedIF) {
		ingredientFoodDao.update(updatedIF);
	}

	public List<FoodIngredient> getAllIF() {
		return ingredientFoodDao.findAll();
	}


	public String findIngredientsWithThisFoodId(Integer foodid) throws Exception {
		Map<String, String> ingredients = ingredientFoodDao.find(foodid);
	   	if (ingredients.size() == 0) {
			throw new Exception("Food ID not found!");
		}
	   	String message = "Ingredients:\n";
      for(Map.Entry<String, String> e : ingredients.entrySet())
    	  message +="->" + e.getKey() + " " + e.getValue() + "\n";
      return message;

	}	
}

