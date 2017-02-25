
public abstract class Money {
	
	//Fields
	private String description;
	
	//Constructor
	public Money(String s) {
		this.description = s;
	}

	//Accessor Method
	public String getDescription(){
		return description;
	}
	
}
