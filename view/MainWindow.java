package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Worker;
import model.WorkerManager;
import model.WorkerManagerMySQLImplementation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.Font;

public class MainWindow extends JFrame implements ActionListener{

	private Worker worker;
	private WorkerManager workerManager;
	private JPanel contentPane;
	private JTextField textFieldUser;
	private JTextField textFieldPassword;
	private JButton btnLogin;
	private JLabel lblBackground;
	private JLabel lblbehindLoginContent;

	public MainWindow() {
		super("Fullscreen");
	    getContentPane().setPreferredSize( Toolkit.getDefaultToolkit().getScreenSize());
	    pack();
	    show();

	    SwingUtilities.invokeLater(new Runnable() {
	      public void run()
	      {
	        Point p = new Point(0, 0);
	        SwingUtilities.convertPointToScreen(p, getContentPane());
	        Point l = getLocation();
	        l.x -= p.x;
	        l.y -= p.y;
	        setLocation(l);
	      }
	    });
		this.setExtendedState(MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/Logo.png")));
		setTitle("Arpore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1622, 1017);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 13));
		lblUser.setForeground(SystemColor.text);
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(1343, 497, 56, 37);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 13));
		lblPassword.setForeground(SystemColor.text);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(1326, 545, 73, 37);
		contentPane.add(lblPassword);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(1409, 504, 157, 23);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(1409, 552, 157, 23);
		contentPane.add(textFieldPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 11));
		btnLogin.setBounds(1484, 618, 82, 23);
		contentPane.add(btnLogin);
		
		lblbehindLoginContent = new JLabel("");
		lblbehindLoginContent.setIcon(new ImageIcon(MainWindow.class.getResource("/images/Yey.png (4).png")));
		lblbehindLoginContent.setOpaque(true);
		lblbehindLoginContent.setBackground(Color.BLACK);
		lblbehindLoginContent.setBounds(1199, 437, 483, 271);
		contentPane.add(lblbehindLoginContent);
		
		lblBackground = new JLabel("");
		lblBackground.setBackground(SystemColor.desktop);
		lblBackground.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/images/FondoLoginPreuba.jpg")));
		lblBackground.setBounds(0, 0, 1920, 1072);
		contentPane.add(lblBackground);
		btnLogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnLogin)) {
			login(workerManager);
		}
		
	}

	private void login(WorkerManager workerManager) {
		try {
			workerManager = new WorkerManagerMySQLImplementation();
			workerManager.addObject(workerManager);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),"Error al abrir la conexión", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
