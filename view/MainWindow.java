package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AdminManager;
import model.BuyerManager;
import model.BuyerManagerMySQLImplementation;
import model.WorkerManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainWindow extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUser;
	private JTextField textFieldPassword;
	private JButton btnLogin;
	private BuyerManagerMySQLImplementation buyerV;

	public MainWindow(AdminManager adminManager, WorkerManager workerManager, BuyerManager buyerManager) {
		buyerV=(BuyerManagerMySQLImplementation) buyerManager;
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
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(170, 186, 89, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		try {
			if(buyerV.getBuyer(textFieldUser.getText(),textFieldPassword.getText())) 
			{
				BuyerWindow buyerWindow=new BuyerWindow(buyerV);
				buyerWindow.setVisible(true);
			}
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(this, "Error en el campo User");
			e1.printStackTrace();
		}
			
		
	}
}
