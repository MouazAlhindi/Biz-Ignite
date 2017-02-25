public class Product {

	//fields
	
	private String name;
	private int price;
	private int amountInStock;

	//constructors 
		
	public Product() {
		name = null;
		price = 0;
		amountInStock = 0;
	}
	
	//methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmountInStock() {
		return amountInStock;
	}

	public void setAmountInStock(int amountInStock) {
		this.amountInStock = amountInStock;
	}
	
	public String toString() {
		return "Product: " + name + "\tPrice: " + price + "\tAmount In Stock: " + amountInStock;
	}
}
