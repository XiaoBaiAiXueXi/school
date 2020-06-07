package entity;

import java.io.Serializable;

public class Post implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double money;
	public Post() {
		super();
	}
	public Post(String name, double money) {
		super();
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Post [name=" + name + ", money=" + money + "]";
	}
	
	
}
