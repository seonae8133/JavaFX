package basic.control.input;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;

public class InputController implements Initializable {
	@FXML TextField txtTitle;
	@FXML PasswordField txtPassword;
	@FXML ComboBox comboPublic;
	@FXML DatePicker dateExit;
	@FXML TextArea txtContent;
	@FXML Button btnReg,btnCancel;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		txtTitle.setText("안녕하세요");
//		comboPublic.setValue("public");
		btnReg.setOnAction((ae) -> handlebtnRegAction());
	}

		public void handlebtnRegAction() {
			if(txtTitle.getText() ==null || txtTitle.getAccessibleText().equals("")) {
				showPopup("타이틀을 입력하세요");
			}else if(txtPassword.getText()==null ||txtPassword.getText().equals("")){
				showPopup("비밀번호를 입력하세요");
			} else if(comboPublic.getValue()==null || comboPublic.getValue().equals("")) {
				showPopup("공개여부를 지정하세요");
			}
		}//end handlebtnRegAction
		
		public void showPopup(String msg) {
			//popup 타이틀 등록.
			HBox hbox = new HBox();
			hbox.setStyle("-fx-background-color: black; -fx-background-radius: 20; "); //폰트 크기 가운데 정렬 등
			hbox.setAlignment(Pos.CENTER);
			
			ImageView iv = new ImageView();
			iv.setImage(new Image("/basic/images/dialog-info.png"));
			
			Label label = new Label();
			label.setText(msg);
			label.setStyle("-fx-text-fill : yellow; ");
			hbox.getChildren().addAll(iv, label);
			
			Popup pop = new Popup();
			pop.getContent().add(hbox);
			pop.setAutoHide(true);//닫기버튼 안눌러도 다른곳 누르면 닫겠다
			pop.show(btnReg.getScene().getWindow()); //primaryStage에 있는것중 아무거나 하나로 설정하면됨
			//primaryStage에 소속된 
		}
		
		
		
}
