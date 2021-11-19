package foodData;

public class FoodDBadder {

	public static void main(String[] args) {
		FoodDB foodDB = new FoodDB();
		//DECLARATION IN FORM OF A CONSTRUCTOR OF AN OBJECT FOOD
		Food food1 = new Food("Chocolate Oatmeal","-oats 100g\n-milk(2%) 200g\n-cocoa powder 15g\n-honey 15g\n-whey protein 1 scoop",
		"Heat the milk\nMeasure all the other ingredients in a bowl\nPour the milk on the dry ingredients and mix them all", 525,"breakfast");
		
		Food food2 = new Food("Bacon and Eggs","-eggs 2\\n-wheat bread 80g\\n-black forest bacon 2 pieces\\n-tomatoes 50g",
				"Cook the bacon in non-stick pen at medium heat.\\nWhen it's done, place your bacon on a plate, then immediately crack 2 eggs in the pen and put a lid on."
				+ "\\nSeason your eggs when they are done and toast your wheat bread(optional).\\nDon't forget to wash your tomatoes before you add them to your plate!"
						, 405,"breakfast");
		
		//USING MY METHODS FROM THE DATABASE CLASS OF FOOD I INSERT A NEW OBJECT FOOD IN THE TABLE
     	foodDB.insertFood(food1);
     	foodDB.insertFood(food2);
//		foodDB.deleteFood(1);
		System.out.println((foodDB.getFood(1)));

	}

}
