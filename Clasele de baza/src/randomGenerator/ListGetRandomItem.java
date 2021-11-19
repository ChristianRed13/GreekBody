package randomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
public class ListGetRandomItem {
 
    // Drive Function
    public static void main(String[] args)
    {
 
        // create a list of String type
        List<String> list = new ArrayList<>();
        // add 5 element in ArrayList
        list.add("John");
        list.add("Hatz");
        list.add("Chelutzu");
        list.add("Gay");
        list.add("Au");
 
        ListGetRandomItem obj = new ListGetRandomItem();
 
        // take a random element from list and print them
        System.out.println(obj.getRandomElement(list));
    }
 
    // Function select an element base on index
    // and return an element
    public String getRandomElement (List<String> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}