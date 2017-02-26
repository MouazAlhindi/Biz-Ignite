
public class Task {
	
	private String taskDescription;
	private int empNumAssignment;
	
	public Task(String n, int id){
		this.taskDescription = n;
		this.empNumAssignment = id;
	}
	
	//Mutator Methods
	public void changeEmpAssignment(int x){
		empNumAssignment = x;
	}
	
	public void changeDescription(String s){
		taskDescription = s;
	}
	
	//Accessor Methods
	public String getTaskDescription(){
		return taskDescription;
	}
	
	public int getAssignedEmp(){
		return empNumAssignment;
	}
}
