package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUser;
	private JTextField textFieldPassword;

	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(74, 40, 62, 37);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(74, 96, 62, 37);
		contentPane.add(lblPassword);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(174, 48, 157, 29);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(174, 104, 157, 29);
		contentPane.add(textFieldPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(170, 186, 89, 23);
		contentPane.add(btnLogin);
	}
}
