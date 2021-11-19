package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class UserWorkoutController {
	
	@FXML
	private Button foodButton;
	
	@FXML
	private TextFlow textWorkout;
	
	@FXML
	private void onFoodButtonClick(ActionEvent event) {
		Stage stageTestButton = (Stage) foodButton.getScene().getWindow();
		stageTestButton.close();
		try {
			Image icon = new Image(getClass().getResource("/resources/image/Zeus Interface icon.jpg").toExternalForm());	
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/fxml/UserFood.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("User Diet");
			stage.setScene(new Scene(root));
			stage.getIcons().add(icon);
			stage.setFullScreen(true);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void setWorkoutTest(String text) {
		textWorkout.getChildren().clear();
		Text txt = new Text(text);
		textWorkout.getChildren().add(txt);
		
	}

}
