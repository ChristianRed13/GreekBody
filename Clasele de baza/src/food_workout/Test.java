package food_workout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import foodData.Food;
import workoutData.Workout;

public class Test {

	public static void main(String[] args) {
		String food1 = "-oats 100g\n-milk(2%) 200g\n-cocoa powder 15g\n-honey 15g\n-whey protein 1 scoop";	
		String workout1 = "-decline push-ups 3 x MAX\n-push-ups 3 x Max\n-pike push-ups 3 x MAX\n-dips 3 x 12~15\n-one-arm-band-delt-raises 3 x 12 each";
		
		Food ovaz = new Food("Ovaz cu cacao",food1, "Se incalzeste laptele\nSe cantaresc restul ingredientelor in bol\nPunem laptele peste ingrediente si amestecam", 525,"breakfast");
        System.out.println(ovaz);
        
    
        

	}

}
