package entity;

import java.io.Serializable;
import java.util.List;

public class Section implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Post> list;
	
	
	
	public Section() {
		super();
	}



	public Section(String name, List<Post> list) {
		super();
		this.name = name;
		this.list = list;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<Post> getList() {
		return list;
	}



	public void setList(List<Post> list) {
		this.list = list;
	}



	@Override
	public String toString() {
		return "Section [name=" + name + ", list=" + list + "]";
	}
	
	
	
}
