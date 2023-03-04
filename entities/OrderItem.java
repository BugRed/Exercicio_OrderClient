package entities;

public class OrderItem extends Product {
	private Integer quantity;
	
	private Product product;

	public OrderItem() {
		super();
	}
	
	public OrderItem(Integer quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal() {
		return quantity * price;
	}

	@Override
	public String toString() {
		return product.getName() + ", $" 
		+ String.format("%.2f", product.getPrice()) 
		+ ", Quantity: " 
		+ quantity + 
		", Subtotal: $" 
		+ String.format("%.2f", subTotal());
		
	}

}
