package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.Buyer;
import model.WorkerManager;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;

public class WorkerWindow extends JDialog implements ActionListener, FocusListener{

	private final JPanel contentPanel = new JPanel();
	private WorkerManager workerManager;
	private JTextField textId_user;
	private JPasswordField passwordField;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textEmail;
	private JTextField textTelephone;
	private JTextField textAddress;
	private JComboBox comboType_h;
	private JComboBox comboPriceMin;
	private JComboBox comboPriceMax;
	private ButtonGroup groupSurface = new ButtonGroup();
	private JRadioButton rdbtnSurfaceIndifferent;
	private JRadioButton rdbtnSurfaceMore50;
	private JRadioButton rdbtnSurfaceMore100;
	private JRadioButton rdbtnSurfaceMore200;
	private JRadioButton rdbtnSurfaceMore300;
	private JRadioButton rdbtnSurfaceMore500;
	private JComboBox comboCity;
	private final ButtonGroup groupRoom = new ButtonGroup();
	private JRadioButton rdbtnRoom1;
	private JRadioButton rdbtnRoom2;
	private JRadioButton rdbtnRoom3More;
	private final ButtonGroup groupBathRoom = new ButtonGroup();
	private JRadioButton rdbtnBathRoom1;
	private JRadioButton rdbtnBathRoom2;
	private JRadioButton rdbtnBathRoom3More;
	private JCheckBox chckbxOutdoor1;
	private JCheckBox chckbxOutdoor2;
	private JCheckBox chckbxOutdoor3;
	private JCheckBox chckbxLifter;
	private JButton btnAccept;
	private JButton btnCancel;
	private JTextField textCod_Household;
	private JTextField textSurface_household;
	private JTextField textRoom_household;
	private JTextField textBath_household;
	private JTextField textPrice;
	private final ButtonGroup groupLifter_household = new ButtonGroup();
	private final ButtonGroup groupOutdoor_household = new ButtonGroup();
	private JTextField textDescription;
	

	public WorkerWindow(WorkerManager workerManager, String id_user) {
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		this.workerManager = workerManager;
		this.setSize(this.getToolkit().getScreenSize());
		
		
		//Creamos las pestañas
		JTabbedPane tabOptions = new JTabbedPane();
		tabOptions.setBounds(0, 65, 1894, 977);
		tabOptions.setOpaque(true);
		tabOptions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabOptions.setBackground(new Color(204,204,204));
		tabOptions.getWidth();
		getContentPane().setLayout(null);
		
		
		//CRUD de clientes
		JTabbedPane tabBuyers = new JTabbedPane();
		tabBuyers.setOpaque(true);
		tabBuyers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabBuyers.setAlignmentY(10.0f);
		tabBuyers.setAlignmentX(10.0f);
		tabBuyers.setMinimumSize(new Dimension(90, 5));
		tabBuyers.setPreferredSize(new Dimension(60, 5));
		tabBuyers.setBounds(new Rectangle(0, 40, 1904, 1042));
		tabBuyers.setBackground(new Color(204,204,204));
		
		tabOptions.addTab("Clientes", null, tabBuyers, "");
		getContentPane().add(tabOptions);
		
		
		JPanel panelListBuyers = new JPanel();
		tabBuyers.addTab("Listar", null, panelListBuyers, null);
		panelListBuyers.setLayout(null);

		JPanel panelAddBuyers = new JPanel();
		tabBuyers.addTab("Alta", null, panelAddBuyers, null);
		panelAddBuyers.setLayout(null);
		
		//Divido el panel de añadir comprador en 2 partes
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 11, 1865, 650);
		splitPane.setDividerLocation(660);
		panelAddBuyers.add(splitPane);
		
		//Datos personales
		JPanel panelProfile = new JPanel();
		panelProfile.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelProfile.setBackground(Color.WHITE);
		splitPane.setLeftComponent(panelProfile);
		splitPane.setDividerLocation(933);
		panelProfile.setLayout(null);
		
		JLabel lblProfile = new JLabel("Datos Personales");
		lblProfile.setBounds(10, 56, 912, 25);
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setOpaque(true);
		lblProfile.setBackground(new Color(204,204,204));
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelProfile.add(lblProfile);
		
