package entity;

import java.io.Serializable;

public class PayLevel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int level;
	private double money;
	
	PayLevel(){
		
	}

	public PayLevel(int level, double money) {
		super();
		this.level = level;
		this.money = money;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "PayLevel [level=" + level + ", money=" + money + "]";
	}
	
}
