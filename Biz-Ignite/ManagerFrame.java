import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.*;

public class ManagerFrame extends JFrame{

	private JTabbedPane tabbedFrame= new JTabbedPane();
	
	private JPanel employeeNames = new JPanel();
	private JPanel employeeTasks = new JPanel();
	private JPanel inventoryTab = new JPanel();
	private JPanel financesTab = new JPanel();
	
	private JTable inventoryIable = new JTable();
	
	private DataBase data;
	
	private JList employeeList;
	
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

	private void setFinancesTab() {
		
		tabbedFrame.add("Finances", financesTab);
		
	}

	private void setInventoryTab() {
		
		String[] columnNames = {"Product","Price","Quantity"};
		String[][] inventory = new String[data.getInventoryFromDB().size()][3];
		
		for(int i = 0; i < inventory.length; i++){
			
			inventory[i][0] = data.getInventoryFromDB().get(i).getName();
			inventory[i][1] = ""+data.getInventoryFromDB().get(i).getPrice();
			inventory[i][2] = ""+data.getInventoryFromDB().get(i).getAmountInStock();
			
		}
		
		inventoryIable = new JTable(inventory, columnNames);
		inventoryIable.setPreferredScrollableViewportSize(new Dimension(500,500));
		inventoryIable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(inventoryIable);
		add(scrollPane);
		
		inventoryTab.add(inventoryIable);
		tabbedFrame.add("Inventory", inventoryTab);
	}

	private void setEmployeeTab() {
		
		employeeList = new JList(data.getUsersArray());
		employeeList.setVisibleRowCount(data.getUsers().size());
		employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(employeeList));
		
		employeeList.addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent event){
				
				//update employee's displayed tasks.
			}
		});
		
		employeeNames.add(employeeList);
		tabbedFrame.add("Employees", employeeNames);
	}
	
}
