package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.UserFoodDao;
import foodData.CategoryFood;
import userData.UserFood;
import userData.UserFoodPredicate;

public class UserFoodService {
//	    private FoodService fs = new FoodService(); 
	    private IngredientFoodService ifs = new IngredientFoodService();
		private UserFoodDao userFoodDao;

		public UserFoodService() {
			try {
				userFoodDao = new UserFoodDao(Persistence.createEntityManagerFactory("AppServer"));
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		public void addUserFood(UserFood newUserFood) {
			userFoodDao.create(newUserFood);
		}

		public void updateUserFood(UserFood updatedUserFood) {
			userFoodDao.update(updatedUserFood);
		}

		public List<UserFood> getAllUserFoods() {
			return userFoodDao.findAll();
		}


		public String findFoodBreakfastByUserId(Integer id) throws Exception {
			List<UserFood> userFoods = userFoodDao.findUserWithId(id);
			if (userFoods.size() == 0) {
				throw new Exception("User ID not found in UserFood Table!");
			}	
					userFoods.removeIf(UserFoodPredicate.hasNotThisCategory(CategoryFood.BREAKFAST));
			if (userFoods.size() == 0) {
				throw new Exception(" No Breakfast for this user ID" + id);
			}
			String message = "";
			message = userFoods.get(0).getIdFood().toString();
			message += ifs.findIngredientsWithThisFoodId(userFoods.get(0).getIdFood().getIdFood());
			
			return message;

		}
		
		public String findFoodLunchByUserId(Integer id) throws Exception {
			List<UserFood> userFoods = userFoodDao.findUserWithId(id);
			if (userFoods.size() == 0) {
				throw new Exception("User ID not found in UserFood Table!");
			}	
			userFoods.removeIf(UserFoodPredicate.hasNotThisCategory(CategoryFood.LUNCH));
			if (userFoods.size() == 0) {
				throw new Exception(" No Lunch for this user ID" + id);
			}	else if((userFoods.size() > 1)){
				throw new Exception(" Too many Lunch-Foods for this user ID" + id);
			}
			String message = "";
			message = userFoods.get(0).getIdFood().toString();
			message += ifs.findIngredientsWithThisFoodId(userFoods.get(0).getIdFood().getIdFood());
			
			return message;

		}
					
		
		public String findFoodDinnerByUserId(Integer id) throws Exception {
			List<UserFood> userFoods = userFoodDao.findUserWithId(id);
			if (userFoods.size() == 0) {
				throw new Exception("User ID not found in UserFood Table!");
			}	
			userFoods.removeIf(UserFoodPredicate.hasNotThisCategory(CategoryFood.DINNER));
			if (userFoods.size() == 0) {
				throw new Exception(" No Dinner for this user ID" + id);
			}	else if((userFoods.size() > 1)){
				throw new Exception(" Too many Dinner-Foods for this user ID" + id);
			}
			String message = "";
			message = userFoods.get(0).getIdFood().toString();
			message += ifs.findIngredientsWithThisFoodId(userFoods.get(0).getIdFood().getIdFood());
			
			return message;
			

		}
		
		public String findFoodSnackByUserId(Integer id) throws Exception {
			List<UserFood> userFoods = userFoodDao.findUserWithId(id);
			if (userFoods.size() == 0) {
				throw new Exception("User ID not found in UserFood Table!");
			}	
			userFoods.removeIf(UserFoodPredicate.hasNotThisCategory(CategoryFood.SNACK));
			if (userFoods.size() == 0) {
				throw new Exception(" No Snack for this user ID" + id);
			}	else if((userFoods.size() > 1)){
				throw new Exception(" Too many Snack-Foods for this user ID" + id);
			}
			String message = "";
			message = userFoods.get(0).getIdFood().toString();
			message += ifs.findIngredientsWithThisFoodId(userFoods.get(0).getIdFood().getIdFood());
			
			return message;

	}
}



