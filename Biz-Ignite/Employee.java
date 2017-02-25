import java.util.*;

public class Employee extends User{
	
	private int idNum;
	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	public Employee(String x, String y, String z, String c, int id){
		super(x, y, z, c,  false);
		
		this.idNum = id;
	}
	
	public int getIdNum(){
		return idNum;
	}
}
