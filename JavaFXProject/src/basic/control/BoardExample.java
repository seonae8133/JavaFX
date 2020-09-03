package basic.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//UI :BoardControl.fxml
//Control : BoaredController.java
//Board.java
public class BoardExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap =  FXMLLoader.load(this.getClass().getResource("BoardControl.fxml"));
		Scene scene = new Scene(ap);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
