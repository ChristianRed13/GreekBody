package userData;

import java.util.function.Predicate;

import foodData.CategoryFood;

public class UserFoodPredicate {

	public static Predicate<UserFood>hasNotThisCategory(CategoryFood category){
		return uf -> (uf.getIdFood().getCategory() == category.toString());
		
	}
}
