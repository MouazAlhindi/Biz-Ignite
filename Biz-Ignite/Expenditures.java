
public class Expenditures extends Money{

	private double amount;
	//Constructor
	public Expenditures(String s, double d){
		
		super(s);
		amount = -d;
	}
	
	//getter method
	public double getAmount(){
		
		return amount;
	}
}
