public class Product {

	//FIELDS
	
	private String name;
	private double price;
	private int amountInStock;

	//CONSTRUCTORS 
	
	
	public Product(String name, double price, int amountInStock) {
		this.name = name;
		this.price = price;
		this.amountInStock = amountInStock;
	}
	
	//METHODS

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
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
	
	//methods that add and remove int n amount of a certain product
	public void add(int n) {
		amountInStock += n;
	}
	
	public void remove(int n) {
		amountInStock -= n;
	}
	
	//prints out products
	public String toString() {
		return "Product: " + name + "\tPrice: " + price + "\tAmount In Stock: " + amountInStock;
	}
}
