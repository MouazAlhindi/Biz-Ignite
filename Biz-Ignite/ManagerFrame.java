import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ManagerFrame extends JFrame{

	private JTabbedPane tabbedFrame= new JTabbedPane();
	
	private JPanel employeeTab = new JPanel();
	private JPanel inventoryTab = new JPanel();
	private JPanel financesTab = new JPanel();
	
	private JTable table = new JTable();
	
	private DataBase data;
	
	private JList<String> list = new JList<String>(data.getUsersArray());
	
	
	public ManagerFrame(DataBase d){
		
		this.data = d;
		
		setEmployeeTab();
		setInventoryTab();
		setFinancesTab();
		
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
		
		table = new JTable(inventory, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,500));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		tabbedFrame.add("Inventory", inventoryTab);
	}

	private void setEmployeeTab() {
		
		list.setVisibleRowCount(data.getUsers().size());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		
		list.addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent event){
				
				//update other list.
			}
		});
		tabbedFrame.add("Employees", employeeTab);
	}
	
}
