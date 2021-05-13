package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.AdminManager;
import model.Worker;
import model.WorkerManager;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JMenu;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.time.LocalDate;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Panel;

public class AdminWindow extends JDialog implements ActionListener, FocusListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelTop;
	private JMenu mnUserMenu;
	private JMenuItem mntmNewMenuItem;
	private JTextField textId_userAdd;
	private JTextField textSocialSecurityNumberAdd;
	private JTextField textAddressAdd;
	private JTextField textTelephoneAdd;
	private JTextField textEmailAdd;
	private JTextField textSurnameAdd;
	private JTextField textNameAdd;
	private JButton btnCleanAdd;
	private JButton btnAcceptAdd;
	private static AdminManager adminManager;
	private static WorkerManager workerManager;
	private JPasswordField passwordFieldAdd;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JPasswordField passwordField_1;
	private String id_admin;

	public AdminWindow(AdminManager adminManager, String id_admin) {
		this.id_admin=id_admin;
		// Propia ventana
		setTitle("Admin Window");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		setModal(true);
		this.adminManager = adminManager;
		this.setSize(this.getToolkit().getScreenSize());

		// ---- ENCABEZADO ----
		// Panel en la parte de arriba con el logo nombre y usuario
		panelTop = new JPanel();
		panelTop.setBounds(0, 0, 1920, 66);
		panelTop.setBackground(Color.WHITE);
		getContentPane().add(panelTop);
		panelTop.setLayout(null);

		// logo arriba a la izquierda
		JLabel lblLogo43x43 = new JLabel("");
		lblLogo43x43.setIcon(new ImageIcon(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		lblLogo43x43.setBounds(23, 11, 43, 43);
		panelTop.add(lblLogo43x43);

		// Nombre empresa arriba izquierda
		JLabel lblNewLabel = new JLabel("Arpore");
		lblNewLabel.setBounds(76, 17, 187, 36);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 34));
		panelTop.add(lblNewLabel);

		// Menu usuario
		mnUserMenu = new JMenu("Admin");
		mnUserMenu.setSelectedIcon(new ImageIcon(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		mnUserMenu.setRolloverSelectedIcon(new ImageIcon(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		mnUserMenu.setIconTextGap(11);
		mnUserMenu.setIcon(new ImageIcon(AdminWindow.class.getResource("/resources/AdminLogo.png")));
		mnUserMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mnUserMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		mnUserMenu.setDelay(0);
		mnUserMenu.setBounds(1723, 11, 170, 43);
		panelTop.add(mnUserMenu);

		// PopUp desde Menu usuario
		mntmNewMenuItem = new JMenuItem("Log out");
		mntmNewMenuItem.setIcon(new ImageIcon(AdminWindow.class.getResource("/resources/Logout.png")));
		mntmNewMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnUserMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);

		// ---- PARTE INFERIOR ----
		// Creamos el conjunto de pestañas
		JTabbedPane tabWorker = new JTabbedPane();
		tabWorker.setBounds(0, 66, 1920, 1041);
		tabWorker.setOpaque(true);
		tabWorker.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabWorker.setBackground(new Color(204, 204, 204));
		tabWorker.getWidth();
		getContentPane().setLayout(null);

		// Pestaña Worker
		JTabbedPane tabGRUB = new JTabbedPane();
		tabGRUB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabGRUB.setOpaque(true);
		tabGRUB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabGRUB.setAlignmentY(10.0f);
		tabGRUB.setAlignmentX(10.0f);
		tabGRUB.setMinimumSize(new Dimension(90, 5));
		tabGRUB.setPreferredSize(new Dimension(60, 5));
		tabGRUB.setBounds(new Rectangle(0, 40, 1904, 1042));
		tabGRUB.setBackground(new Color(204, 204, 204));
		tabWorker.addTab("Worker", null, tabGRUB, "");
		getContentPane().add(tabWorker);

		// Nombres de las pestañas con JPanel en el interior de cada uno, donde añadir
		// tablas datos etc.
		JPanel panelAdd = new JPanel();
		panelAdd.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabGRUB.addTab("Alta", null, panelAdd, null);
		panelAdd.setLayout(null);

		// Datos personales
		JPanel panelProfile = new JPanel();
		panelProfile.setBackground(Color.WHITE);
		panelProfile.setLayout(null);

		// Panel para recogerlos
		JPanel panelOrderAdd = new JPanel();
		panelOrderAdd.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelOrderAdd.setBounds(95, 38, 1103, 653);
		panelAdd.add(panelOrderAdd);
		panelOrderAdd.setLayout(null);

		JLabel lblProfile = new JLabel("Datos Personales");
		lblProfile.setBounds(47, 47, 870, 31);
		panelOrderAdd.add(lblProfile);
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setOpaque(true);
		lblProfile.setBackground(new Color(204, 204, 204));
		lblProfile.setFont(new Font("Verdana", Font.PLAIN, 22));

		JLabel lblId_userAdd = new JLabel("DNI:");
		lblId_userAdd.setBounds(47, 118, 91, 31);
		panelOrderAdd.add(lblId_userAdd);
		lblId_userAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_userAdd.setOpaque(true);
		lblId_userAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textId_userAdd = new JTextField();
		textId_userAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textId_userAdd.setBounds(148, 118, 290, 31);
		panelOrderAdd.add(textId_userAdd);
		textId_userAdd.setOpaque(true);
		textId_userAdd.setColumns(10);
		textId_userAdd.setBackground(new Color(204, 204, 204));
		
		JLabel lblSocialSecurityNumberAdd = new JLabel("NUSS:");
		lblSocialSecurityNumberAdd.setOpaque(true);
		lblSocialSecurityNumberAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSocialSecurityNumberAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSocialSecurityNumberAdd.setBounds(467, 118, 91, 31);
		panelOrderAdd.add(lblSocialSecurityNumberAdd);
		
		textSocialSecurityNumberAdd = new JTextField();
		textSocialSecurityNumberAdd.setOpaque(true);
		textSocialSecurityNumberAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textSocialSecurityNumberAdd.setColumns(10);
		textSocialSecurityNumberAdd.setBackground(new Color(204, 204, 204));
		textSocialSecurityNumberAdd.setBounds(568, 118, 290, 31);
		panelOrderAdd.add(textSocialSecurityNumberAdd);

		JLabel lblNameAdd = new JLabel("Nombre:");
		lblNameAdd.setBounds(47, 198, 91, 31);
		panelOrderAdd.add(lblNameAdd);
		lblNameAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textNameAdd = new JTextField();
		textNameAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNameAdd.setBounds(148, 198, 290, 31);
		panelOrderAdd.add(textNameAdd);
		textNameAdd.setOpaque(true);
		textNameAdd.setColumns(10);
		textNameAdd.setBackground(new Color(204, 204, 204));

		JLabel lblSurnameAdd = new JLabel("Apellido:");
		lblSurnameAdd.setBounds(467, 198, 91, 31);
		panelOrderAdd.add(lblSurnameAdd);
		lblSurnameAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurnameAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textSurnameAdd = new JTextField();
		textSurnameAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textSurnameAdd.setBounds(568, 258, 290, 31);
		panelOrderAdd.add(textSurnameAdd);
		textSurnameAdd.setOpaque(true);
		textSurnameAdd.setColumns(10);
		textSurnameAdd.setBackground(new Color(204, 204, 204));

		JLabel lblEmailAdd = new JLabel("Email:");
		lblEmailAdd.setBounds(47, 258, 91, 31);
		panelOrderAdd.add(lblEmailAdd);
		lblEmailAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textEmailAdd = new JTextField();
		textEmailAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEmailAdd.setBounds(148, 258, 290, 31);
		panelOrderAdd.add(textEmailAdd);
		textEmailAdd.setOpaque(true);
		textEmailAdd.setColumns(10);
		textEmailAdd.setBackground(new Color(204, 204, 204));

		JLabel lblTelephoneAdd = new JLabel("Tel\u00E9fono:");
		lblTelephoneAdd.setBounds(467, 258, 91, 31);
		panelOrderAdd.add(lblTelephoneAdd);
		lblTelephoneAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephoneAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textTelephoneAdd = new JTextField();
		textTelephoneAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTelephoneAdd.setBounds(568, 198, 290, 31);
		panelOrderAdd.add(textTelephoneAdd);
		textTelephoneAdd.setOpaque(true);
		textTelephoneAdd.setColumns(10);
		textTelephoneAdd.setBackground(new Color(204, 204, 204));

		JLabel lblAddressAdd = new JLabel("Direcci\u00F3n:");
		lblAddressAdd.setBounds(47, 318, 91, 31);
		panelOrderAdd.add(lblAddressAdd);
		lblAddressAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddressAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textAddressAdd = new JTextField();
		textAddressAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAddressAdd.setBounds(148, 318, 290, 31);
		panelOrderAdd.add(textAddressAdd);
		textAddressAdd.setOpaque(true);
		textAddressAdd.setColumns(10);
		textAddressAdd.setBackground(new Color(204, 204, 204));

		JLabel lblContraseaAdd = new JLabel("Contrase\u00F1a:");
		lblContraseaAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseaAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseaAdd.setBounds(47, 378, 91, 31);
		panelOrderAdd.add(lblContraseaAdd);

		passwordFieldAdd = new JPasswordField();
		passwordFieldAdd.setBackground(new Color(204, 204, 204));
		passwordFieldAdd.setColumns(10);
		passwordFieldAdd.setBounds(147, 378, 291, 31);
		panelOrderAdd.add(passwordFieldAdd);

		btnCleanAdd = new JButton("Limpiar");
		btnCleanAdd.setForeground(Color.WHITE);
		btnCleanAdd.setFont(new Font("Tunga", Font.BOLD, 17));
		btnCleanAdd.setBorderPainted(false);
		btnCleanAdd.setBackground(Color.GRAY);
		btnCleanAdd.setBounds(648, 476, 98, 34);
		panelOrderAdd.add(btnCleanAdd);

		btnAcceptAdd = new JButton("Aceptar");
		btnAcceptAdd.setForeground(Color.WHITE);
		btnAcceptAdd.setFont(new Font("Tunga", Font.BOLD, 17));
		btnAcceptAdd.setBorderPainted(false);
		btnAcceptAdd.setBackground(Color.GRAY);
		btnAcceptAdd.setBounds(756, 476, 98, 34);
		panelOrderAdd.add(btnAcceptAdd);
		
		Panel panelSeparatePersonal = new Panel();
		panelSeparatePersonal.setBackground(Color.DARK_GRAY);
		panelSeparatePersonal.setBounds(47, 171, 870, 1);
		panelOrderAdd.add(panelSeparatePersonal);
		btnAcceptAdd.addActionListener(this);
		btnCleanAdd.addActionListener(this);
		
		JPanel panelDelete = new JPanel();
		panelDelete.setLayout(null);
		tabGRUB.addTab("New tab", null, panelDelete, null);
		
		JPanel panelOrderDelete = new JPanel();
		panelOrderDelete.setLayout(null);
		panelOrderDelete.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelOrderDelete.setBounds(95, 38, 1103, 653);
		panelDelete.add(panelOrderDelete);
		
		JLabel lblProfile_2 = new JLabel("Datos Personales");
		lblProfile_2.setOpaque(true);
		lblProfile_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile_2.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblProfile_2.setBackground(new Color(204, 204, 204));
		lblProfile_2.setBounds(47, 47, 870, 31);
		panelOrderDelete.add(lblProfile_2);
		
		JLabel lblId_userAdd_2 = new JLabel("DNI:");
		lblId_userAdd_2.setOpaque(true);
		lblId_userAdd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_userAdd_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId_userAdd_2.setBounds(47, 118, 91, 31);
		panelOrderDelete.add(lblId_userAdd_2);
		
		textField_6 = new JTextField();
		textField_6.setOpaque(true);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(204, 204, 204));
		textField_6.setBounds(148, 118, 290, 31);
		panelOrderDelete.add(textField_6);
		
		JLabel lblNameAdd_2 = new JLabel("Nombre:");
		lblNameAdd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameAdd_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameAdd_2.setBounds(47, 198, 91, 31);
		panelOrderDelete.add(lblNameAdd_2);
		
		textField_7 = new JTextField();
		textField_7.setOpaque(true);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(204, 204, 204));
		textField_7.setBounds(148, 198, 290, 31);
		panelOrderDelete.add(textField_7);
		
		JLabel lblSurnameAdd_2 = new JLabel("Apellido:");
		lblSurnameAdd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurnameAdd_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurnameAdd_2.setBounds(467, 198, 91, 31);
		panelOrderDelete.add(lblSurnameAdd_2);
		
		textField_8 = new JTextField();
		textField_8.setOpaque(true);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(204, 204, 204));
		textField_8.setBounds(568, 258, 290, 31);
		panelOrderDelete.add(textField_8);
		
		JLabel lblEmailAdd_2 = new JLabel("Email:");
		lblEmailAdd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAdd_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailAdd_2.setBounds(47, 258, 91, 31);
		panelOrderDelete.add(lblEmailAdd_2);
		
		textField_9 = new JTextField();
		textField_9.setOpaque(true);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_9.setColumns(10);
		textField_9.setBackground(new Color(204, 204, 204));
		textField_9.setBounds(148, 258, 290, 31);
		panelOrderDelete.add(textField_9);
		
		JLabel lblTelephoneAdd_2 = new JLabel("Tel\u00E9fono:");
		lblTelephoneAdd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephoneAdd_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelephoneAdd_2.setBounds(467, 258, 91, 31);
		panelOrderDelete.add(lblTelephoneAdd_2);
		
		textField_10 = new JTextField();
		textField_10.setOpaque(true);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(204, 204, 204));
		textField_10.setBounds(568, 198, 290, 31);
		panelOrderDelete.add(textField_10);
		
		JLabel lblAddressAdd_2 = new JLabel("Direcci\u00F3n:");
		lblAddressAdd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddressAdd_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddressAdd_2.setBounds(47, 318, 91, 31);
		panelOrderDelete.add(lblAddressAdd_2);
		
		textField_11 = new JTextField();
		textField_11.setOpaque(true);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_11.setColumns(10);
		textField_11.setBackground(new Color(204, 204, 204));
		textField_11.setBounds(148, 318, 290, 31);
		panelOrderDelete.add(textField_11);
		
		JLabel lblContraseaAdd_2 = new JLabel("Contrase\u00F1a:");
		lblContraseaAdd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseaAdd_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseaAdd_2.setBounds(47, 378, 91, 31);
		panelOrderDelete.add(lblContraseaAdd_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		passwordField_1.setBackground(new Color(204, 204, 204));
		passwordField_1.setBounds(147, 378, 291, 31);
		panelOrderDelete.add(passwordField_1);
		
		JButton btnCleanAdd_2 = new JButton("Limpiar");
		btnCleanAdd_2.setForeground(Color.WHITE);
		btnCleanAdd_2.setFont(new Font("Tunga", Font.BOLD, 17));
		btnCleanAdd_2.setBorderPainted(false);
		btnCleanAdd_2.setBackground(Color.GRAY);
		btnCleanAdd_2.setBounds(648, 476, 98, 34);
		panelOrderDelete.add(btnCleanAdd_2);
		
		JButton btnAcceptAdd_2 = new JButton("Aceptar");
		btnAcceptAdd_2.setForeground(Color.WHITE);
		btnAcceptAdd_2.setFont(new Font("Tunga", Font.BOLD, 17));
		btnAcceptAdd_2.setBorderPainted(false);
		btnAcceptAdd_2.setBackground(Color.GRAY);
		btnAcceptAdd_2.setBounds(756, 476, 98, 34);
		panelOrderDelete.add(btnAcceptAdd_2);
		
		Panel panelSeparatePersonal_2 = new Panel();
		panelSeparatePersonal_2.setBackground(Color.DARK_GRAY);
		panelSeparatePersonal_2.setBounds(47, 171, 870, 1);
		panelOrderDelete.add(panelSeparatePersonal_2);

		// Pestaña modificar
		JPanel panelModify = new JPanel();
		panelModify.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabGRUB.addTab("Modificar", null, panelModify, null);
		panelModify.setLayout(null);
		
		JPanel panelOrderModify = new JPanel();
		panelOrderModify.setLayout(null);
		panelOrderModify.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelOrderModify.setBounds(95, 38, 1103, 653);
		panelModify.add(panelOrderModify);
		
		JLabel lblProfile_1 = new JLabel("Datos Personales");
		lblProfile_1.setOpaque(true);
		lblProfile_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile_1.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblProfile_1.setBackground(new Color(204, 204, 204));
		lblProfile_1.setBounds(47, 47, 870, 31);
		panelOrderModify.add(lblProfile_1);
		
		JLabel lblId_userAdd_1 = new JLabel("DNI:");
		lblId_userAdd_1.setOpaque(true);
		lblId_userAdd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_userAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId_userAdd_1.setBounds(47, 118, 91, 31);
		panelOrderModify.add(lblId_userAdd_1);
		
		textField = new JTextField();
		textField.setOpaque(true);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBackground(new Color(204, 204, 204));
		textField.setBounds(148, 118, 290, 31);
		panelOrderModify.add(textField);
		
		JLabel lblNameAdd_1 = new JLabel("Nombre:");
		lblNameAdd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameAdd_1.setBounds(47, 198, 91, 31);
		panelOrderModify.add(lblNameAdd_1);
		
		textField_1 = new JTextField();
		textField_1.setOpaque(true);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(204, 204, 204));
		textField_1.setBounds(148, 198, 290, 31);
		panelOrderModify.add(textField_1);
		
		JLabel lblSurnameAdd_1 = new JLabel("Apellido:");
		lblSurnameAdd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurnameAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurnameAdd_1.setBounds(467, 198, 91, 31);
		panelOrderModify.add(lblSurnameAdd_1);
		
		textField_2 = new JTextField();
		textField_2.setOpaque(true);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(204, 204, 204));
		textField_2.setBounds(568, 258, 290, 31);
		panelOrderModify.add(textField_2);
		
		JLabel lblEmailAdd_1 = new JLabel("Email:");
		lblEmailAdd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailAdd_1.setBounds(47, 258, 91, 31);
		panelOrderModify.add(lblEmailAdd_1);
		
		textField_3 = new JTextField();
		textField_3.setOpaque(true);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(204, 204, 204));
		textField_3.setBounds(148, 258, 290, 31);
		panelOrderModify.add(textField_3);
		
		JLabel lblTelephoneAdd_1 = new JLabel("Tel\u00E9fono:");
		lblTelephoneAdd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephoneAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelephoneAdd_1.setBounds(467, 258, 91, 31);
		panelOrderModify.add(lblTelephoneAdd_1);
		
		textField_4 = new JTextField();
		textField_4.setOpaque(true);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(204, 204, 204));
		textField_4.setBounds(568, 198, 290, 31);
		panelOrderModify.add(textField_4);
		
		JLabel lblAddressAdd_1 = new JLabel("Direcci\u00F3n:");
		lblAddressAdd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddressAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddressAdd_1.setBounds(47, 318, 91, 31);
		panelOrderModify.add(lblAddressAdd_1);
		
		textField_5 = new JTextField();
		textField_5.setOpaque(true);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(204, 204, 204));
		textField_5.setBounds(148, 318, 290, 31);
		panelOrderModify.add(textField_5);
		
		JLabel lblContraseaAdd_1 = new JLabel("Contrase\u00F1a:");
		lblContraseaAdd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseaAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseaAdd_1.setBounds(47, 378, 91, 31);
		panelOrderModify.add(lblContraseaAdd_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBackground(new Color(204, 204, 204));
		passwordField.setBounds(147, 378, 291, 31);
		panelOrderModify.add(passwordField);
		
		JButton btnCleanAdd_1 = new JButton("Limpiar");
		btnCleanAdd_1.setForeground(Color.WHITE);
		btnCleanAdd_1.setFont(new Font("Tunga", Font.BOLD, 17));
		btnCleanAdd_1.setBorderPainted(false);
		btnCleanAdd_1.setBackground(Color.GRAY);
		btnCleanAdd_1.setBounds(648, 476, 98, 34);
		panelOrderModify.add(btnCleanAdd_1);
		
		JButton btnAcceptAdd_1 = new JButton("Aceptar");
		btnAcceptAdd_1.setForeground(Color.WHITE);
		btnAcceptAdd_1.setFont(new Font("Tunga", Font.BOLD, 17));
		btnAcceptAdd_1.setBorderPainted(false);
		btnAcceptAdd_1.setBackground(Color.GRAY);
		btnAcceptAdd_1.setBounds(756, 476, 98, 34);
		panelOrderModify.add(btnAcceptAdd_1);
		
		Panel panelSeparatePersonal_1 = new Panel();
		panelSeparatePersonal_1.setBackground(Color.DARK_GRAY);
		panelSeparatePersonal_1.setBounds(47, 171, 870, 1);
		panelOrderModify.add(panelSeparatePersonal_1);

		// Pestaña listar
		JPanel panelList = new JPanel();
		panelList.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabGRUB.addTab("Listar", null, panelList, null);
		panelList.setLayout(null);

		JPanel panelOrderList = new JPanel();
		panelOrderList.setLayout(null);
		panelOrderList.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelOrderList.setBounds(95, 38, 1103, 653);
		panelList.add(panelOrderList);

		JButton btnClean_1_1_1 = new JButton("Limpiar");
		btnClean_1_1_1.setForeground(Color.WHITE);
		btnClean_1_1_1.setFont(new Font("Tunga", Font.BOLD, 17));
		btnClean_1_1_1.setBorderPainted(false);
		btnClean_1_1_1.setBackground(Color.GRAY);
		btnClean_1_1_1.setBounds(652, 380, 98, 34);
		panelOrderList.add(btnClean_1_1_1);

	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource().equals(mntmNewMenuItem)) {
			MainWindow.clean();
			this.dispose();
		}
		if (a.getSource().equals(btnAcceptAdd)) {
			alta(adminManager);
		}
		if (a.getSource().equals(btnCleanAdd)) {
			cleanAdd();
		}
	}

	private void alta(AdminManager adminManager) {
		Worker newWorker = new Worker();
		LocalDate workerAddTime = LocalDate.now();
		
		if (textId_userAdd.getText().isEmpty() || textNameAdd.getText().isEmpty() || textSurnameAdd.getText().isEmpty()
				|| textTelephoneAdd.getText().isEmpty() || textAddressAdd.getText().isEmpty()
				|| textEmailAdd.getText().isEmpty() || passwordFieldAdd.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Error, falta algún dato por rellenar", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			try {
				boolean workerFound = adminManager.searchWorker(textId_userAdd.getText());
				if (workerFound==false) {
					newWorker.setsId_user(textId_userAdd.getText());
					newWorker.setsName(textNameAdd.getText());
					newWorker.setsSurname(textSurnameAdd.getText());
					newWorker.setsEmail(textEmailAdd.getText());
					newWorker.setsAddress(textAddressAdd.getText());
					newWorker.setsTelephone(textTelephoneAdd.getText());
					newWorker.setsSocialSecurityNumber(textSocialSecurityNumberAdd.getText());
					//newWorker.setLddate_s_w(workerAddTime);
					newWorker.setsId_admin(id_admin);
					newWorker.setsType_user("worker");
					int accept = JOptionPane.showConfirmDialog(this, "¿Estas seguro en dar de alta a este  usuario?");
					if (accept==0) {
						try {
							adminManager.addWorker(newWorker);
							JOptionPane.showMessageDialog(this, "Trabajador añadido");
						}catch (Exception e){
							JOptionPane.showMessageDialog(this, e.getMessage());
						}
					} else if (accept==1) {
						JOptionPane.showMessageDialog(this, "Propietario no dado de alta");
					}else
						JOptionPane.showMessageDialog(this, "Operación cancelada");
				}else{
					JOptionPane.showMessageDialog(this, "Error, el propietario ya existe", "Usuario duplicado", JOptionPane.WARNING_MESSAGE);
					
				}
				clean();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

	private void clean() {
		
	}

	private void cleanAdd() {
		textId_userAdd.setText("");
		textNameAdd.setText("");
		textSurnameAdd.setText("");
		textEmailAdd.setText("");
		textTelephoneAdd.setText("");
		textAddressAdd.setText("");
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
