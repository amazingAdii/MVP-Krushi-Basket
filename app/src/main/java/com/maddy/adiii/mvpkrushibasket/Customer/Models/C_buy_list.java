package com.maddy.adiii.mvpkrushibasket.Customer.Models;

public class C_buy_list {
	
	String Product, imageUrl, price, quantityAvi, sPrice;
	
	//Empty Constructor for Firebase
	public void C_buy_list(){
	
	}
	
	public String getProduct() {
		return Product;
	}
	
	public void setProduct(String product) {
		Product = product;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getQuantityAvi() {
		return quantityAvi;
	}
	
	public void setQuantityAvi(String quantityAvi) {
		this.quantityAvi = quantityAvi;
	}
	
	public String getsPrice() {
		return sPrice;
	}
	
	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}
}
