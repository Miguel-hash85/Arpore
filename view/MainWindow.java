package view;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AdminManager;
import model.BuyerManager;
import model.WorkerManager;
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

	
	
	/**
	 *  Hola
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textUser;
	private static JPasswordField passwordFieldLogin;
	private JButton btnLogin;
	private BuyerManager buyerManager;
	private WorkerManager workerManager;
	private AdminManager adminManager;

	public MainWindow(AdminManager adminManager, WorkerManager workerManager, BuyerManager buyerManager) {
		super("Fullscreen");
		this.buyerManager = buyerManager;
		this.workerManager = workerManager;
		this.adminManager = adminManager;
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/resources/Logo43x43.png")));
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
		panelGreyLoginBackground.setBounds(1085, 364, 506, 307);
		contentPane.add(panelGreyLoginBackground);
		panelGreyLoginBackground.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tunga", Font.BOLD, 17));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(48, 108, 98, 34);
		panelGreyLoginBackground.add(lblPassword);
		
		textUser = new JTextField();
		textUser.setToolTipText("(El usuario sera su DNI)");
		textUser.setBounds(156, 55, 282, 29);
		panelGreyLoginBackground.add(textUser);
		textUser.setColumns(10);

		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Tunga", Font.BOLD, 17));
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(Color.WHITE);
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(63, 50, 83, 42);
		panelGreyLoginBackground.add(lblUser);
		
		btnLogin = new JButton("Login");
		btnLogin.setBorderPainted(false);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.GRAY);
		btnLogin.setFont(new Font("Tunga", Font.BOLD, 17));
		btnLogin.setBounds(340, 221, 98, 34);
		btnLogin.addActionListener(this);
		panelGreyLoginBackground.add(btnLogin);
		
		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setBounds(156, 109, 282, 29);
		panelGreyLoginBackground.add(passwordFieldLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/InfoLogo.png")));
		lblNewLabel.setToolTipText("(El usuario sera su DNI)");
		lblNewLabel.setBounds(448, 55, 14, 14);
		panelGreyLoginBackground.add(lblNewLabel);
		
		JLabel lblBackgroundLogin = new JLabel("");
		lblBackgroundLogin.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/FondoLogin.jpg")));
		lblBackgroundLogin.setBounds(0, 0, 1920, 1062);
		contentPane.add(lblBackgroundLogin);
		this.setExtendedState(MAXIMIZED_BOTH);
	}

	
	/*
	 * En esta parte del codigo, controlamos el tipo de usuario que está intentando iniciar sesión
	 * para generar la ventana que proceda.
	 * 
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean esta=false;
		try {
			if(buyerManager.getBuyer(textUser.getText(),passwordFieldLogin.getText())){
				BuyerWindow buyerWindow=new BuyerWindow(buyerManager, textUser.getText());
				buyerWindow.setVisible(true);
				esta=true;
			}else if(workerManager.getWorker(textUser.getText(), passwordFieldLogin.getText())) {
				WorkerWindow workerWindow = new WorkerWindow(workerManager, textUser.getText());
				workerWindow.setVisible(true);
				esta = true;
			}else if(adminManager.getAdmin(textUser.getText(), passwordFieldLogin.getText())) {
				AdminWindow adminWindow = new AdminWindow(adminManager, textUser.getText());
				adminWindow.setVisible(true);
				esta = true;
			}
			if(!esta)
				JOptionPane.showMessageDialog(this, "Usuario no encontrado");
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(this, "Longitud incorrecta");
			e1.printStackTrace();
		}
			
		
	}
	public static void clean() {
		passwordFieldLogin.setText("");
		textUser.setText("");
	}

}