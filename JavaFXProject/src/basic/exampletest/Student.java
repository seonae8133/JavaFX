package basic.exampletest;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Student {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleIntegerProperty korean;
	private SimpleIntegerProperty math;
	private SimpleIntegerProperty english;
	
	public Student() {}
	public Student( String name, int korean, int math,int english) {
//		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.korean = new SimpleIntegerProperty(korean);
		this.math =  new SimpleIntegerProperty(math);
		this.english =  new SimpleIntegerProperty(english);
	}

	
	public void setId(int id) {
		this.id.set(id);
	}
	
	public int getId() {
		return this.id.get();
	}
	
	//---------------------------------------------------------------
	public void setName(String name) {
		this.name.set(name);
	}

	public String getName() {
		return this.name.get();
	}
//------------------------------------------------------------
		
	public void setKorean(int korean) {
		this.korean.set(korean);
	}
	
	public int getKorean() {
		return this.korean.get();
	}
	
//------------------------------------------------------------
	
	
	public void setMath(int math) {
		this.math.set(math);
	}
	
	public int getMath() {
		return this.math.get();
	}
	
	
	//------------------------------------------------------------
	public void setEnglish(int english) {
		this.english.set(english);
	}

	public int getEnglish() {
		return this.english.get();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", korean=" + korean + ", math=" + math + ", english=" + english + "]";
	}


	
	
	
	
}
