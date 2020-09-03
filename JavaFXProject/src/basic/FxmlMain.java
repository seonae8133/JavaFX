package basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {//화면 띄워주는거 재정의
		//ui구현 부분
		Parent root=FXMLLoader.load(getClass().getResource("BoxExam.fxml")); //getClass:현재위치에서
		//parent : box들의 최상위 클래스로 hbox,vbox 등 모든 box 실행가능
		Scene scene = new Scene(root); //scene 생성
		primaryStage.setScene(scene);//윈도우 창에 장면 설정 
		primaryStage.show();
		primaryStage.setTitle("FXML 화면제목입니다");
		
	}
	
	public static void main(String[] args) {//실행위해서는 메인메소드 필요
		launch(args);
	}

}
