package foodData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDB {
	String connectionURL = "jdbc:mysql://localhost/greekgodconnection";
	String username = "root";
	String password = "1313HaTz@";
	
	public Food getFood(int foodId) {
		Food food = null;
		try (Connection con = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement ps = createPreparedStatement(con, foodId);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				food = new Food(rs.getString("foodName"), rs.getString("ingredients"), rs.getString("preparation"), rs.getFloat("calories"), rs.getString("category"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return food;
	}
	
	public List<Food> getAllFoods() {
		List<Food> foods = new ArrayList<Food>();
		try (Connection con = DriverManager.getConnection(connectionURL,username, password);
				PreparedStatement ps = createPreparedStatementgetAllFoods(con);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				foods.add(new Food( rs.getString("foodName"), rs.getString("ingredients"), rs.getString("preparation"), rs.getFloat("calories"), rs.getString("category")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foods;
	}
	//RANDOM GENERATORUL CU PROPRIETATEA DE A CAUTA O ANUMITA CATEGORIE DE MANCARE POATI SA FIE CREEAT CHIAR AICI DREPT METODA CA MAI APOI SA FIE FOLOSITA ACEASTA METODA IN 
	//CONTROLLERUL BUTONULUI DE GENERATE DIET DIN FORMULARUL DE COMPLETAT DIN JAVA FX
	
	public void insertFood(Food food) {
		try (Connection con = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement ps = createPreparedStatementInsertFood(con, food);) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFood(int foodId) {
		try (Connection con = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement ps = createPreparedStatementDeleteFood(con, foodId);) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private PreparedStatement createPreparedStatementgetAllFoods(Connection con) throws SQLException {
		String sql = "SELECT * FROM food";
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}	
	/*	private String foodName;
	private String ingredients ;
	private String preparation;
	private float calories;
	private String category;
	*/
	private PreparedStatement createPreparedStatement(Connection con, int foodId) throws SQLException {
		String sql = "SELECT foodId, foodName, ingredients, preparation, calories, category FROM food WHERE foodId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, foodId);
		return ps;
	}
	
	private PreparedStatement createPreparedStatementDeleteFood(Connection con, int foodId) throws SQLException {
		String sql = "DELETE FROM food WHERE foodId = " + foodId;
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}
	
	private PreparedStatement createPreparedStatementInsertFood(Connection con, Food food) throws SQLException {
		String sql = "INSERT INTO food(foodName, ingredients, preparation, calories, category) " + "VALUES(?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql); 
		ps.setString(1, food.getFoodName());
		ps.setString(2, food.getIngredients());
		ps.setString(3, food.getPreparation());
		ps.setFloat(4, food.getCalories());
		ps.setString(5, food.getCategory());
		return ps;
	}	
	
}