		JLabel lblId_user = new JLabel("DNI:");
		lblId_user.setBounds(267, 199, 91, 31);
		lblId_user.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_user.setOpaque(true);
		lblId_user.setBackground(Color.WHITE);
		lblId_user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelProfile.add(lblId_user);
		
		textId_user = new JTextField();
		textId_user.setBounds(368, 199, 290, 31);
		textId_user.setOpaque(true);
		textId_user.setColumns(10);
		textId_user.setBackground(new Color(204,204,204));
		panelProfile.add(textId_user);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(267, 241, 91, 31);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setOpaque(true);
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelProfile.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(368, 243, 290, 31);
		passwordField.setOpaque(true);
		passwordField.setColumns(10);
		passwordField.setBackground(new Color(204,204,204));
		panelProfile.add(passwordField);
				
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(267, 283, 91, 31);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelProfile.add(lblName);
		
		textName = new JTextField();
		textName.setBounds(368, 283, 290, 31);
		textName.setOpaque(true);
		textName.setColumns(10);
		textName.setBackground(new Color(204, 204, 204));
		panelProfile.add(textName);
		
		JLabel lblSurname = new JLabel("Apellido:");
		lblSurname.setBounds(267, 325, 91, 31);
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelProfile.add(lblSurname);
		
		textSurname = new JTextField();
		textSurname.setBounds(368, 325, 290, 31);
		textSurname.setOpaque(true);
		textSurname.setColumns(10);
		textSurname.setBackground(new Color(204, 204, 204));
		panelProfile.add(textSurname);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(267, 367, 91, 31);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelProfile.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(368, 367, 290, 31);
		textEmail.setOpaque(true);
		textEmail.setColumns(10);
		textEmail.setBackground(new Color(204, 204, 204));
		panelProfile.add(textEmail);
		
		JLabel lblTelephone = new JLabel("Tel\u00E9fono:");
		lblTelephone.setBounds(267, 409, 91, 31);
		lblTelephone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelProfile.add(lblTelephone);
		
		textTelephone = new JTextField();
		textTelephone.setBounds(368, 409, 290, 31);
		textTelephone.setOpaque(true);
		textTelephone.setColumns(10);
		textTelephone.setBackground(new Color(204, 204, 204));
		panelProfile.add(textTelephone);
		
		JLabel lblAddress = new JLabel("Direcci\u00F3n:");
		lblAddress.setBounds(267, 451, 91, 31);
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelProfile.add(lblAddress);
			
		textAddress = new JTextField();
		textAddress.setBounds(368, 451, 290, 31);
		textAddress.setOpaque(true);
		textAddress.setColumns(10);
		textAddress.setBackground(new Color(204, 204, 204));
		panelProfile.add(textAddress);
		
		
		
		//Preferencias
		JPanel panelPreferences = new JPanel();
		splitPane.setRightComponent(panelPreferences);
		panelPreferences.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPreferences.setBackground(Color.WHITE);
		panelPreferences.setLayout(null);
		
		JLabel lblPreferences = new JLabel("Preferencias");
		lblPreferences.setBounds(10, 56, 906, 25);
		lblPreferences.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreferences.setOpaque(true);
		lblPreferences.setBackground(new Color(204,204,204));
		lblPreferences.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelPreferences.add(lblPreferences);
		
		comboType_h = new JComboBox();
		comboType_h.setBounds(378, 199, 273, 22);
		comboType_h.setModel(new DefaultComboBoxModel(new String[] {"Selecciona el tipo de vivienda", "Casa", "Piso", "Chalet", "Caserio"}));
		panelPreferences.add(comboType_h);
		
		JLabel lblType_h = new JLabel("Tipo:");
		lblType_h.setBounds(242, 193, 126, 31);
		lblType_h.setOpaque(true);
		lblType_h.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType_h.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblType_h.setBackground(Color.WHITE);
		panelPreferences.add(lblType_h);
		
		JLabel lblPrice = new JLabel("Precio:");
		lblPrice.setBounds(242, 235, 126, 31);
		lblPrice.setOpaque(true);
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBackground(Color.WHITE);
		panelPreferences.add(lblPrice);
		
