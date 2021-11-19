package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.gson.Gson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import socket.SocketClientCallable;
import userData.CalculatorCalorii;
import userData.Gender;
import userData.GreekUser;

public class UserDataController implements Initializable{
	@FXML
	private Label errorNull;
	@FXML
	private Label errorLabel;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField password;
	
	@FXML
	private TextField age;
	
	@FXML
	private TextField height;
	
	@FXML
	private TextField weight;
	
	@FXML
	private Button foodButton;
	
	@FXML
	private ChoiceBox<String> goals;		
	private String[] goalsArray = {"Put Muscle","Lose Weight","Both"};
	
    @FXML
	private ChoiceBox<Gender> gender;		
	private enum Gender{Male, Female};
	
    @FXML
	private ChoiceBox<String> activity;		
	private String[] activityArray = {"Sedentary","Sport 1-3 days/week","Sport 3-5 days/week","Sport 6-7 days/week"};
	
    @FXML
	private ChoiceBox<String> workout;		
	private String[] workoutArray = {"Strength","Calisthenics(no equipment)","Muscle Hypertrophy(bodybuilding)"};

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		goals.getItems().addAll(goalsArray);
		gender.getItems().setAll(Gender.values());
		activity.getItems().addAll(activityArray);
		workout.getItems().addAll(workoutArray);
		
		
	}
	
	@FXML
	private void onDietFinishButtonClick(ActionEvent event) throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/UserFood.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

		
			if(!password.getText().matches(regex))
//				errorLabel.setText("");
				errorLabel.setText("Follow the rules below!");
			else
				if(name.getText().equalsIgnoreCase("")
						 || age.getText().equalsIgnoreCase("")
						 || height.getText().equalsIgnoreCase("")
						 || weight.getText().equalsIgnoreCase("")
						 || goals.toString().equalsIgnoreCase("")
						 || gender.toString().equalsIgnoreCase("")
						 || activity.toString().equalsIgnoreCase("")
						 || workout.toString().equalsIgnoreCase("")
						)
				errorNull.setText("Not cool DUD. Complete all text-boxes!");
				else {
					GreekUser gu = new GreekUser();
					gu.setActivity((String)activity.getValue());
					gu.setAge(age.getText());
					gu.setGenderString((String)gender.getValue().toString());
					gu.setGoals((String)goals.getValue());
					gu.setHeight(height.getText());
					gu.setPassword(password.getText());
					gu.setUsername(name.getText());
					gu.setWorkoutType((String)workout.getValue());
					gu.setWeight(weight.getText());
					String payload = new Gson().toJson(gu);
					System.out.println(payload);
					System.out.println(comandToServer("create user",payload));
					
					//completeaza variabila din foodData pt a o tine minte !!!!
					
			        UserFoodController foodController = fxmlLoader.getController();
			        foodController.setFoundUser(gu);
					 nextScene(root, fxmlLoader);					 
				}
					
	}
	
	public CalculatorCalorii comandToServer(String comand, String payload) {
		String serverResponse = "";
		CalculatorCalorii calculator = new CalculatorCalorii();
		ExecutorService es = Executors.newCachedThreadPool();

		System.out.println("Sending command to server with data: " + payload);
		SocketClientCallable commandWithSocket = new SocketClientCallable("localhost", 3800, comand, payload);
		
		
		Future<String> response = es.submit(commandWithSocket);
		try {
			// Blocking this thread until the server responds
			serverResponse = response.get();
			System.out.println("Response from server is "+ serverResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Connection to server terminated");
		return calculator;
		

	}
	
	public void nextScene(Parent root, FXMLLoader fxmlLoader) {
		Stage stageTestButton = (Stage) foodButton.getScene().getWindow();
		stageTestButton.close();
		Image icon = new Image(getClass().getResource("/resources/image/Zeus Interface icon.jpg").toExternalForm());	
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("User Food");
		stage.setScene(new Scene(root));
		stage.getIcons().add(icon);
		stage.show();
		
		
	}
	
}

