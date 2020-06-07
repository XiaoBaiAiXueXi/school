package entity;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class EmployeeProperty {
	private SimpleStringProperty id = new SimpleStringProperty();
	private SimpleStringProperty name = new SimpleStringProperty();
	private SimpleStringProperty gender = new SimpleStringProperty();
	private SimpleStringProperty section = new SimpleStringProperty();
	private SimpleStringProperty post= new SimpleStringProperty();
	
	private SimpleStringProperty level =new SimpleStringProperty();
	
	public EmployeeProperty() {
		super();
	}
	public EmployeeProperty(String id, String name, String gender, String section,String post, String level) {
		setId(id);
		setName(name);
		setGender(gender);
		setSection(section);
		setLevel(level);
		setPost(post);
	}
	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		System.out.println(id);
		this.id.set(id);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getGender() {
		return gender.get();
	}

	public void setGender(String gender) {
		this.gender.set(gender);
	}

	public String getSection() {
		return section.get();
	}

	public void setSection(String section) {
		this.section.set(section);
	}
	public String getPost() {
		return post.get();
	}

	public void setPost(String post) {
		this.post.set(post);
	}
	public String getLevel() {
		return level.get();
	}

	public void setLevel(String level) {
		this.level.set(level);
	}
	
	public SimpleStringProperty idProperty(){
        return id;
    }
	public SimpleStringProperty nameProperty(){
        return name;
    }public SimpleStringProperty genderProperty(){
        return gender;
    }public SimpleStringProperty sectionProperty(){
        return section;
    }public SimpleStringProperty postProperty(){
        return post;
    }public SimpleStringProperty levelProperty(){
        return level;
    }
	@Override
	public String toString() {
		return "EmployeeProperty [id=" + id + ", name=" + name + ", gender=" + gender + ", section=" + section
				+ ", post=" + post + ", level=" + level + "]";
	}
	
	
	
	
}
