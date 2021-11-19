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
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import socket.SocketClientCallable;
import userData.CalculatorCalorii;
import userData.GreekUser;

public class UserFoodController {
	private GreekUser foundUser;
	private CalculatorCalorii calculator;

	
	
			
	public GreekUser getFoundUser() {
		return foundUser;
	}

	public void setFoundUser(GreekUser foundUser) {
		this.foundUser = foundUser;
	}


	@FXML
	private Button buttonBreakfast;
	
	@FXML
	private Button buttonLunch;
	
	@FXML
	private Button buttonDinner;
	
	@FXML
	private Button buttonSnack;
		
	@FXML
	private Button workoutButton;
	
	@FXML
	private TextFlow textBreakfast;
	
	@FXML
	private TextFlow textLunch;
	
	@FXML
	private TextFlow textDinner;
	
	@FXML
	private TextFlow textSnack;




	/*
	 * YOU CAN CHANGE THE TEXT ... KEEP IN MIND THAT VALUE IS A STRING TYPE!
	textLunch.setAccessibleText(value);
	textDinner.setAccessibleText(value);
	textSnack.setAccessibleText(value);
	*/
	
	
	@FXML
	private void onWorkoutButtonClick(ActionEvent event) {
		Stage stageTestButton = (Stage) workoutButton.getScene().getWindow();
		stageTestButton.close();
		try {
			Image icon = new Image(getClass().getResource("/resources/image/Zeus Interface icon.jpg").toExternalForm());	
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/UserWorkout.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("User Workout");
			stage.setScene(new Scene(root));
			stage.getIcons().add(icon);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setBreakfastTest(String text) {
		
		System.out.println(text);
		textBreakfast.getChildren().clear();
		Text txt = new Text(text);
		txt.setFont(Font.font("Castellar",18));
		textBreakfast.getChildren().add(txt);
		
	}
	
	public void setLunchTest(String text) {
		System.out.println(text);
		textLunch.getChildren().clear();
		Text txt = new Text(text);
		txt.setFont(Font.font("Castellar",18));
		textLunch.getChildren().add(txt);
		
	}
	
	public void setDinnerTest(String text) {
		System.out.println(text);
		textDinner.getChildren().clear();
		Text txt = new Text(text);
		txt.setFont(Font.font("Castellar",18));
		textDinner.getChildren().add(txt);
		
	}
	
	public void setSnackTest(String text) {
		System.out.println(text);
		textSnack.getChildren().clear();
		Text txt = new Text(text);
		txt.setFont(Font.font("Castellar",18));
		textSnack.getChildren().add(txt);
		
		
	}

	@FXML
	private void onBreakfastButtonClick(ActionEvent event) {

			setBreakfastTest(commandToServer("find breakfast", new Gson().toJson(foundUser)));	
	}
	
	@FXML
	private void onLunchButtonClick(ActionEvent event) {

			setLunchTest(commandToServer("find lunch", new Gson().toJson(foundUser)));
		
	}
	
	@FXML
	private void onDinnerButtonClick(ActionEvent event) {

			setDinnerTest(commandToServer("find dinner", new Gson().toJson(foundUser)));
	}
	
	@FXML
	private void onSnackButtonClick(ActionEvent event) {

			setSnackTest(commandToServer("find snack", new Gson().toJson(foundUser)));
	}
	
	public String commandToServer(String command, String payload) {
		String serverResponse = "";
		ExecutorService es = Executors.newCachedThreadPool();

		System.out.println("Sending command to server with data: " + payload);
		SocketClientCallable commandWithSocket = new SocketClientCallable("localhost", 3800, command, payload);
		
		
		Future<String> response = es.submit(commandWithSocket);
		try {
			// Blocking this thread until the server responds
			serverResponse = response.get();
			
			System.out.println("Response from server is "+ serverResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Connection to server terminated");
		return serverResponse;
		

	}
	

}
