package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.FoodDAO;
import dao.UserDao;
import foodData.Food;
import userData.GreekUser;
import userData.UserPredicate;

public class UserService {
	
	private UserDao userdao;
	
	public UserService() {
		try {
			userdao = new UserDao(Persistence.createEntityManagerFactory("AppServer"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public void addUser(GreekUser newFood) {
		userdao.create(newFood);
	}

	public void updateUser(GreekUser updatedFood) {
		userdao.update(updatedFood);
	}

	public List<GreekUser> getAllUsers() {
		return userdao.findAll();
	}
	
	public GreekUser findGreekUserWithID(int ID) throws Exception {
		List<GreekUser> users = userdao.findID(ID);
	
		if (users.size() == 0) {
			throw new Exception("ID not found!");
		}	
		if (users.size() > 1) {
			throw new Exception("ID is not unique, database error!");
		}	
		GreekUser user = users.get(0);
  
		return user;
	}
	
	public GreekUser findUserWithNamePassword(String name, String password) throws Exception {
		List<GreekUser> users = userdao.find(name);	
		if (users.size() == 0) {
			throw new Exception("Name of the user not found!");
		}	
		users.removeIf(UserPredicate.hasNotThisPassword(password));
		if(users.size() == 0) {
			throw new Exception("Password not found!");
		}		
		return users.get(0);
	}
}
