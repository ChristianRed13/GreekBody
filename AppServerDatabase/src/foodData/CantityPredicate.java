package foodData;

import java.util.function.Predicate;

public class CantityPredicate {
public static Predicate<FoodIngredient>hasNotThisCantity(String cantity){
	return i -> (i.getCantity() != cantity);
  }
}
