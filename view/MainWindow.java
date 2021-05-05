package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
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
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class MainWindow extends JFrame implements ActionListener{

	private Worker worker;
	private WorkerManager workerManager;
	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordFieldLogin;
	private Object btnLogin;

	public MainWindow() {
		super("Fullscreen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/resources/Logo.png")));
		setTitle("Arpore");
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/Logo.png")));
		lblLogo.setBounds(232, 377, 320, 185);
		contentPane.add(lblLogo);
		
		JLabel lblArpore = new JLabel("Arpore");
		lblArpore.setForeground(Color.DARK_GRAY);
		lblArpore.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
		lblArpore.setBounds(164, 531, 408, 121);
		contentPane.add(lblArpore);
		
		JPanel panelGreyLoginBackground = new JPanel();
		panelGreyLoginBackground.setBorder(UIManager.getBorder("Button.border"));
		panelGreyLoginBackground.setBackground(new Color(51, 51, 51));
		panelGreyLoginBackground.setBounds(1095, 364, 496, 307);
		contentPane.add(panelGreyLoginBackground);
		panelGreyLoginBackground.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tunga", Font.BOLD, 17));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(48, 108, 98, 34);
		panelGreyLoginBackground.add(lblPassword);
		
		textUser = new JTextField();
		textUser.setBounds(156, 55, 282, 29);
		textUser.setColumns(10);
		panelGreyLoginBackground.add(textUser);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Tunga", Font.BOLD, 17));
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(SystemColor.windowBorder);
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(63, 50, 83, 42);
		panelGreyLoginBackground.add(lblUser);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorderPainted(false);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.GRAY);
		btnLogin.setFont(new Font("Tunga", Font.BOLD, 17));
		btnLogin.setBounds(340, 221, 98, 34);
		panelGreyLoginBackground.add(btnLogin);
		
		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setBounds(156, 109, 282, 29);
		panelGreyLoginBackground.add(passwordFieldLogin);
		
		JLabel lblBackgroundLogin = new JLabel("");
		lblBackgroundLogin.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/FondoLogin.jpg")));
		lblBackgroundLogin.setBounds(0, 0, 1920, 1062);
		contentPane.add(lblBackgroundLogin);
		this.setExtendedState(MAXIMIZED_BOTH);
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
