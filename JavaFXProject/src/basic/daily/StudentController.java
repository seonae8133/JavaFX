package basic.daily;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import basic.example.Student;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StudentController implements Initializable {
	
	@FXML TableView<Student> tableView;
	@FXML Button btnAdd,btnExit;
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	//--학생리스트화면 추가버튼 액션
//		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				 handleBtnAddAction();
//			}
//			
//		}
//			
//				
//				
//	);
		
	}
	//--학생등록 취소버튼
	public void handleBtnCancelAction(ActionEvent e) {
		Platform.exit();
	}
	
	//--학생리스트 추가버튼 클릭시 추가화면띄우기
	public void handleBtnAddAction() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnAdd.getScene().getWindow());
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("StudyRegist.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public void handleBtnExit() {
		Platform.exit();
	}
}