		comboPriceMin = new JComboBox();
		comboPriceMin.setBounds(378, 241, 103, 22);
		comboPriceMin.setModel(new DefaultComboBoxModel(new String[] {"Min", "<50000", "50000", "100000", "150000", "200000", "250000", "300000", "500000", "750000", "1000000", "1500000", "2000000"}));
		panelPreferences.add(comboPriceMin);
		
		comboPriceMax = new JComboBox();
		comboPriceMax.setBounds(548, 241, 103, 22);
		comboPriceMax.setModel(new DefaultComboBoxModel(new String[] {"Max", "50000", "75000", "100000", "250000", "500000", "750000", "1000000", "1500000", "2000000", ">2000000"}));
		panelPreferences.add(comboPriceMax);
		
		JLabel lblSurface = new JLabel("Tama\u00F1o:");
		lblSurface.setBounds(242, 277, 126, 31);
		lblSurface.setOpaque(true);
		lblSurface.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurface.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSurface.setBackground(Color.WHITE);
		panelPreferences.add(lblSurface);
		
		
		
		rdbtnSurfaceIndifferent = new JRadioButton("Indiferente");
		rdbtnSurfaceIndifferent.setBounds(378, 283, 91, 23);
		groupSurface.add(rdbtnSurfaceIndifferent);
		panelPreferences.add(rdbtnSurfaceIndifferent);
		
		rdbtnSurfaceMore50 = new JRadioButton(">50 m\u00B2");
		rdbtnSurfaceMore50.setBounds(486, 283, 72, 23);
		groupSurface.add(rdbtnSurfaceMore50);
		panelPreferences.add(rdbtnSurfaceMore50);
		
		rdbtnSurfaceMore100 = new JRadioButton("> 100 m\u00B2");
		rdbtnSurfaceMore100.setBounds(579, 283, 72, 23);
		groupSurface.add(rdbtnSurfaceMore100);
		panelPreferences.add(rdbtnSurfaceMore100);
		
		rdbtnSurfaceMore200 = new JRadioButton(">200 m\u00B2");
		rdbtnSurfaceMore200.setBounds(378, 309, 72, 23);
		groupSurface.add(rdbtnSurfaceMore200);
		panelPreferences.add(rdbtnSurfaceMore200);
		
		rdbtnSurfaceMore300 = new JRadioButton(">300 m\u00B2");
		rdbtnSurfaceMore300.setBounds(486, 309, 72, 23);
		groupSurface.add(rdbtnSurfaceMore300);
		panelPreferences.add(rdbtnSurfaceMore300);
		
		rdbtnSurfaceMore500 = new JRadioButton(">500 m\u00B2");
		rdbtnSurfaceMore500.setBounds(579, 309, 72, 23);
		groupSurface.add(rdbtnSurfaceMore500);
		panelPreferences.add(rdbtnSurfaceMore500);
		
		JLabel lblCity = new JLabel("Poblaci\u00F3n:");
		lblCity.setBounds(242, 344, 126, 31);
		lblCity.setOpaque(true);
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCity.setBackground(Color.WHITE);
		panelPreferences.add(lblCity);
		
		comboCity = new JComboBox();
		comboCity.setBounds(378, 350, 273, 22);
		comboCity.setModel(new DefaultComboBoxModel(new String[] {"Selecciona la poblaci\u00F3n", "Alonsotegi", "Amorebieta", "Arrigorriaga", "Bakio", "Balmaseda", "Barakaldo", "Basauri", "Bermeo", "Bilbao", "Durango", "Erandio", "Ermua", "Etxebarri", "Galdakao", "Gernika", "Getxo", "Gorliz", "Karrantza", "Leioa", "Lekeitio", "Mungia", "Muskiz", "Ondarroa", "Plentzia", "Portugalete", "Santurtzi", "Sopela", "Urduliz", "Ordu\u00F1a", "Zamudio"}));
		panelPreferences.add(comboCity);
		
		JLabel lblRoom = new JLabel("N\u00BA habitaciones:");
		lblRoom.setBounds(242, 386, 126, 31);
		lblRoom.setOpaque(true);
		lblRoom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRoom.setBackground(Color.WHITE);
		panelPreferences.add(lblRoom);
		
