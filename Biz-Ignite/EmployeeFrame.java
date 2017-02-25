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
	
	//JComponenets
	private JPanel taskPanel;
	
	private JLabel taskLabel;
	private JTextArea txtBox;
	private JButton completeButton;
	
	
	//Constructor
	public EmployeeFrame(String companyName){
		
		//Initalize componenets
		taskPanel = new JPanel();
		taskPanel.setLayout(new BorderLayout());
		taskLabel = new JLabel("Tasks");
		txtBox = new JTextArea(2, 20);
		completeButton = new JButton("Completed Task");
		completeButton.addActionListener(new CompleteButtonListener());
		
		//Add Componetents to panel and frame
		taskPanel.add(taskLabel, BorderLayout.NORTH);
		taskPanel.add(txtBox, BorderLayout.CENTER);
		taskPanel.add(completeButton, BorderLayout.SOUTH);
		add(taskPanel);
		
		//Frame Setup
		setTitle(companyName);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
	}
	
	//Methods
	
	//ActionListeners
	public class CompleteButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
