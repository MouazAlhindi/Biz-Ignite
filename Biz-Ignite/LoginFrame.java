import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginFrame extends JFrame{
	
	//Fields
	private JPanel mainPanel;
	private JLabel userName;
	private JTextField userNameInput;
	private JLabel password;
	private JTextField passwordInput;
	private JButton loginButton;
	
	//Constructor
	public LoginFrame(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 3));
		userName = new JLabel("User Name: ");
		userNameInput = new JTextField();
		password = new JLabel("Password: ");
		passwordInput = new JTextField();
		loginButton = new JButton("Login");
		loginButton.addActionListener(new LoginButtonListener());
		
		//Add jcomponents to the frame
		add(mainPanel);
		add(userName);
		add(userNameInput);
		add(password);
		add(passwordInput);
		add(loginButton);
		
		
	}
	//Methods
	
	
	//ButtonListener
	public class LoginButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
