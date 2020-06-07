package entity;

import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String gender;
	private String section;
	private String level;
	
	public Employee() {
		
	}

	public Employee(String id, String name, String gender, String section, String level) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.section = section;
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", section=" + section + ", level="
				+ level + "]";
	}
	
}
