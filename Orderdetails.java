package com.th.SpringBoot;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 @Entity
 
public class Orderdetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int OrderID;
	private String ItemID;
	private double Price;
    private int Quantity;
    private double amount;
    public Orderdetails() {
    	
    }
    public Orderdetails(int OrderID,String ItemID,double Price,int Quntity,double amount) {
    	this.OrderID=OrderID;
    	this.ItemID=ItemID;
    	this.Price=Price;
    	this.Quantity=Quntity;
    	this.amount=amount;
    }
    public int getOrderID() {
		return OrderID;
	}
    
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getItemID() {
		return ItemID;
	}
	public void setItemID(String itemID) {
		ItemID = itemID;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getOrderDeatailID() {
		return Id;
	}
	public void setOrderDeatailID(int orderDeatailID) {
		this.Id = orderDeatailID;
	}
	

}
