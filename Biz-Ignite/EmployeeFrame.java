//Imports
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


//Employee Frame Class
public class EmployeeFrame extends JFrame{
	
	//Fields
	
	//DataBase Refrence
	private DataBase data;
	private Employee emp;
	
	//JComponenets
	private JPanel taskPanel;
	private JLabel taskLabel;
	//private DefaultListModel<Task> modelList;
	private ArrayList<Task> tList;
	private JScrollPane scroll;
	private JList<Task> taskList;
	private JButton completeButton;
	
	
	//Constructor
	public EmployeeFrame(DataBase d, Employee e){
		
		//initialize DataBase
		this.data = d;
		this.emp = e;
		
		//Initalize componenets
		taskPanel = new JPanel();
		taskPanel.setLayout(new BorderLayout());
		taskLabel = new JLabel("Tasks");
		//modelList = new DefaultListModel<Task>();
		tList = data.getTaskList();
		taskList = new JList(data.getTaskArray());
		scroll = new JScrollPane(taskList);
		completeButton = new JButton("Completed Task");
		completeButton.addActionListener(new CompleteButtonListener());
		
		//Add Componetents to panel and frame
		taskPanel.add(taskLabel, BorderLayout.NORTH);
		taskPanel.add(taskList, BorderLayout.CENTER);
		taskPanel.add(completeButton, BorderLayout.SOUTH);
		add(taskPanel);
		
		//Frame Setup
		setTitle(e.getCompanyName());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		//pack();
		
	}
	
	//Methods
	public void displayTasks(){
		ArrayList<Task> tList = data.getTaskList();
		ArrayList<Task> finalList = new ArrayList<Task>();
		
		for(Task t: tList){
			if(t.getAssignedEmp() == emp.getIdNum()){
				finalList.add(t);
				System.out.println("Element Added: " + t.getTaskDescription());
			}
		}
		String[] tasks = new String[finalList.size()];
		
		for(int i = 0; i > finalList.size(); i++){
			tasks[i] = finalList.get(i).getTaskDescription();
		}
	}
	
	public void markTaskCompleted(){
		
	}
	
	//ActionListeners
	public class CompleteButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			displayTasks();
		}
	}
}
