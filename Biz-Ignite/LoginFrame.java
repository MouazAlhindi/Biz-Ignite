import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class LoginFrame extends JFrame{
	
	//Field
	private DataBase data;
	
	//Fields
	private JPanel mainPanel;
	private JLabel userName;
	private JTextField userNameInput;
	private JLabel password;
	private JTextField passwordInput;
	private JButton loginButton;
	private JButton signupButton;
	
	//Constructor
	public LoginFrame(DataBase d){
		//Refrence to database
		this.data = d;
		
		//JComponements for Login Frame
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 2));
		userName = new JLabel("User Name: ");
		userNameInput = new JTextField();
		password = new JLabel("Password: ");
		passwordInput = new JTextField();
		loginButton = new JButton("Login");
		loginButton.addActionListener(new LoginButtonListener());
		signupButton = new JButton("SignUp");
		signupButton.addActionListener(new SignupButtonListener());
		
		//Add jcomponents to the frame
		mainPanel.add(userName);
		mainPanel.add(userNameInput);
		mainPanel.add(password);
		mainPanel.add(passwordInput);
		mainPanel.add(loginButton);
		mainPanel.add(signupButton);
		add(mainPanel);
		
		//Setup JFrame
		setTitle("Biz Ignite Login");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		
		
	}
	
	//Methods
	public void authenticateUser(){
		ArrayList<User> uList = data.getUsers();
		boolean found = false;					// added boolean to check if account is found
		
		for(User u: uList){
			if(userNameInput.getText().equals(u.getUserName()) && passwordInput.getText().equals(u.getPassword()) && u.getClearance() == true){
				//Manager Frame will be opened and login frame will be closed
				System.out.println("Start Manager Frame");
				found = true;
			} else if (userNameInput.getText().equals(u.getUserName()) && passwordInput.getText().equals(u.getPassword()) && u.getClearance() == false){
				//Employee Frame will be opened and login frame will be close
				System.out.println("Start Employee Frame");
				found = true;
			}
		}
		//only occurs if an account match is not found
		if(!found){
			
			System.out.println("Failed Login");
			JOptionPane.showMessageDialog(null, "Invalid Username or Password.\nTry Again!");
			userNameInput.setText("");
			passwordInput.setText("");
		}		
	}
	
	// Login Button Listener
	public class LoginButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			authenticateUser();
			System.out.println("Someone is trying to login");
		}
	}
	
	//Signup Button Listener
	public class SignupButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			String n1 = JOptionPane.showInputDialog("Enter Name: ");
			String n2 = JOptionPane.showInputDialog("Input Desired Username: ");
			String n3 = JOptionPane.showInputDialog("Input Password: ");
			
			data.getUsers().add(new Manager(n1, n2, n3));
			
			//Console Data
			ArrayList<User> temp = data.getUsers();
			for(int i = 0; i < temp.size(); i++){
				System.out.println(temp.get(i));
			}
			
		}
	}
	
}
