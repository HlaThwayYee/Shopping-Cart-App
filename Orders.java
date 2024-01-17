package com.th.SpringBoot;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderID;
    private LocalDate OrderDate;
    private String ContactName;
    private String Address;
    private String Phone;
    private String Email;
    private String CreditCartNumber;
    public void setId(int OrderID) {
		this.OrderID=OrderID;
	}
	public int getId() {
		return OrderID;
	}
	public void setOrderDate(LocalDate localDate) {
		this.OrderDate =localDate;
	}
	public LocalDate getOrderDate() {
		return OrderDate;
	}
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String ContactName) {
		this.ContactName = ContactName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		this.Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getCreditCartNumber() {
		return CreditCartNumber;
	}
	public void setCreditCartNumber(String creditCartNumber) {
		this.CreditCartNumber = creditCartNumber;
	}
 
}