		rdbtnRoom1 = new JRadioButton("1");
		rdbtnRoom1.setBounds(378, 392, 72, 23);
		groupRoom.add(rdbtnRoom1);
		panelPreferences.add(rdbtnRoom1);
		
		rdbtnRoom2 = new JRadioButton("2");
		rdbtnRoom2.setBounds(476, 392, 72, 23);
		groupRoom.add(rdbtnRoom2);
		panelPreferences.add(rdbtnRoom2);
		
		rdbtnRoom3More = new JRadioButton("3 o m\u00E1s");
		rdbtnRoom3More.setBounds(579, 392, 72, 23);
		groupRoom.add(rdbtnRoom3More);
		panelPreferences.add(rdbtnRoom3More);
		
				
		JLabel lblBathRoom = new JLabel("N\u00BA ba\u00F1os:");
		lblBathRoom.setBounds(242, 428, 126, 31);
		lblBathRoom.setOpaque(true);
		lblBathRoom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBathRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBathRoom.setBackground(Color.WHITE);
		panelPreferences.add(lblBathRoom);
		
		rdbtnBathRoom1 = new JRadioButton("1");
		rdbtnBathRoom1.setBounds(378, 434, 72, 23);
		groupBathRoom.add(rdbtnBathRoom1);
		panelPreferences.add(rdbtnBathRoom1);
		
		rdbtnBathRoom2 = new JRadioButton("2");
		rdbtnBathRoom2.setBounds(476, 434, 72, 23);
		groupBathRoom.add(rdbtnBathRoom2);
		panelPreferences.add(rdbtnBathRoom2);
		
		rdbtnBathRoom3More = new JRadioButton("3 o m\u00E1s");
		rdbtnBathRoom3More.setBounds(579, 434, 72, 23);
		groupBathRoom.add(rdbtnBathRoom3More);
		panelPreferences.add(rdbtnBathRoom3More);
		
		JLabel lblCharacteristics = new JLabel("Caracter\u00EDsticas:");
		lblCharacteristics.setBounds(242, 470, 126, 31);
		lblCharacteristics.setOpaque(true);
		lblCharacteristics.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCharacteristics.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCharacteristics.setBackground(Color.WHITE);
		panelPreferences.add(lblCharacteristics);
		
		chckbxOutdoor1 = new JCheckBox("Terraza");
		chckbxOutdoor1.setBounds(378, 476, 126, 23);
		panelPreferences.add(chckbxOutdoor1);
		
		chckbxOutdoor2 = new JCheckBox("Balc\u00F3n");
		chckbxOutdoor2.setBounds(525, 476, 126, 23);
		panelPreferences.add(chckbxOutdoor2);
		
		chckbxOutdoor3 = new JCheckBox("Jard\u00EDn");
		chckbxOutdoor3.setBounds(378, 502, 126, 23);
		panelPreferences.add(chckbxOutdoor3);
		
		chckbxLifter = new JCheckBox("Ascensor");
		chckbxLifter.setBounds(525, 502, 126, 23);
		panelPreferences.add(chckbxLifter);
		
		
		btnAccept = new JButton("Aceptar");
		btnAccept.setBounds(1552, 764, 115, 23);
		btnAccept.setBorderPainted(false);
		btnAccept.setForeground(Color.WHITE);
		btnAccept.setBackground(Color.GRAY);
		btnAccept.setFont(new Font("Dialog", Font.BOLD, 17));
		panelAddBuyers.add(btnAccept);
		btnAccept.addActionListener(this);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(1716, 764, 115, 23);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCancel.setBorderPainted(false);
		btnCancel.setBackground(Color.GRAY);
		panelAddBuyers.add(btnCancel);
		btnCancel.addActionListener(this);
		
		
		
		
		
		JPanel panelModifyBuyers = new JPanel();
		tabBuyers.addTab("Modificar", null, panelModifyBuyers, null);
		panelModifyBuyers.setLayout(null);
		
		JPanel panelDeleteBuyers = new JPanel();
		tabBuyers.addTab("Baja", null, panelDeleteBuyers, null);
		panelDeleteBuyers.setLayout(null);

		
		
		
		
