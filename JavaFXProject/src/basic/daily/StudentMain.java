package basic.daily;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StudentMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = FXMLLoader.load(getClass().getResource("StudentList.fxml"));
//		BorderPane root = loader.load();
		
//		StudentController controller = loader.getController();
//		controller.setPrimaryStage(primaryStage);
//		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("----열공자바----");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
		
	}
}
