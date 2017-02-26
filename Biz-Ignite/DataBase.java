import java.util.*;

/*
 * Data Managment for...
 * User Login Information
 * User Information
 * Money and classes that derive from it
 * Inventory and products
 * Tasks
 */

public class DataBase {
	
	//Fields
	private ArrayList<User> userList = new ArrayList<User>();
	private Inventory inventory = new Inventory();
	
	//Constructor
	
	//Method
	
	//Returns List of Users
	public ArrayList<User> getUsers(){
		return userList;
	}
	
	public ArrayList<Product> getInventoryFromDB(){
		
		return inventory.getInventory();
	}
	
	public String[] getUsersArray(){
		
		String[] users = new String[userList.size()];
		for(int i = 0; i < userList.size(); i++){
			
			users[i] = userList.get(i).getName();
		}
		return users;
	}
	
}
