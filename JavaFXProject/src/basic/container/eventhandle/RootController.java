package basic.container.eventhandle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class RootController implements Initializable {//ui만드는거
	@FXML 
	Label label;
	@FXML
	Slider slider;
	
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number startValue, Number endValue) {
				//valueProperty가 변할때마다 처리해주는 내용 작성
				System.out.println("start Vale" + startValue);
				System.out.println("end Vale" +endValue);
				label.setFont(new Font(endValue.doubleValue()));
				
			}
			
		}); //슬라이드 움직이면 값이 변할때마다 듣고있다가 ()안의 내용을 실행
		
	}

	
}