		//CRUD de households
		JTabbedPane tabHouseholds = new JTabbedPane(JTabbedPane.TOP);
		tabHouseholds.setOpaque(true);
		tabHouseholds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabHouseholds.setAlignmentY(10.0f);
		tabHouseholds.setAlignmentX(10.0f);
		tabHouseholds.setMinimumSize(new Dimension(90, 5));
		tabHouseholds.setPreferredSize(new Dimension(60, 5));
		tabHouseholds.setBounds(new Rectangle(0, 40, 1904, 1042));
		tabHouseholds.setBackground(new Color(204,204,204));
		
		tabOptions.addTab("Households", null, tabHouseholds, null);
		
		JPanel panelListHouseholds = new JPanel();
		tabHouseholds.addTab("Listar", null, panelListHouseholds, null);
		
		JPanel panelAddHouseholds = new JPanel();
		panelAddHouseholds.setBackground(new Color(240,240,240));
		tabHouseholds.addTab("Alta", null, panelAddHouseholds, null);
		panelAddHouseholds.setLayout(null);
		
		JPanel panelCharacteristics = new JPanel();
		panelCharacteristics.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelCharacteristics.setBackground(Color.WHITE);
		panelCharacteristics.setBounds(10, 11, 1864, 650);
		panelAddHouseholds.add(panelCharacteristics);
		
		JButton btnAccept_1 = new JButton("Aceptar");
		btnAccept_1.setForeground(Color.WHITE);
		btnAccept_1.setFont(new Font("Dialog", Font.BOLD, 17));
		btnAccept_1.setBorderPainted(false);
		btnAccept_1.setBackground(Color.GRAY);
		btnAccept_1.setBounds(1552, 764, 115, 23);
		panelAddHouseholds.add(btnAccept_1);
		
		JButton btnCancel_1 = new JButton("Cancelar");
		btnCancel_1.setForeground(Color.WHITE);
		btnCancel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCancel_1.setBorderPainted(false);
		btnCancel_1.setBackground(Color.GRAY);
		btnCancel_1.setBounds(1716, 764, 115, 23);
		panelAddHouseholds.add(btnCancel_1);
		panelCharacteristics.setLayout(null);
		
		JLabel lblCharacteristicsHouseholds = new JLabel("Características");
		lblCharacteristicsHouseholds.setBounds(10, 56, 1844, 25);
		lblCharacteristicsHouseholds.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharacteristicsHouseholds.setOpaque(true);
		lblCharacteristicsHouseholds.setBackground(new Color(204,204,204));
		lblCharacteristicsHouseholds.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelCharacteristics.add(lblCharacteristicsHouseholds);
		
		JLabel lblCod_Household = new JLabel("C\u00F3digo vivienda:");
		lblCod_Household.setOpaque(true);
		lblCod_Household.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCod_Household.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCod_Household.setBackground(Color.WHITE);
		lblCod_Household.setBounds(235, 160, 164, 31);
		panelCharacteristics.add(lblCod_Household);
		
		textCod_Household = new JTextField();
		textCod_Household.setOpaque(true);
		textCod_Household.setColumns(10);
		textCod_Household.setBackground(new Color(204, 204, 204));
		textCod_Household.setBounds(409, 160, 290, 31);
		panelCharacteristics.add(textCod_Household);
		
		JLabel lblType_household = new JLabel("Tipo de vivienda:");
		lblType_household.setOpaque(true);
		lblType_household.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType_household.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblType_household.setBackground(Color.WHITE);
		lblType_household.setBounds(235, 202, 164, 31);
		panelCharacteristics.add(lblType_household);
		
		JLabel lblCity_household = new JLabel("Poblaci\u00F3n:");
		lblCity_household.setOpaque(true);
		lblCity_household.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity_household.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCity_household.setBackground(Color.WHITE);
		lblCity_household.setBounds(235, 244, 164, 31);
		panelCharacteristics.add(lblCity_household);
		
		JLabel lblSurface_household = new JLabel("Tama\u00F1o:");
		lblSurface_household.setOpaque(true);
		lblSurface_household.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurface_household.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSurface_household.setBackground(Color.WHITE);
		lblSurface_household.setBounds(235, 286, 164, 31);
		panelCharacteristics.add(lblSurface_household);
		
