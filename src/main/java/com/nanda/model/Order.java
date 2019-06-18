package com.nanda.model;

public class Order {
private String emailId;
private String productCategory;
private String itemDescription;
private int price;
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
public String getItemDescription() {
	return itemDescription;
}
public void setItemDescription(String itemDescription) {
	this.itemDescription = itemDescription;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


}
