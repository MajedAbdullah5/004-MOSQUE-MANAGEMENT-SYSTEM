package com.Alipur.MosqueManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mosque")

public class Mosque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "credit_amount")
	private double credit_amount;
	
	@Column(name = "debit_amount")
	private double debit_amount;

	@Column(name = "way_of_payment")
	private String wop;
	
	@Column(name="trade_head")
	private String trade_head;
	
	@Column(name = "date")
	private String date;

	@Column(name = "year_of_trade")
	private String yot;

	@Column(name = "trade_by")
	private String trade_by;
	
	@Column(name ="total_balance")
	private double total_balance;
	
	public Mosque() {
	
	}

	public Mosque(int id, String name, String address, double credit_amount, double debit_amount, String wop,
			String trade_head, String date, String yot, String trade_by, double total_balance) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.credit_amount = credit_amount;
		this.debit_amount = debit_amount;
		this.wop = wop;
		this.trade_head = trade_head;
		this.date = date;
		this.yot = yot;
		this.trade_by = trade_by;
		this.total_balance = total_balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getCredit_amount() {
		return credit_amount;
	}

	public void setCredit_amount(double credit_amount) {
		this.credit_amount = credit_amount;
	}

	public double getDebit_amount() {
		return debit_amount;
	}

	public void setDebit_amount(double debit_amount) {
		this.debit_amount = debit_amount;
	}

	public String getWop() {
		return wop;
	}

	public void setWop(String wop) {
		this.wop = wop;
	}

	public String getTrade_head() {
		return trade_head;
	}

	public void setTrade_head(String trade_head) {
		this.trade_head = trade_head;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getYot() {
		return yot;
	}

	public void setYot(String yot) {
		this.yot = yot;
	}

	public String getTrade_by() {
		return trade_by;
	}

	public void setTrade_by(String trade_by) {
		this.trade_by = trade_by;
	}

	public double getTotal_balance() {
		return total_balance;
	}

	public void setTotal_balance(double total_balance) {
		this.total_balance = total_balance;
	}

	@Override
	public String toString() {
		return "Mosque [id=" + id + ", name=" + name + ", address=" + address + ", credit_amount=" + credit_amount
				+ ", debit_amount=" + debit_amount + ", wop=" + wop + ", trade_head=" + trade_head + ", date=" + date
				+ ", yot=" + yot + ", trade_by=" + trade_by + ", total_balance=" + total_balance + "]";
	}
	

}
