package basic.control.chart;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;


public class ChartController implements Initializable {
	
	@FXML PieChart pieChart;
	@FXML BarChart barChart;
	@FXML AreaChart areaChart; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Data>list = FXCollections.observableArrayList(
				new PieChart.Data("AWT",10),new PieChart.Data("Swing",30),
				new PieChart.Data("SWT",25),new PieChart.Data("JavaFX",35));

//		list.add(new PieChart.Data("AWT",10));
//		list.add(new PieChart.Data("Swing",30));
//		list.add(new PieChart.Data("SWT",25));
//		list.add(new PieChart.Data("JavaFX",35));
		pieChart.setData(list);
		
		//-------------BarChart-------------------------------------------
		XYChart.Series<String, Integer> s1 = new XYChart.Series<>();
		s1.setData(getSeries1());
		// 카테고리 이름
		s1.setName("남자");  
		
		XYChart.Series<String, Integer> s2 = new XYChart.Series<>();
		s2.setData(getSeries2());
		// 카테고리 이름
		s2.setName("여자");  
		
		barChart.getData().add(s1);
		barChart.getData().add(s2);
		
		//----------AreaChart-----------------------------------------
		XYChart.Series<String, Integer> s3 = new XYChart.Series<>();
		s3.setData(getSeries3());
		// 카테고리 이름
		s3.setName("온도");  
		
		XYChart.Series<String, Integer> s4 = new XYChart.Series<>();
		s4.setData(getSeries4());
		// 카테고리 이름
		s4.setName("Covid19");  
		
		areaChart.getData().add(s3);
		areaChart.getData().add(s4);
		
	}
	
	//-----------BarChart함수-----------------------------------------
	//String : 카테고리
	//Integer : 값
	public ObservableList<XYChart.Data<String, Integer>> getSeries1() {
		ObservableList<XYChart.Data<String, Integer>> list =
				FXCollections.observableArrayList();
		list.add(new XYChart.Data<String, Integer>("2015",70));
		list.add(new XYChart.Data<String, Integer>("2016",40));
		list.add(new XYChart.Data<String, Integer>("2017",50));
		list.add(new XYChart.Data<String, Integer>("2018",30));
		return list;
	}
	
	public ObservableList<XYChart.Data<String, Integer>> getSeries2() {
		ObservableList<XYChart.Data<String, Integer>> list =
				FXCollections.observableArrayList();
		list.add(new XYChart.Data<String, Integer>("2015",60));
		list.add(new XYChart.Data<String, Integer>("2016",80));
		list.add(new XYChart.Data<String, Integer>("2017",90));
		list.add(new XYChart.Data<String, Integer>("2018",30));
		return list;
	}
	//---------AreaChart 함수---------------------------------------
	public ObservableList<XYChart.Data<String, Integer>> getSeries3() {
		
		Connection conn = ConnectionDB.getDB();
		String sql = "select * from receipt";
		ObservableList<XYChart.Data<String, Integer>> list =
				FXCollections.observableArrayList();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new XYChart.Data<String, Integer>(rs.getNString("receipt_month"),
						rs.getInt("receipt_qty")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
		
	
	
	public ObservableList<XYChart.Data<String, Integer>> getSeries4() {
		ObservableList<XYChart.Data<String, Integer>> list =
				FXCollections.observableArrayList();
		list.add(new XYChart.Data<String, Integer>("09",5));
		list.add(new XYChart.Data<String, Integer>("10",12));
		list.add(new XYChart.Data<String, Integer>("11",15));
		list.add(new XYChart.Data<String, Integer>("12",21));
		return list;
	}

}
