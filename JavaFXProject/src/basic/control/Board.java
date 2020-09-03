package basic.control;

import javafx.beans.property.SimpleStringProperty;

public class Board {
		private SimpleStringProperty title;
		private SimpleStringProperty password;
		private SimpleStringProperty publicity;
		private SimpleStringProperty exitDate;
		private SimpleStringProperty content;
		
		public Board(String title, String password, String publicity, String exitDate, String content) {
			this.title = new SimpleStringProperty(title);
			this.password = new SimpleStringProperty(password);
			this.publicity = new SimpleStringProperty(publicity);
			this.exitDate = new SimpleStringProperty(exitDate);
			this.content = new SimpleStringProperty(content);
		}
		
		public void setTitle(String title) {
			this.title.set(title);
		}
		
		public String getTitle() {
			return this.title.get();
		}
		
		public SimpleStringProperty titleProperty() {//속성 값을 가져오기 위함
			return this.title;
		}
		//----------------------------------------------------------------------
		public void setPassword(String password) {
			this.password.set(password);
		}
		
		public String getPassword() {
			return this.password.get();
		}
		
		public SimpleStringProperty passwordProperty() {//속성 값을 가져오기 위함
			return this.password;
		}
		
		//----------------------------------------------------------------------
		
		public void setPublicity(String publicity) {
			this.publicity.set(publicity);
		}
		
		public String getPublicity() {
			return this.publicity.get();
		}
		
		public SimpleStringProperty publicityProperty() {//속성 값을 가져오기 위함
			return this.publicity;
		}
		//----------------------------------------------------------------------
		public void setExitDate(String exitDate) {
			this.exitDate.set(exitDate);
		}
		
		public String getExitDate() {
			return this.exitDate.get();
		}
		
		public SimpleStringProperty exitDateProperty() {//속성 값을 가져오기 위함
			return this.exitDate;
		}
		//----------------------------------------------------------------------
		public void setContent(String content) {
			this.content.set(content);
		}
		
		public String getContent() {
			return this.content.get();
		}
		
		public SimpleStringProperty contentProperty() {//속성 값을 가져오기 위함
			return this.content;
		}
}
