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
	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	//Constructor
	
	//Methods
	//Employee get Method
	public Employee getEmployee(String u, String p){
		for(User i: userList){
			if(i instanceof Employee){
				if(i.getUserName().equals(u) && i.getPassword().equals(p)){
					return (Employee)(i);
				}
			}
		}
		return null;
	}
	
	//USER METHODS
	//Returns List of Users
	public ArrayList<User> getUsers(){
		return userList;
	}
	
	public void addUser(User i){
		userList.add(i);
	}
	
	//returns arraylist of employees
	public ArrayList<Employee> getEmployeesArrayList(){
		
		ArrayList<Employee> users = new ArrayList<Employee>();
		for(int i = 0; i < userList.size(); i++){
			
			if(userList.get(i) instanceof Employee){
				
				users.add((Employee)userList.get(i));
			}
		}
		return users;
	}
	
	//INVENTORY METHODS
	public ArrayList<Product> getInventoryFromDB(){
		
		return inventory.getInventory();
	}
	
	//TASK METHODS
	public void addTasks(Task t){
		taskList.add(t);
	}
	
	public String[] getTaskArray(){
		
		String[] tasks = new String[taskList.size()];
		for(int i = 0; i < taskList.size(); i++){
			tasks[i] = taskList.get(i).getTaskDescription();
		}
		return tasks;
	}
	
	public ArrayList<Task> getTaskList(){
		return taskList;
	}
}
