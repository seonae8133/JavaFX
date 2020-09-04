package basic.exampletest;
//UI : Root.fxml(기본), AddForm.fxml (추가하는 화면) , BarChart.fxml(차트정보)
//Control : RootController.java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader =new FXMLLoader(getClass().getResource("Root.fxml"));
		BorderPane root =loader.load();
		
		/*basic.example.*/
		RootController controller =loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false); //사이즈 변경 x :false
		 
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
