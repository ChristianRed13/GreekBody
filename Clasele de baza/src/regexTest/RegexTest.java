package regexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	
	public static void main(String[] args) {
	      String passwd = "Hatz13@gfgfhfh"; 
	      String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	      String pattern2 = ".*[a-z].*";
	      System.out.println(passwd.matches(pattern));

  }
}
