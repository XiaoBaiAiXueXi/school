package entity;

import java.io.Serializable;

public class SeniorityPay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int date;
	private double money;
	
	
	public SeniorityPay() {
		super();
	}


	public SeniorityPay(int date, double money) {
		super();
		this.date = date;
		this.money = money;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}


	@Override
	public String toString() {
		return "SeniorityPay [date=" + date + ", money=" + money + "]";
	}
	
	
	
}