		JLabel lblRoom_household = new JLabel("N\u00BA habitaciones:");
		lblRoom_household.setOpaque(true);
		lblRoom_household.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoom_household.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRoom_household.setBackground(Color.WHITE);
		lblRoom_household.setBounds(235, 328, 164, 31);
		panelCharacteristics.add(lblRoom_household);
		
		JLabel lblBathroom_household = new JLabel("N\u00BA ba\u00F1os:");
		lblBathroom_household.setOpaque(true);
		lblBathroom_household.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBathroom_household.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBathroom_household.setBackground(Color.WHITE);
		lblBathroom_household.setBounds(235, 370, 164, 31);
		panelCharacteristics.add(lblBathroom_household);
		
		JLabel lblLifter_household = new JLabel("Ascensor:");
		lblLifter_household.setOpaque(true);
		lblLifter_household.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLifter_household.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLifter_household.setBackground(Color.WHITE);
		lblLifter_household.setBounds(235, 412, 164, 31);
		panelCharacteristics.add(lblLifter_household);
		
		JLabel lblOutdoor_household = new JLabel("Espacios exteriores:");
		lblOutdoor_household.setOpaque(true);
		lblOutdoor_household.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOutdoor_household.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOutdoor_household.setBackground(Color.WHITE);
		lblOutdoor_household.setBounds(235, 454, 164, 31);
		panelCharacteristics.add(lblOutdoor_household);
		
		JLabel lblPrice_household = new JLabel("Precio:");
		lblPrice_household.setOpaque(true);
		lblPrice_household.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_household.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice_household.setBackground(Color.WHITE);
		lblPrice_household.setBounds(235, 496, 164, 31);
		panelCharacteristics.add(lblPrice_household);
		
		JComboBox comboType_household = new JComboBox();
		comboType_household.setModel(new DefaultComboBoxModel(new String[] {"Selecciona el tipo de vivienda", "Casa", "Piso", "Chalet", "Caserio"}));
		comboType_household.setBounds(408, 208, 291, 22);
		panelCharacteristics.add(comboType_household);
		
		JComboBox comboCity_household = new JComboBox();
		comboCity_household.setModel(new DefaultComboBoxModel(new String[] {"Selecciona la poblaci\u00F3n", "Alonsotegi", "Amorebieta", "Arrigorriaga", "Bakio", "Balmaseda", "Barakaldo", "Basauri", "Bermeo", "Bilbao", "Durango", "Erandio", "Ermua", "Etxebarri", "Galdakao", "Gernika", "Getxo", "Gorliz", "Karrantza", "Leioa", "Lekeitio", "Mungia", "Muskiz", "Ondarroa", "Plentzia", "Portugalete", "Santurtzi", "Sopela", "Urduliz", "Ordu\u00F1a", "Zamudio"}));
		comboCity_household.setBounds(408, 250, 291, 22);
		panelCharacteristics.add(comboCity_household);
		
		textSurface_household = new JTextField();
		textSurface_household.setOpaque(true);
		textSurface_household.setColumns(10);
		textSurface_household.setBackground(new Color(204, 204, 204));
		textSurface_household.setBounds(409, 286, 290, 31);
		panelCharacteristics.add(textSurface_household);
		
		textRoom_household = new JTextField();
		textRoom_household.setOpaque(true);
		textRoom_household.setColumns(10);
		textRoom_household.setBackground(new Color(204, 204, 204));
		textRoom_household.setBounds(409, 328, 290, 31);
		panelCharacteristics.add(textRoom_household);
		
		textBath_household = new JTextField();
		textBath_household.setOpaque(true);
		textBath_household.setColumns(10);
		textBath_household.setBackground(new Color(204, 204, 204));
		textBath_household.setBounds(409, 370, 290, 31);
		panelCharacteristics.add(textBath_household);
		
		textPrice = new JTextField();
		textPrice.setOpaque(true);
		textPrice.setColumns(10);
		textPrice.setBackground(new Color(204, 204, 204));
		textPrice.setBounds(409, 496, 290, 31);
		panelCharacteristics.add(textPrice);
		
		JRadioButton rdbtnLifterYes = new JRadioButton("S\u00ED");
		groupLifter_household.add(rdbtnLifterYes);
		rdbtnLifterYes.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnLifterYes.setBounds(409, 418, 126, 23);
		panelCharacteristics.add(rdbtnLifterYes);
		
