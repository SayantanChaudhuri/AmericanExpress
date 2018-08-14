package com.he.shoppingCart;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

	private static Inventory inventory = new Inventory();
	Map<Product, Integer> products = new HashMap<>();

	private Inventory() {
	}

	public static Inventory getInstance() {

		return inventory;
	}

	public void addItems(Map<Product, Integer> product2bAdd) {

		if (product2bAdd != null) {

			product2bAdd.keySet().forEach(product -> {

				Integer quantity = product2bAdd.get(product);
				
				
				if (quantity == null || quantity < 0) {
					throw new RuntimeException("Inventory :: addItems :: Quantity is not greater than or equal to zero");
				}

				Integer productCount = products.get(product);
				
				if (productCount == null) {
					products.put(product, quantity);
				} else {
					products.put(product, productCount + quantity);
				}
			});
		} else {
			throw new RuntimeException("Inventory :: addItems :: No items to add");
		}
	}

	public void removeItems(Map<Product, Integer> product2remove) {

		if (product2remove != null) {

			product2remove.keySet().forEach(product -> {

				Integer quantity = product2remove.get(product);

				if (quantity == null || quantity < 0) {
					throw new RuntimeException("Inventory :: removeItems :: Quantity is not greater than or equal to zero");
				}

				Integer productCount = getAvailableAmount(product);

				if (productCount == null) {
					throw new RuntimeException("Inventory :: removeItems :: No item is found to remove");
				} else {
					if (productCount < quantity) {
						throw new RuntimeException("Inventory :: removeItems :: Asking Quantity is not avaliable in the inventory");
					}

					products.put(product, productCount - quantity);
				}

			});
		} else {
			throw new RuntimeException("Inventory :: removeItems :: No items to remove");
		}
	}

	public Integer getAvailableAmount(Product product) {

		return products.get(product);
	}
}
