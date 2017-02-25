import java.util.*;

public class Employee extends User{
	
	private int idNum;
	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	public Employee(String x, String y, String z, int id){
		super(x, y, z, false);
		
		this.idNum = id;
	}
	
	public int getIdNum(){
		return idNum;
	}
}
