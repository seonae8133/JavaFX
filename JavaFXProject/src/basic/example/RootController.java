package basic.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {

	@FXML TableView<Student> tableView;
	@FXML Button btnAdd,btnBarChart;
	
	ObservableList<Student> list;
	
	Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		TableColumn<Student,?> tc = tableView.getColumns().get(0);//첫번째 칼럼 가지고옴
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));
		//첫번째 칼럼 가져와서 name 필드에
		
		tc = tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("korean"));
		
		tc = tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("math"));
		
		tc = tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("english"));
		
		
		//--성적저장-----------------------------------------------------------------------
		list = FXCollections.observableArrayList();//list 생성
		//list에 값 추가
		tableView.setItems(list);
		
		//추가버튼
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				 handleBtnAddAction();
				
			}
		});
		
		btnBarChart.setOnAction(e-> handleBtnChartAction());
		
	}//end of initialize 
	
	
	//---------------------------------------차트버튼-----------------------------------------
	public void handleBtnChartAction() {
		Stage stage = new Stage(StageStyle.UTILITY);//윈도우 스타일
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		try {
			Parent chart =FXMLLoader.load(getClass().getResource("BarChart.fxml"));
			Scene scene = new Scene(chart);
			stage.setScene(scene);
			stage.show();
			
			//chart 가지고와서 series를 추가해야한다.
			BarChart barChart = (BarChart) chart.lookup("#barChart");
			
			XYChart.Series<String, Integer> seriesK = new XYChart.Series<String, Integer>();
			seriesK.setName("국어");
			ObservableList koreanList = FXCollections.observableArrayList();
			for(int i=0; i<list.size(); i++) {
				koreanList.add(new XYChart.Data<>(list.get(i).getName(),
																	list.get(i).getKorean(),
																	list.get(i).getMath(),
																	list.get(i).getEnglish()));
			}
			
			seriesK.setData(koreanList);
			barChart.getData().add(seriesK);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//추가화면 보여주는 작업.
	public void handleBtnAddAction() {
		Stage stage = new Stage(StageStyle.UTILITY);//윈도우 스타일
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnAdd.getScene().getWindow());//첫번째 메인 윈도우
		
		try {
			Parent parent =FXMLLoader.load(getClass().getResource("AddForm.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
			
			//추가화면의 컨트롤 사용하기
			Button btnFormAdd = (Button) parent.lookup("#btnFormAdd");//lookup함수 : 해당되는 아이디 값을 찾아옴
			btnFormAdd.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
//--------------------------------추가화면에 있는 저장(Add)버튼.--------------------------------
					TextField txtName = (TextField) parent.lookup("#txtName");
					TextField txtKorean = (TextField) parent.lookup("#txtKorean");
					TextField txtMath = (TextField) parent.lookup("#txtMath");
					TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");
					Student student = new Student(
					txtName.getText(),
					Integer.parseInt(txtKorean.getText()),
					Integer.parseInt(txtMath.getText()),
					Integer.parseInt(txtEnglish.getText())	);
					
					list.add(student);
					
					stage.close();
					
					}//handle
			});
			


//--------------------------------추가화면에 있는 취소버튼.--------------------------------
			Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(e-> {
				TextField txtName = (TextField) parent.lookup("#txtName");
				TextField txtKorean = (TextField) parent.lookup("#txtKorean");
				TextField txtMath = (TextField) parent.lookup("#txtMath");
				TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");
				txtName.clear();
				txtKorean.clear();
				txtMath.clear();
				txtEnglish.clear();
				
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}//end of RootController 
