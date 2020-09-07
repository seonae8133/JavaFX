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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
		
		list.add(new Student("test1",10,20,30));
		list.add(new Student("test2",44,42,34));
		
		//추가버튼
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				 handleBtnAddAction();
				
			}
		});
		//차트버튼
		btnBarChart.setOnAction(e-> handleBtnChartAction());
		
		//-------------테이블뷰 내용 수정--------------------------
		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println(event);
				if(event.getClickCount()==2) {//getselectionModel:선택된 한개를 가지고옴
					String selectedName = tableView.getSelectionModel().getSelectedItem().getName();
					handleDoubleClickAction(selectedName);
				}
				
			}
		});
		
	}//end of initialize 
	
	
	public void handleDoubleClickAction(String name) {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		
		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(210, 230);//컨테이너 크기 지정
		
		
		Label lKorean, lMath, lEnglish;
		TextField tName, tKorean, tMath, tEnglish;
		
		lKorean = new Label("국어");
		lKorean.setLayoutX(35);
		lKorean.setLayoutY(73);
		
		lMath = new Label("수학");
		lMath.setLayoutX(35);
		lMath.setLayoutY(99);
		
		lEnglish = new Label("영어");
		lEnglish.setLayoutX(35);
		lEnglish.setLayoutY(132);
		
		
	tName = new TextField();
	tName.setPrefWidth(110);
	tName.setLayoutX(72);
	tName.setLayoutY(30);
	
	tName.setText(name);
	tName.setEditable(false);
	
	tKorean = new TextField();
	tKorean.setPrefWidth(110);
	tKorean.setLayoutX(72);
	tKorean.setLayoutY(69);
	
	tMath = new TextField();
	tMath.setPrefWidth(110);
	tMath.setLayoutX(72);
	tMath.setLayoutY(95);
	
	tEnglish = new TextField();
	tEnglish.setPrefWidth(110);
	tEnglish.setLayoutX(72);
	tEnglish.setLayoutY(128);
	
	Button btnUpdate = new Button("수정");
	btnUpdate.setLayoutX(85);
	btnUpdate.setLayoutY(184);
	
	
	btnUpdate.setOnMouseClicked(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			if(event.getClickCount()==1) {
				stage.close();
			}
		}

	});
	
	btnUpdate.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getName().equals(name)) {
					Student student = new Student(name, Integer.parseInt(tKorean.getText()),
							Integer.parseInt(tMath.getText()),
									Integer.parseInt(tEnglish.getText())
									);
									list.set(i, student);
				}
			}
			
		}
		
		
	});
	
	
	//이름기준으로 국어, 수학, 영어점수를 화면에 뿌려주기.
	for(Student stu : list) {
		if(stu.getName().equals(name)) {
			tMath.setText(String.valueOf(stu.getMath()));
			tKorean.setText(String.valueOf(stu.getKorean()));
			tEnglish.setText(String.valueOf(stu.getEnglish()));
			
		}
	}
	

	ap.getChildren().addAll(btnUpdate,tName,tKorean,tMath,tEnglish,lKorean,lMath,lEnglish);
	
	
	Scene scene = new Scene(ap);
	stage.setScene(scene);
	stage.show();
		
	}
	
	
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
			
			
			//----------(국어)----------------------
			XYChart.Series<String, Integer> seriesK = new XYChart.Series<String, Integer>();
			seriesK.setName("국어");
			
			ObservableList<XYChart.Data<String, Integer>> koreanList
												= FXCollections.observableArrayList();
			
			for(int i=0; i<list.size(); i++) {
				koreanList.add(new XYChart.Data<>(list.get(i).getName(), list.get(i).getKorean()));
			}
			
			
			//----------(수학)----------------------
			XYChart.Series<String, Integer> seriesM = new XYChart.Series<String, Integer>();
			seriesM.setName("수학");
			
			ObservableList<XYChart.Data<String, Integer>> mathList
												= FXCollections.observableArrayList();
			
			for(int i=0; i<list.size(); i++) {
				mathList.add(new XYChart.Data<>(list.get(i).getName(), list.get(i).getMath()));
			}
			
			
			//----------(영어)----------------------
			XYChart.Series<String, Integer> seriesE = new XYChart.Series<String, Integer>();
			seriesE.setName("영어");
			
			ObservableList<XYChart.Data<String, Integer>> englishList
												= FXCollections.observableArrayList();
			
			for(int i=0; i<list.size(); i++) {
				englishList.add(new XYChart.Data<>(list.get(i).getName(), list.get(i).getEnglish()));
			}
			
			
			seriesK.setData(koreanList);
			barChart.getData().add(seriesK);
			
			seriesM.setData(mathList);
			barChart.getData().add(seriesM);
			
			seriesE.setData(englishList);
			barChart.getData().add(seriesE);
			
			Button btnFormClose = (Button) chart.lookup("#btnClose");
			btnFormClose.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					if(arg0.getClickCount()==1)
						stage.close();
					
				}
				
			});
			
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
			
			
			
			//차트화면 닫기
		
			
			
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
