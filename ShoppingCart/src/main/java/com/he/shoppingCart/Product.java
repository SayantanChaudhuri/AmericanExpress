package com.he.shoppingCart;

public class Product implements Cloneable{

	private String name;
	private Double price;
	
	public Product(String name, Double price){
		
		if(name == null) {
			throw new RuntimeException("Product :: constructor :: Name is mandatory");
		}
		
		if(price < 0) {
			throw new RuntimeException("Product :: constructor :: Price cannot be negetive");
		}
		
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if(name == null) {
			throw new RuntimeException("Product :: setName :: Name is mandatory");
		}
		this.name = name;
	}
	
	public Double getPrice() {
		return this.price;
	}
	
	public void setPrice(Double price) {
		
		if(price < 0) {
			throw new RuntimeException("Price cannot negetive");
		}
		
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.toUpperCase().hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		
//		System.out.println("...Hascode : " + result);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Product 
				&& name != null
				&& price != null
				&& ((Product) obj).getName() != null
				&& ((Product) obj).getName().equalsIgnoreCase(this.getName())
				&& ((Product) obj).getPrice() != null
				&& ((Product) obj).getPrice().doubleValue() == this.getPrice().doubleValue()) {
			
			return true;
		}
		
		return false;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return new Product(this.getName(), this.getPrice());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
}
