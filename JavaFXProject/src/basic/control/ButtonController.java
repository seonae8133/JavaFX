package basic.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ButtonController implements Initializable{

	
	@FXML ToggleGroup group;
	@FXML ImageView radioImageView,checkImageView;
	@FXML RadioButton rad1,rad2,rad3;
	@FXML CheckBox chk1,chk2;
	@FXML Button btnExit;
	@Override
	//property : 속성값이 바뀌어 질때마다 등록
	//addListener: 속성값 감시 리스너
	public void initialize(URL location, ResourceBundle resources) {
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override//바뀌는 대상이 토글그룹,:extends Toggle
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				System.out.println(observable.getValue().toString());
				//인터페이스(ObservableValue :값이 바뀔때마다 값 읽어올수 있는 인터페이스)
				if(oldValue!= null&& newValue!=null)//버블차트 바차트 이런거 가지고옴.
				//속성값에따라 값 변경
				System.out.println("old값"+oldValue.getUserData());
				System.out.println("new값" +newValue.getUserData());
				radioImageView.setImage(new Image("/basic/images/" + newValue.getUserData().toString()+ ".png"));
			}
			
		});//속성값을 읽어오는 메소드(selected toggle property)
		
		//라디오 버튼 이벤트//클릭할때마다 값 변경
		rad1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {//me:mouse event
				System.out.println("rad1 clicked.");
			}
		});
		
		rad2.setOnMouseClicked((a)-> System.out.println("rad2 clicked."));
		rad3.setSelected(true);//실행시rad3값이 제일먼저 선택되어서 화면에 뜸
		
//		chk1.setOnAction((arg0) -> handleChkAction());
//		chk2.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				handleChkAction();
//				
//			}
//			
//		});
		
		btnExit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
				
			}
			
		});
	}//end of Intailize
	
		public void handleChkAction() {
			String imgName ="";
		
			if(chk1.isSelected() && chk2.isSelected()) {
				imgName = "geek-glasses-hair.gif";
			
				}else if(chk1.isSelected()) {
					imgName = "geek-glasses.gif";
				}else if (chk2.isSelected()) {
					imgName = "geek-hair.gif";
				}else {
					imgName = "geek.gif";
				}
				checkImageView.setImage(new Image("/basic/images/"+imgName));
		}
	
}//end of class
