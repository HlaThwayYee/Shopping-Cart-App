package com.th.SpringBoot;

public class Item {
	public String ItemID;
	public String brandname;
	public int qty;
	public double price;
	public double amount;
    public Item() {
    	
    }
	public String getItemID() {
		return ItemID;
	}
	public void setItemID(String itemID) {
		this.ItemID = itemID;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
