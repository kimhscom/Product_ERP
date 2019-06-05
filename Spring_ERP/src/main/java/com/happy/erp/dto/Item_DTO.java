package com.happy.erp.dto;

import java.io.Serializable;

public class Item_DTO implements Serializable {

	private static final long serialVersionUID = -716088676013123851L;
	private String item_code;
	private String item_name;
	private int item_price;
	private String item_delflag;
	
	public Item_DTO() {
		
	}

	public Item_DTO(String item_code, String item_name, int item_price, String item_delflag) {
		super();
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_delflag = item_delflag;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getItem_delflag() {
		return item_delflag;
	}

	public void setItem_delflag(String item_delflag) {
		this.item_delflag = item_delflag;
	}

	@Override
	public String toString() {
		return "Item_DTO [item_code=" + item_code + ", item_name=" + item_name + ", item_price=" + item_price
				+ ", item_delflag=" + item_delflag + "]";
	}
		

}
