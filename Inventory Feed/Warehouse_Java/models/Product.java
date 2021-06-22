package models;

public class Product {
	
	private String productID;
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private int quantity;
	
	public Product(String productID, int quantity) {
		this.productID = productID;
		this.quantity = quantity;
	}
}