		JRadioButton rdbtnLifterNo = new JRadioButton("No");
		groupLifter_household.add(rdbtnLifterNo);
		rdbtnLifterNo.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnLifterNo.setBounds(573, 418, 126, 23);
		panelCharacteristics.add(rdbtnLifterNo);
		
		JRadioButton rdbtnOutdoorYes = new JRadioButton("S\u00ED");
		groupOutdoor_household.add(rdbtnOutdoorYes);
		rdbtnOutdoorYes.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnOutdoorYes.setBounds(409, 460, 126, 23);
		panelCharacteristics.add(rdbtnOutdoorYes);
		
		JRadioButton rdbtnOutdoorNo = new JRadioButton("No");
		groupOutdoor_household.add(rdbtnOutdoorNo);
		rdbtnOutdoorNo.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnOutdoorNo.setBounds(573, 460, 126, 23);
		panelCharacteristics.add(rdbtnOutdoorNo);
		
		JLabel lblDescription = new JLabel("Descripci\u00F3n:");
		lblDescription.setOpaque(true);
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBackground(Color.WHITE);
		lblDescription.setBounds(1035, 170, 164, 31);
		panelCharacteristics.add(lblDescription);
		
		textDescription = new JTextField();
		textDescription.setBounds(1209, 169, 447, 160);
		panelCharacteristics.add(textDescription);
		textDescription.setColumns(10);
		textDescription.setBackground(new Color(204, 204, 204));
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		JPanel panelModifyHouseholds = new JPanel();
		tabHouseholds.addTab("Modificar", null, panelModifyHouseholds, null);
		
		JPanel panelDeleteHouseholds = new JPanel();
		tabHouseholds.addTab("Baja", null, panelDeleteHouseholds, null);
		
		

		
		
		//CRUD de visitas
		
		JTabbedPane tabVisits = new JTabbedPane();
		tabVisits.setOpaque(true);
		tabVisits.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabVisits.setAlignmentY(10.0f);
		tabVisits.setAlignmentX(10.0f);
		tabVisits.setMinimumSize(new Dimension(90, 5));
		tabVisits.setPreferredSize(new Dimension(60, 5));
		tabVisits.setBounds(new Rectangle(0, 40, 1904, 1042));
		tabVisits.setBackground(new Color(204,204,204));
		
		tabOptions.addTab("Visitas", null, tabVisits, "");
		getContentPane().add(tabOptions);
		
		
		JPanel panelMatchesVisits = new JPanel();
		tabVisits.addTab("Coincidencias", null, panelMatchesVisits, null);

		JPanel panelGeneratedVisits = new JPanel();
		tabVisits.addTab("Visitas organizadas", null, panelGeneratedVisits, null);
			
		
		JLabel lblLogo43x43 = new JLabel("");
		lblLogo43x43.setBounds(10, 11, 43, 43);
		lblLogo43x43.setIcon(new ImageIcon(BuyerWindow.class.getResource("/resources/Logo43x43.png")));
		getContentPane().add(lblLogo43x43);
		
		JLabel lblArporeNotValid = new JLabel("Arpore");
		lblArporeNotValid.setBounds(214, 6, 141, 48);
		lblArporeNotValid.setForeground(Color.WHITE);
		lblArporeNotValid.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		getContentPane().add(lblArporeNotValid);
		
