package com.example.demo.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Bids {
	@Id
private int id;
private String products;
private String value;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProducts() {
	return products;
}
public void setProducts(String products) {
	this.products = products;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
}
