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
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JMenu;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class AdminWindow extends JDialog implements ActionListener, FocusListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelTop;
	private JMenu mnUserMenu;
	private JMenuItem mntmNewMenuItem;
	private JTextField textId_userAdd;
	private JTextField textAddressAdd;
	private JTextField textTelephoneAdd;
	private JTextField textEmailAdd;
	private JTextField textSurnameAdd;
	private JTextField textNameAdd;
	private JButton btnCleanAdd;
	private JButton btnAcceptAdd;
	private static AdminManager adminManager;
	private static WorkerManager workerManager;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JPasswordField passwordFieldAdd;

	public AdminWindow(AdminManager adminManager) {
		// Propia ventana
		setTitle("Admin Window");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		setModal(true);
		this.adminManager = adminManager;
		this.setSize(this.getToolkit().getScreenSize());

		// ---- ENCABEZADO ----
		// Panel en la parte de arriba con el logo nombre y usuario
		panelTop = new JPanel();
		panelTop.setBounds(0, 0, 1914, 66);
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
		mnUserMenu.setRolloverSelectedIcon(new ImageIcon(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		mnUserMenu.setIconTextGap(11);
		mnUserMenu.setIcon(new ImageIcon(AdminWindow.class.getResource("/resources/AdminLogo.png")));
		mnUserMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mnUserMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		mnUserMenu.setDelay(0);
		mnUserMenu.setBounds(1713, 11, 170, 43);
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
		tabWorker.setBounds(0, 66, 1914, 1041);
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
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JLabel lblId_userAdd = new JLabel("DNI:");
		lblId_userAdd.setBounds(47, 109, 91, 31);
		panelOrderAdd.add(lblId_userAdd);
		lblId_userAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_userAdd.setOpaque(true);
		lblId_userAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textId_userAdd = new JTextField();
		textId_userAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textId_userAdd.setBounds(148, 109, 290, 31);
		panelOrderAdd.add(textId_userAdd);
		textId_userAdd.setOpaque(true);
		textId_userAdd.setColumns(10);
		textId_userAdd.setBackground(new Color(204, 204, 204));

		JLabel lblNameAdd = new JLabel("Nombre:");
		lblNameAdd.setBounds(47, 169, 91, 31);
		panelOrderAdd.add(lblNameAdd);
		lblNameAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textNameAdd = new JTextField();
		textNameAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNameAdd.setBounds(148, 169, 290, 31);
		panelOrderAdd.add(textNameAdd);
		textNameAdd.setOpaque(true);
		textNameAdd.setColumns(10);
		textNameAdd.setBackground(new Color(204, 204, 204));

		JLabel lblSurnameAdd = new JLabel("Apellido:");
		lblSurnameAdd.setBounds(467, 169, 91, 31);
		panelOrderAdd.add(lblSurnameAdd);
		lblSurnameAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurnameAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textSurnameAdd = new JTextField();
		textSurnameAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textSurnameAdd.setBounds(568, 229, 290, 31);
		panelOrderAdd.add(textSurnameAdd);
		textSurnameAdd.setOpaque(true);
		textSurnameAdd.setColumns(10);
		textSurnameAdd.setBackground(new Color(204, 204, 204));

		JLabel lblEmailAdd = new JLabel("Email:");
		lblEmailAdd.setBounds(47, 229, 91, 31);
		panelOrderAdd.add(lblEmailAdd);
		lblEmailAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textEmailAdd = new JTextField();
		textEmailAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEmailAdd.setBounds(148, 229, 290, 31);
		panelOrderAdd.add(textEmailAdd);
		textEmailAdd.setOpaque(true);
		textEmailAdd.setColumns(10);
		textEmailAdd.setBackground(new Color(204, 204, 204));

		JLabel lblTelephoneAdd = new JLabel("Tel\u00E9fono:");
		lblTelephoneAdd.setBounds(467, 229, 91, 31);
		panelOrderAdd.add(lblTelephoneAdd);
		lblTelephoneAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephoneAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textTelephoneAdd = new JTextField();
		textTelephoneAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTelephoneAdd.setBounds(568, 169, 290, 31);
		panelOrderAdd.add(textTelephoneAdd);
		textTelephoneAdd.setOpaque(true);
		textTelephoneAdd.setColumns(10);
		textTelephoneAdd.setBackground(new Color(204, 204, 204));

		JLabel lblAddressAdd = new JLabel("Direcci\u00F3n:");
		lblAddressAdd.setBounds(47, 289, 91, 31);
		panelOrderAdd.add(lblAddressAdd);
		lblAddressAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddressAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textAddressAdd = new JTextField();
		textAddressAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAddressAdd.setBounds(148, 289, 290, 31);
		panelOrderAdd.add(textAddressAdd);
		textAddressAdd.setOpaque(true);
		textAddressAdd.setColumns(10);
		textAddressAdd.setBackground(new Color(204, 204, 204));

		JLabel lblContraseaAdd = new JLabel("Contrase\u00F1a:");
		lblContraseaAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseaAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseaAdd.setBounds(47, 349, 91, 31);
		panelOrderAdd.add(lblContraseaAdd);

		passwordFieldAdd = new JPasswordField();
		passwordFieldAdd.setBackground(new Color(204, 204, 204));
		passwordFieldAdd.setColumns(10);
		passwordFieldAdd.setBounds(147, 349, 291, 31);
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
		btnAcceptAdd.addActionListener(this);
		btnCleanAdd.addActionListener(this);

		// Pestaña borrar
		JPanel panelDelete = new JPanel();
		panelDelete.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabGRUB.addTab("Baja", null, panelDelete, null);
		panelDelete.setLayout(null);

		JPanel panelOrderDelete = new JPanel();
		panelOrderDelete.setLayout(null);
		panelOrderDelete.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelOrderDelete.setBounds(95, 38, 1103, 521);
		panelDelete.add(panelOrderDelete);

		JLabel lblProfile_1 = new JLabel("Datos Personales");
		lblProfile_1.setOpaque(true);
		lblProfile_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProfile_1.setBackground(new Color(204, 204, 204));
		lblProfile_1.setBounds(47, 47, 870, 31);
		panelOrderDelete.add(lblProfile_1);

		JLabel lblId_user_1 = new JLabel("DNI:");
		lblId_user_1.setOpaque(true);
		lblId_user_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_user_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId_user_1.setBounds(47, 109, 91, 31);
		panelOrderDelete.add(lblId_user_1);

		textField = new JTextField();
		textField.setOpaque(true);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBackground(new Color(204, 204, 204));
		textField.setBounds(148, 109, 290, 31);
		panelOrderDelete.add(textField);

		JLabel lblName_1 = new JLabel("Nombre:");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName_1.setBounds(47, 168, 91, 31);
		panelOrderDelete.add(lblName_1);

		textField_1 = new JTextField();
		textField_1.setOpaque(true);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(204, 204, 204));
		textField_1.setBounds(148, 168, 290, 31);
		panelOrderDelete.add(textField_1);

		JLabel lblSurname_1 = new JLabel("Apellido:");
		lblSurname_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname_1.setBounds(47, 228, 91, 31);
		panelOrderDelete.add(lblSurname_1);

		textField_2 = new JTextField();
		textField_2.setOpaque(true);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(204, 204, 204));
		textField_2.setBounds(148, 228, 290, 31);
		panelOrderDelete.add(textField_2);

		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail_1.setBounds(467, 109, 91, 31);
		panelOrderDelete.add(lblEmail_1);

		textField_3 = new JTextField();
		textField_3.setOpaque(true);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(204, 204, 204));
		textField_3.setBounds(568, 109, 290, 31);
		panelOrderDelete.add(textField_3);

		JLabel lblTelephone_1 = new JLabel("Tel\u00E9fono:");
		lblTelephone_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephone_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelephone_1.setBounds(467, 165, 91, 31);
		panelOrderDelete.add(lblTelephone_1);

		textField_4 = new JTextField();
		textField_4.setOpaque(true);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(204, 204, 204));
		textField_4.setBounds(568, 165, 290, 31);
		panelOrderDelete.add(textField_4);

		JLabel lblAddress_1 = new JLabel("Direcci\u00F3n:");
		lblAddress_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress_1.setBounds(467, 225, 91, 31);
		panelOrderDelete.add(lblAddress_1);

		textField_5 = new JTextField();
		textField_5.setOpaque(true);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(204, 204, 204));
		textField_5.setBounds(568, 225, 290, 31);
		panelOrderDelete.add(textField_5);

		JButton btnAccept_1 = new JButton("Aceptar");
		btnAccept_1.setForeground(Color.WHITE);
		btnAccept_1.setFont(new Font("Tunga", Font.BOLD, 17));
		btnAccept_1.setBorderPainted(false);
		btnAccept_1.setBackground(Color.GRAY);
		btnAccept_1.setBounds(760, 380, 98, 34);
		panelOrderDelete.add(btnAccept_1);

		JButton btnClean_1 = new JButton("Limpiar");
		btnClean_1.setForeground(Color.WHITE);
		btnClean_1.setFont(new Font("Tunga", Font.BOLD, 17));
		btnClean_1.setBorderPainted(false);
		btnClean_1.setBackground(Color.GRAY);
		btnClean_1.setBounds(652, 380, 98, 34);
		panelOrderDelete.add(btnClean_1);

		// Pestaña modificar
		JPanel panelModify = new JPanel();
		panelModify.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabGRUB.addTab("Modificar", null, panelModify, null);
		panelModify.setLayout(null);

		JPanel panelOrderModify = new JPanel();
		panelOrderModify.setLayout(null);
		panelOrderModify.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelOrderModify.setBounds(95, 38, 1103, 521);
		panelModify.add(panelOrderModify);

		JLabel lblProfile_1_1 = new JLabel("Datos Personales");
		lblProfile_1_1.setOpaque(true);
		lblProfile_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProfile_1_1.setBackground(new Color(204, 204, 204));
		lblProfile_1_1.setBounds(47, 47, 870, 31);
		panelOrderModify.add(lblProfile_1_1);

		JLabel lblId_user_1_1 = new JLabel("DNI:");
		lblId_user_1_1.setOpaque(true);
		lblId_user_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_user_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId_user_1_1.setBounds(47, 109, 91, 31);
		panelOrderModify.add(lblId_user_1_1);

		textField_6 = new JTextField();
		textField_6.setOpaque(true);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(204, 204, 204));
		textField_6.setBounds(148, 109, 290, 31);
		panelOrderModify.add(textField_6);

		JLabel lblName_1_1 = new JLabel("Nombre:");
		lblName_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName_1_1.setBounds(47, 168, 91, 31);
		panelOrderModify.add(lblName_1_1);

		textField_7 = new JTextField();
		textField_7.setOpaque(true);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(204, 204, 204));
		textField_7.setBounds(148, 168, 290, 31);
		panelOrderModify.add(textField_7);

		JLabel lblSurname_1_1 = new JLabel("Apellido:");
		lblSurname_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname_1_1.setBounds(47, 228, 91, 31);
		panelOrderModify.add(lblSurname_1_1);

		textField_8 = new JTextField();
		textField_8.setOpaque(true);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(204, 204, 204));
		textField_8.setBounds(148, 228, 290, 31);
		panelOrderModify.add(textField_8);

		JLabel lblEmail_1_1 = new JLabel("Email:");
		lblEmail_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail_1_1.setBounds(467, 109, 91, 31);
		panelOrderModify.add(lblEmail_1_1);

		textField_9 = new JTextField();
		textField_9.setOpaque(true);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_9.setColumns(10);
		textField_9.setBackground(new Color(204, 204, 204));
		textField_9.setBounds(568, 109, 290, 31);
		panelOrderModify.add(textField_9);

		JLabel lblTelephone_1_1 = new JLabel("Tel\u00E9fono:");
		lblTelephone_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephone_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelephone_1_1.setBounds(467, 165, 91, 31);
		panelOrderModify.add(lblTelephone_1_1);

		textField_10 = new JTextField();
		textField_10.setOpaque(true);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(204, 204, 204));
		textField_10.setBounds(568, 165, 290, 31);
		panelOrderModify.add(textField_10);

		JLabel lblAddress_1_1 = new JLabel("Direcci\u00F3n:");
		lblAddress_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress_1_1.setBounds(467, 225, 91, 31);
		panelOrderModify.add(lblAddress_1_1);

		textField_11 = new JTextField();
		textField_11.setOpaque(true);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_11.setColumns(10);
		textField_11.setBackground(new Color(204, 204, 204));
		textField_11.setBounds(568, 225, 290, 31);
		panelOrderModify.add(textField_11);

		JButton btnAccept_1_1 = new JButton("Aceptar");
		btnAccept_1_1.setForeground(Color.WHITE);
		btnAccept_1_1.setFont(new Font("Tunga", Font.BOLD, 17));
		btnAccept_1_1.setBorderPainted(false);
		btnAccept_1_1.setBackground(Color.GRAY);
		btnAccept_1_1.setBounds(760, 380, 98, 34);
		panelOrderModify.add(btnAccept_1_1);

		JButton btnClean_1_1 = new JButton("Limpiar");
		btnClean_1_1.setForeground(Color.WHITE);
		btnClean_1_1.setFont(new Font("Tunga", Font.BOLD, 17));
		btnClean_1_1.setBorderPainted(false);
		btnClean_1_1.setBackground(Color.GRAY);
		btnClean_1_1.setBounds(652, 380, 98, 34);
		panelOrderModify.add(btnClean_1_1);

		// Pestaña listar
		JPanel panelList = new JPanel();
		panelList.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabGRUB.addTab("Listar", null, panelList, null);
		panelList.setLayout(null);

		JPanel panelOrderList = new JPanel();
		panelOrderList.setLayout(null);
		panelOrderList.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panelOrderList.setBounds(95, 38, 1103, 521);
		panelList.add(panelOrderList);

		JButton btnAccept_1_1_1 = new JButton("Aceptar");
		btnAccept_1_1_1.setForeground(Color.WHITE);
		btnAccept_1_1_1.setFont(new Font("Tunga", Font.BOLD, 17));
		btnAccept_1_1_1.setBorderPainted(false);
		btnAccept_1_1_1.setBackground(Color.GRAY);
		btnAccept_1_1_1.setBounds(760, 380, 98, 34);
		panelOrderList.add(btnAccept_1_1_1);

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
		if (textId_userAdd.getText().isEmpty() || textNameAdd.getText().isEmpty() || textSurnameAdd.getText().isEmpty()
				|| textTelephoneAdd.getText().isEmpty() || textAddressAdd.getText().isEmpty()
				|| textEmailAdd.getText().isEmpty() || passwordFieldAdd.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Error, falta algún dato por rellenar", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			try {
				boolean workerFound = adminManager.searchWorker(textId_userAdd.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "iepa");
			}
		}
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
