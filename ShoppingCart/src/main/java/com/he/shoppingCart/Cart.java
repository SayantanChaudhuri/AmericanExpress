/**
 * 
 */
package com.he.shoppingCart;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Sayantan
 *
 */
public class Cart {

	private Map<Product, Integer> addedProducts = new HashMap<>();

	private Inventory inventory = Inventory.getInstance();

	public Cart() {
	}

	public void addItem(Product product, Integer amount) throws CloneNotSupportedException {

		if (amount != null && amount > 0) {

			if (addedProducts.containsKey(product)) {
				Integer addedQuantity = addedProducts.get(product);

				if (addedQuantity != null) {
					addedProducts.put(product, addedQuantity + amount);
				} else {
					addedProducts.put(product, amount);
				}

			} else {
				addedProducts.put(product, amount);
			}
		} else {
			throw new RuntimeException("Cart :: addItem :: Amount is null or not less than 0");
		}
	}

	public void removeItem(Product product) {

		Integer quantity = addedProducts.get(product);

		if (quantity == null) {
			throw new RuntimeException("Cart :: removeItem :: Product not found");
		}

		addedProducts.remove(product);
	}

	public void generateInvoice() {

		double totalPrice = 0;

		for (Entry<Product, Integer> productEntry : addedProducts.entrySet()) {

			double totalProductPrice = productEntry.getKey().getPrice() * productEntry.getValue();

			totalPrice += totalProductPrice;

//			<Name of Product1> <Quantity> <Total price for this product>
			
			System.out.println(
					String.format("%s %d %.2f", productEntry.getKey().getName(), productEntry.getValue(), totalPrice));
		}

		System.out.println(String.format("Total price: %.2f", totalPrice));
	}

	public void checkOut() {

		inventory.removeItems(addedProducts);

		addedProducts.clear();
	}

	public void emptyCart() {
		addedProducts.clear();
	}
}
