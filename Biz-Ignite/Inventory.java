import java.util.ArrayList;
public class Inventory {

	//FIELDS
	
	private ArrayList<Product> inventoryList = new ArrayList<Product>(); 
	private int size;
	
	
	//CONSTRUCTORS
	
	public Inventory() {
		size = 0;
	}
	
	//METHODS
	
	public int size() {
		return size;
	}
	//returns an ArrayList with all products in the inventory
	public ArrayList<Product> getInventory() {
		return inventoryList;
	}
	
	//adds an product to the inventory
	public boolean add(Product p) {
		if (size == 0) {
			inventoryList.add(p);
			size++;
			return true;
		}
		for (Product o: inventoryList) {
			if (p.getName().compareToIgnoreCase(o.getName()) == 0) {
				System.out.println("Product already exists in inventory");
				return false;
			}
		}
		for(int i = 0; i < inventoryList.size(); i++) {
			if (p.getName().compareToIgnoreCase(inventoryList.get(i).getName()) > 0) {
				inventoryList.add(i, p);
				size++;
				return true;
			}
		}
		
		return false;
	}
	
	//prints out everything in the inventory
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		
		if(inventoryList.size() == 0){
			return "";
		} else if(inventoryList.size() == 1) {
			return inventoryList.get(0).toString();
		} else {
			for (int i = inventoryList.size() - 1; i >= 0; i--){
				result.append(inventoryList.get(i));
				result.append("\n");
			}
		}
		return result.toString();
	}
}
