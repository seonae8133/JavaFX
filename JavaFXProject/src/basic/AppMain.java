package basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {//Application을

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox(); //컨테이너
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		
		TextField tField = new TextField();
		//사용자가 텍스트 입력할수 있게 해주는 컨트롤_javaFX
		tField.setPrefWidth(200);
		
		Button btn = new Button();
		btn.setText("확인");
		btn.setOnAction(new EventHandler<ActionEvent>() {//이벤트 핸들러를 구현하는 익명의 객체를 구현 : new EventHandler {구현할 내용}

			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit(); //확인버튼을 누르면 프로그램 종료하는 이벤트
				
			}
			
		});
		
		hbox.getChildren().add(tField);
		hbox.getChildren().add(btn);
		
		Scene scene = new Scene(hbox); // scene 을 만들때는 컨테이너를 매개값으로 담아줘야함
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
