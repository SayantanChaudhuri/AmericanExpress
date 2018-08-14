package com.he.shoppingCart;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Inventory inventory = Inventory.getInstance();
		
		Map<Product, Integer> items2Add = new HashMap<>(); 
		
		items2Add.put(new Product("Book", new Double(100)), 1);
		
//		inventory.addItems(items2Add);
		
		items2Add.clear();
		items2Add.put(new Product("Pen", new Double(10)), 5);
		
//		inventory.addItems(items2Add);
		
		
		Cart cart = new Cart();
//		cart.addItem(new Product("book", new Double(100)), 1);
//		cart.addItem(new Product("Pen", new Double(10)), 5);
		
		
		cart.generateInvoice();
		cart.checkOut();
		
		System.out.println(inventory.products);
	}
}
