
public class User {
	
	//Fields
	private String userName;
	private String password;
	private String name;
	private boolean clearance;
	
	//Constructor
	public User(String u, String p, String n, boolean b){
		this.userName = u;
		this.password = p;
		this.name = n;
		this.clearance = b;
	}
	
	//Accessor Methods
	public String getUserName(){
		return userName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean getClearance(){
		return clearance;
	}
	
	//toString method for testing
	public String toString(){
		
		return userName;
	}
	
}
