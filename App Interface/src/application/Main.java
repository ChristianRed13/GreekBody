package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Image icon = new Image(getClass().getResource("/resources/image/Zeus Interface icon.jpg").toExternalForm());	
			Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/UserView.fxml"));
			Scene scene = new Scene(root);		
			scene.getStylesheets().add(getClass().getResource("/resources/css/application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Application | Test");
		    } catch (Exception e) {
			  e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

