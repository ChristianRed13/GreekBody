package controllers;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.gson.Gson;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import socket.SocketClientCallable;
import userData.CalculatorCalorii;
import userData.GreekUser;

public class UserController {
	

	
	@FXML
	private Button loginButton;
	@FXML
	private Button signupButton;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private TextFlow text;
	
	@FXML
	private void onSignUpButtonClick(ActionEvent event) throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/UserData.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			nextScene(root,fxmlLoader,false);
	}

	
	@FXML
	public void textChangeEvent() {} 
	
	@FXML
	private void onLoginButtonClick(ActionEvent event) throws IOException {	
	String serverResponse = "";
	String usernameTxt = username.getText();
	String passwordTxt = password.getText();
	GreekUser user = new GreekUser(usernameTxt,passwordTxt);
	
	
	
	String payload = new Gson().toJson(user);
//condition if username or password are not written 
	if(usernameTxt.equalsIgnoreCase("")
			|| passwordTxt.equalsIgnoreCase(""))
		{text.getChildren().clear();
	text.getChildren().add(new Text("Complete both text-boxes"));
		}
	else {
//command to see if the user is existing in the database	
		GreekUser response = comandToServerGJ("find user",payload);
		System.out.println(response);
	 System.out.println(response);
	if(response == null ) {
		text.getChildren().clear();
		text.getChildren().add(new Text("User not found, try again!"));
	}	
		else {		
			
			      
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/UserFood.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			  UserFoodController foodController = fxmlLoader.getController();
			  foodController.setFoundUser(response);
				 nextScene(root, fxmlLoader,true);	
			
   } 
	Platform.setImplicitExit(false);
	}
}
	
	
	//method to swich to UserFood Scene
	public void nextScene(Parent root, FXMLLoader fxmlLoader, boolean fullscreen) {
		Stage stageTestButton = (Stage) loginButton.getScene().getWindow();
		stageTestButton.close();
		Image icon = new Image(getClass().getResource("/resources/image/Zeus Interface icon.jpg").toExternalForm());	
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("User Food");
		stage.setScene(new Scene(root));
		stage.getIcons().add(icon);
		stage.setFullScreen(fullscreen);
		stage.show();
		
		
	}
	
	//introduce comand and the payload to get the server response
	public String comandToServer(String comand, String payload) {
		String serverResponse = "";
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
		return serverResponse;
		

	}
	public GreekUser comandToServerGJ(String comand, String payload) {
		String serverResponse = "";
		ExecutorService es = Executors.newCachedThreadPool();

		System.out.println("Sending command to server with data: " + payload);
		SocketClientCallable commandWithSocket = new SocketClientCallable("localhost", 3800, comand, payload);
		GreekUser gu = new GreekUser();
		
		Future<String> response = es.submit(commandWithSocket);
		try {
			// Blocking this thread until the server responds
			serverResponse = response.get();
			gu = new Gson().fromJson(serverResponse, GreekUser.class);
			System.out.println("Response from server is "+ serverResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Connection to server terminated");
		return gu;
		

	}
	
}