		JLabel lblNewLabel = new JLabel("Arpore");
		lblNewLabel.setBounds(0, 0, 1350, 729);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		getContentPane().add(lblNewLabel);
	    UIManager.put("TabbedPane.selected", Color.RED);
		
	}

	@Override
	public void actionPerformed(ActionEvent aP) {
		if(aP.getSource().equals(btnAccept)) 
			addBuyer(workerManager);
		if(aP.getSource().equals(btnCancel))
			clean();
		
	}

	private void clean() {
		textId_user.setText("");
		textName.setText("");
		passwordField.setText("");
		textSurname.setText("");
		textEmail.setText("");
		textTelephone.setText("");
		textAddress.setText("");
		comboType_h.setSelectedIndex(0);
		comboPriceMin.setSelectedIndex(0);
		comboPriceMax.setSelectedIndex(0);
		groupSurface.clearSelection();
		comboCity.setSelectedIndex(0);
		groupRoom.clearSelection();
		groupBathRoom.clearSelection();
		chckbxOutdoor1.setSelected(false);
		chckbxOutdoor2.setSelected(false);
		chckbxOutdoor3.setSelected(false);
		chckbxLifter.setSelected(false);
		
	}

	private void addBuyer(WorkerManager workerManager){
		this.workerManager = workerManager;
		if(textId_user.getText().isEmpty() || passwordField.getText().isEmpty() || textName.getText().isEmpty() || textSurname.getText().isEmpty() || textEmail.getText().isEmpty() || textTelephone.getText().isEmpty() || textAddress.getText().isEmpty())
			JOptionPane.showMessageDialog(this, "Error, falta algún dato por rellenar", "Error", JOptionPane.WARNING_MESSAGE);
		else {
			Buyer buyer = new Buyer();
			buyer.setsId_user(textId_user.getText());
			buyer.setsPassword(passwordField.getText());
			buyer.setsName(textName.getText());
			buyer.setsSurname(textSurname.getText());
			buyer.setsEmail(textEmail.getText());
			buyer.setsTelephone(textTelephone.getText());
			buyer.setsAddress(textAddress.getText());
			buyer.setsType_user("buyer");
			buyer.setsType_h(comboType_h.getSelectedItem().toString());
			buyer.setdMinPrice((double) comboPriceMin.getSelectedItem());
			buyer.setdMaxPrice((double) comboPriceMax.getSelectedItem());
			if(rdbtnSurfaceIndifferent.isSelected())
				buyer.setiSurface(0);
			if(rdbtnSurfaceMore50.isSelected())
				buyer.setiSurface(50);
			if(rdbtnSurfaceMore100.isSelected())
				buyer.setiSurface(100);
			if(rdbtnSurfaceMore200.isSelected())
				buyer.setiSurface(200);
			if(rdbtnSurfaceMore300.isSelected())
				buyer.setiSurface(300);
			if(rdbtnSurfaceMore500.isSelected())
				buyer.setiSurface(500);
			buyer.setsCity(comboCity.getSelectedItem().toString());
			if(rdbtnRoom1.isSelected())
				buyer.setiRoom_number(1);
			else if(rdbtnRoom2.isSelected())
				buyer.setiRoom_number(2);
			else if(rdbtnRoom3More.isSelected())
				buyer.setiRoom_number(3);
			else buyer.setiRoom_number(0);
			if(rdbtnBathRoom1.isSelected())
				buyer.setiBathroom_number(1);
			else if(rdbtnBathRoom2.isSelected())
				buyer.setiBathroom_number(2);
			else if(rdbtnBathRoom3More.isSelected())
				buyer.setiBathroom_number(3);
			else buyer.setiBathroom_number(0);
			if(chckbxOutdoor1.isSelected() || chckbxOutdoor2.isSelected() || chckbxOutdoor3.isSelected())
				buyer.setbOutdoor_spaces(true);
			if(chckbxLifter.isSelected())
				buyer.setbLifter(true);
			
			buyer.setbActive(true);
			buyer.setsType_user("buyer");
			
			int iAccept = JOptionPane.showConfirmDialog(this, "¿Está seguro de que quiere dar de alta el cliente?");
			if(iAccept == 0) {
				try {
					workerManager.addObject(buyer);
					JOptionPane.showMessageDialog(this, "Cliente dado de alta correctamente", "Alta", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(this,e.getMessage(), "Error con la base de datos", JOptionPane.ERROR_MESSAGE);
				}
			}else if(iAccept == 1)
				JOptionPane.showMessageDialog(this, "Operación cancelada");
		}
		
	}

	@Override
	public void focusGained(FocusEvent fE) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent fE){
		if(fE.getSource().equals(textId_user))
			try {
				if(workerManager.getBuyer(textId_user.getText())) {
					JOptionPane.showMessageDialog(this, "Error, El cliente ya está dado de alta.","Usuario duplicado", JOptionPane.WARNING_MESSAGE);
					clean();
					textId_user.requestFocus();
				}
			} catch (HeadlessException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error en la introducción de datos", JOptionPane.ERROR_MESSAGE);				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		
	}
}