package userData;

import java.util.function.Predicate;

public class UserPredicate {
	public static Predicate<GreekUser>hasNotThisPassword(String password){
		return u -> (u.getPassword() == password);
		
	}

}
