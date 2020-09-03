package basic.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InputExample2 extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		AnchorPane root = FXMLLoader.load(getClass().getResource("Input.fxml"));
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();
		
	}

		public static void main(String[] args) {
			Application.launch(args);
		}
}
