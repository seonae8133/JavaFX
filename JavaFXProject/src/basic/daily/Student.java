package basic.daily;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
	private SimpleIntegerProperty stId;
	private SimpleStringProperty stName;
	private SimpleStringProperty stDate;
	private SimpleStringProperty stPhone;
	private SimpleStringProperty stGenger;
	
	public Student(int stId, String stName, String stDate, String stPhone, String stGenger) {

		this.stId =  new SimpleIntegerProperty(stId);
		this.stName = new SimpleStringProperty(stName);
		this.stDate = new SimpleStringProperty(stDate);
		this.stPhone = new SimpleStringProperty(stPhone);
		this.stGenger = new SimpleStringProperty(stGenger);
		
		
	}
	public int getStId() {
		return this.stId.get();
	}
	public void setStId(int stId) {
		this.stId.set(stId);
	}
	
	
	
	public String getStName() {
		return this.stName.get();
	}
	public void setStName(String stName) {
		this.stName.set(stName);
	}
	
	
	
	
	public String getStDate() {
		return this.stDate.get();
	}
	public void setStDate(String stDate) {
		this.stDate.set(stDate);
	}
	
	
	
	
	public String getStPhone() {
		return this.stPhone.get();
	}
	public void setStPhone(String stPhone) {
		this.stPhone.set(stPhone);
	}
	
	
	
	public String getStGenger() {
		return this.stPhone.get();
	}
	public void setStGenger(String stGenger) {
		this.stGenger.set(stGenger);
	}

	
	
}
