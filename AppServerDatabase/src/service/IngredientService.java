package service;

import java.util.List;
import java.util.Random;

import javax.persistence.Persistence;


import dao.IngredientDao;
import foodData.Ingredient;


public class IngredientService {
	private IngredientDao ingredientDao;

	public IngredientService() {
		try {
			ingredientDao = new IngredientDao(Persistence.createEntityManagerFactory("AppServer"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addIngredient(Ingredient newIngredient) {
		ingredientDao.create(newIngredient);
	}

	public void updateExercice(Ingredient updatedIngredient) {
		ingredientDao.update(updatedIngredient);
	}

	public List<Ingredient> getAllIngredients() {
		return ingredientDao.findAll();
	}


	public Ingredient findIngredientById(Integer id) throws Exception {
		List<Ingredient> ingredients = ingredientDao.find(id);
		if (ingredients.size() == 0) {
			throw new Exception("Ingredient not found!");
		}	
		Ingredient in = ingredients.get(0);
		return in;
	}

	public Ingredient findIngredientByName(String name) throws Exception {
		List<Ingredient> ingredients = ingredientDao.findName(name);
		if (ingredients.size() == 0) {
			throw new Exception("Name not found!");
		}	
		Ingredient in = ingredients.get(0);
		return in;
	}
}

