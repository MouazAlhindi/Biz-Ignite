import javax.swing.*;

public class ManagerFrame extends JFrame{

	private JTabbedPane tabbedFrame= new JTabbedPane();;
	private JPanel employeeTab = new JPanel();
	private JPanel inventoryTab = new JPanel();
	private JPanel financesTab = new JPanel();
	
	public ManagerFrame(){
		
		tabbedFrame.add("Employees", employeeTab);
		tabbedFrame.add("Inventory", inventoryTab);
		tabbedFrame.add("Finances", financesTab);
		
		add(tabbedFrame);
		setTitle("Manager View");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
	}
}
