
public class Profit extends Money {
	
	//Fields
	private double amount;
	
	//Constructor
	public Profit(String s, double d){
		super(s);
		this.amount = d;
	}
	
	//Accessor Method
	public double getAmount(){
		return amount;
	}

}
