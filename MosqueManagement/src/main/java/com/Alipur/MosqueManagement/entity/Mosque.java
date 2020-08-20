package com.Alipur.MosqueManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "amount")
	private int amount;

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

	public Mosque() {

	}

	public Mosque(int id, String name, String address, int amount, String wop, String trade_head, String date,
			String yot, String trade_by) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.amount = amount;
		this.wop = wop;
		this.trade_head = trade_head;
		this.date = date;
		this.yot = yot;
		this.trade_by = trade_by;
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
	

	public String getTrade_head() {
		return trade_head;
	}

	public void setTrade_head(String trade_head) {
		this.trade_head = trade_head;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getWop() {
		return wop;
	}

	public void setWop(String wop) {
		this.wop = wop;
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

	@Override
	public String toString() {
		return "Mosque [id=" + id + ", name=" + name + ", address=" + address + ", amount=" + amount + ", wop=" + wop
				+ ", date=" + date + ", yot=" + yot + ", trade_by=" + trade_by + "]";
	}

}
