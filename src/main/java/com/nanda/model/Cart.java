package com.nanda.model;

public class Cart {
private int cartId;
private String emailId;
private int productId;
private String productCategory;
private int itemId;
private String itemdesc;
private int price;

public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public String getItemdesc() {
	return itemdesc;
}
public void setItemdesc(String itemdesc) {
	this.itemdesc = itemdesc;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
