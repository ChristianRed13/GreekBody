package workoutData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WorkoutDB {
	String connectionURL = "jdbc:mysql://localhost/greekgodconnection";
	String username = "root";
	String password = "1313HaTz@";
	
	public Workout getWorkout(int workoutId) {
		Workout workout = null;
		try (Connection con = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement ps = createPreparedStatement(con, workoutId);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				workout = new Workout(rs.getString("name"), rs.getString("program"), rs.getInt("time"), rs.getString("category"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return workout;
	}
	
	public List<Workout> getAllWorkouts() {
		List<Workout> workouts = new ArrayList<Workout>();
		try (Connection con = DriverManager.getConnection(connectionURL,username, password);
				PreparedStatement ps = createPreparedStatementgetAllWorkouts(con);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				workouts.add(new Workout( rs.getString("name"), rs.getString("program"), rs.getInt("time"), rs.getString("category")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return workouts;
	}
	
	public void insertWorkout(Workout workout) {
		try (Connection con = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement ps = createPreparedStatementInsertWorkout(con, workout);) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteWorkout(int workoutId) {
		try (Connection con = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement ps = createPreparedStatementDeleteWorkout(con, workoutId);) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private PreparedStatement createPreparedStatementgetAllWorkouts(Connection con) throws SQLException {
		String sql = "SELECT * FROM workout";
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}	
	
	private PreparedStatement createPreparedStatement(Connection con, int workoutId) throws SQLException {
		String sql = "SELECT workoutId, name, program, time, category FROM workout WHERE workoutId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, workoutId);
		return ps;
	}
	
	private PreparedStatement createPreparedStatementDeleteWorkout(Connection con, int workoutId) throws SQLException {
		String sql = "DELETE FROM workout WHERE workoutId = " + workoutId;
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}
	
	private PreparedStatement createPreparedStatementInsertWorkout(Connection con, Workout workout) throws SQLException {
		String sql = "INSERT INTO workout(name, program, time, category) " + "VALUES(?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql); 
ps.setString(1, workout.getName());
ps.setString(2, workout.getProgram());
ps.setInt(3, workout.getTime());
ps.setString(4, workout.getCategory());
		return ps;
	}	
		
	
}
