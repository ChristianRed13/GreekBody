package foodData;

import java.util.function.Predicate;

public class FoodsPredicate {
public static Predicate<Food>isInCalorieRange(int calories){
	return f -> calories + 50 < f.getCalories() || calories - 50 < f.getCalories();
}
}
