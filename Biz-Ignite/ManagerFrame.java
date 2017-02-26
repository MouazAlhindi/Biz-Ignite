import java.awt.*;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.*;

public class ManagerFrame extends JFrame{
	
	//Tabbed pane object
	private JTabbedPane tabbedFrame= new JTabbedPane();
	
	//Panel Objects
	private JPanel mainEmployeePanel;
	private JPanel employeep1;
	private JPanel employeep2;
	private JPanel mainInventoryPanel = new JPanel();
	private JPanel inventoryp1 = new JPanel();
	private JPanel inventoryp2 = new JPanel();
	private JPanel financesTab = new JPanel();
	
	//Inventory Tab
	//Inventory bottem panel Compoenents
	private JComboBox productMenu;
	private JLabel amountLabel;
	private JTextField amountInput;
	private JButton orderButton;
	
	//Inventory top panel componenets
	private JTable inventoryTable = new JTable();
	
	
	//Employee Tab
	//Employee tab componenets
	private JLabel taskLabel;
	private DefaultListModel taskModel;
	private JList empTask;
	private JLabel empListLabel;
	private DefaultListModel model;
	private JList employeeList;
	private JButton addTaskButton;
	private JButton addEmployeeButton;
	
	//Database refrence var
	private DataBase data;
	
	
	
	//constructor
	public ManagerFrame(DataBase d){
		
		this.data = d;
		
		setEmployeeTab();
		setInventoryTab();
		//setFinancesTab();
		
		add(tabbedFrame);
		setTitle("Manager View");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
	}

	/*************************************************************************
 							Finances Tab
	**************************************************************************/
	
	private void setFinancesTab() {
		
		tabbedFrame.add("Finances", financesTab);
		
	}
	
	/*************************************************************************
								Inventory Tab
	 **************************************************************************/
	//initalizes top Panel Data
	
	private void setInventoryTab() {
		
		//initalize top panel coponents
		inventoryp1 = new JPanel();
		
		//initalize bottome panel comnponenets
		inventoryp2 = new JPanel();
		inventoryp2.setLayout(new GridLayout(2, 3));
		productMenu = new JComboBox();
		amountLabel = new JLabel("Amount: ");
		amountInput = new JTextField();
		orderButton = new JButton("Order");
		orderButton.addActionListener(new OrderButtonListener());
		
		//adding to the combobox
		for(Product p: data.getInventoryFromDB()){
			productMenu.addItem(p);
		}
		
		inventoryTable = new JTable(getInventory2dArray(), getColumnNames());
		inventoryTable.setPreferredScrollableViewportSize(new Dimension(500,500));
		inventoryTable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(inventoryTable);
		add(scrollPane);
		
		inventoryp1.add(inventoryTable);
		
		inventoryp2.add(productMenu);
		inventoryp2.add(amountLabel);
		inventoryp2.add(amountInput);
		inventoryp2.add(new JLabel());
		inventoryp2.add(orderButton);
		inventoryp2.add(new JLabel());
		
		mainInventoryPanel.add(inventoryp1);
		mainInventoryPanel.add(inventoryp2);
		
		tabbedFrame.add("Inventory", mainInventoryPanel);
	}
	
	public String[][] getInventory2dArray(){
		
		String[][] inventory = new String[data.getInventoryFromDB().size()][3];
		
		mainInventoryPanel.setLayout(new GridLayout(2,1));
		
		for(int i = 0; i < inventory.length; i++){
			inventory[i][0] = data.getInventoryFromDB().get(i).getName();
			inventory[i][1] = ""+data.getInventoryFromDB().get(i).getPrice();
			inventory[i][2] = ""+data.getInventoryFromDB().get(i).getAmountInStock();
		}
		
		return inventory;
	}

	public String[] getColumnNames(){
		String[] columnNames = {"Product","Price","Quantity"};
		return columnNames;
	}
	/*************************************************************************
								Employee Tab
	 **************************************************************************/
	
	private void setEmployeeTab() {
		
		//initalize Employee componenets
		mainEmployeePanel = new JPanel();
		mainEmployeePanel.setLayout(new BorderLayout());
		employeep1 = new JPanel();
		employeep1.setLayout(new BoxLayout(employeep1, BoxLayout.Y_AXIS));
		employeep2 = new JPanel();
		empListLabel = new JLabel("Employee List");
		model = new DefaultListModel();
		employeeList = new JList(model); //Arg String[]
		taskLabel = new JLabel("Employee Task List");
		taskModel = new DefaultListModel();
		empTask = new JList(taskModel);
		
		addTaskButton = new JButton("Add Task");
		addTaskButton.addActionListener(new AddTaskListener());
		addEmployeeButton = new JButton("Add Employee");
		addEmployeeButton.addActionListener(new AddEmployeeListener());
		
		for(int i = 0; i < data.getEmployeesArrayList().size(); i++){
			model.addElement(data.getEmployeesArrayList().get(i));
		}

		employeeList.setVisibleRowCount(data.getUsers().size());
		employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(employeeList));
		
		employeeList.addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent event){
				taskModel.clear();
				
				//update employee's displayed tasks
				ArrayList<Task> tList =  ((Employee) employeeList.getSelectedValue()).getTaskList();
				for(Task t: tList){
					taskModel.addElement(t);
				}
			}
		});
		
		employeep1.add(empListLabel);
		employeep1.add(employeeList);
		employeep1.add(addTaskButton);
		employeep1.add(addEmployeeButton);
		
		employeep2.add(taskLabel);
		employeep2.add(empTask);
		
		mainEmployeePanel.add(employeep1, BorderLayout.WEST);
		mainEmployeePanel.add(employeep2, BorderLayout.EAST);
		tabbedFrame.add("Employees", mainEmployeePanel);
	}
	
	/*********************************************************
	 					Button Listeners
	 *********************************************************/
	
	//OrderButtonListener
	public class OrderButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Product desiredProduct = (Product) productMenu.getSelectedItem();
			desiredProduct.add(Integer.parseInt(amountInput.getText()));
			tabbedFrame.repaint();
		}
		
	}
	
	//Add Task Button Listener
	public class AddTaskListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String n1 = JOptionPane.showInputDialog("Enter Task Description: ");
			int i = ((Employee) (employeeList.getSelectedValue())).getIdNum();
			
			((Employee) (employeeList.getSelectedValue())).addTask(new Task(n1, i));
			
			taskModel.clear();
			
			//update employee's displayed tasks
			ArrayList<Task> tList =  ((Employee) employeeList.getSelectedValue()).getTaskList();
			for(Task t: tList){
				taskModel.addElement(t);
			}
			
		}
		
	}
	
	//Add Employee Button Listener
	public class AddEmployeeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String n1 = JOptionPane.showInputDialog("Enter Name: ");
			String n2 = JOptionPane.showInputDialog("Compnay Name: ");
			String n3 = JOptionPane.showInputDialog("Input Desired Username: ");
			String n4 = JOptionPane.showInputDialog("Input Password: ");
			int i = Integer.parseInt(JOptionPane.showInputDialog("Input Employee ID Number: "));
			
			Employee emp = new Employee(n1, n3, n4, n2, i);
			
			data.getUsers().add(emp);
			
			model.addElement(emp);
			
		}
		
	}
	
}
