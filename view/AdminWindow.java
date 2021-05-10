package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.AdminManager;
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

import javax.swing.JMenu;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class AdminWindow extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelTop;
	private JMenu mnUserMenu;
	private JMenuItem mntmNewMenuItem;
	private JTextField textId_user;
	private JTextField textAddress;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JTextField textSurname;
	private JTextField textName;
	private JButton btnClean;
	private JButton btnAccept;
	private static AdminManager adminManager;
	private static WorkerManager workerManager;

	public AdminWindow(AdminManager adminManager) {
		setResizable(false);
		// Propia ventana
		setTitle("Admin Window");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		setModal(true);
		this.adminManager = adminManager;
		this.setSize(this.getToolkit().getScreenSize());

		// ---- PARTE SUPERIOR ----
		// Panel en la parte de arriba con el logo nombre y usuario
		panelTop = new JPanel();
		panelTop.setBounds(0, 0, 1904, 66);
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
		mnUserMenu.addActionListener(this);

		// ---- PARTE INFERIOR ----
		// Creamos el conjunto de pestañas
		JTabbedPane tabWorker = new JTabbedPane();
		tabWorker.setBounds(0, 65, 1904, 1042);
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
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		panel.setBounds(62, 36, 879, 557);
		panelAdd.add(panel);
		panel.setLayout(null);

		JLabel lblProfile = new JLabel("Datos Personales");
		lblProfile.setBounds(47, 47, 786, 25);
		panel.add(lblProfile);
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setOpaque(true);
		lblProfile.setBackground(new Color(204, 204, 204));
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblId_user = new JLabel("DNI:");
		lblId_user.setBounds(213, 96, 91, 31);
		panel.add(lblId_user);
		lblId_user.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_user.setOpaque(true);
		lblId_user.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textId_user = new JTextField();
		textId_user.setBounds(314, 96, 290, 31);
		panel.add(textId_user);
		textId_user.setOpaque(true);
		textId_user.setColumns(10);
		textId_user.setBackground(new Color(204, 204, 204));

		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(213, 141, 91, 31);
		panel.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textName = new JTextField();
		textName.setBounds(314, 141, 290, 31);
		panel.add(textName);
		textName.setOpaque(true);
		textName.setColumns(10);
		textName.setBackground(new Color(204, 204, 204));

		JLabel lblSurname = new JLabel("Apellido:");
		lblSurname.setBounds(213, 183, 91, 31);
		panel.add(lblSurname);
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textSurname = new JTextField();
		textSurname.setBounds(314, 183, 290, 31);
		panel.add(textSurname);
		textSurname.setOpaque(true);
		textSurname.setColumns(10);
		textSurname.setBackground(new Color(204, 204, 204));

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(213, 225, 91, 31);
		panel.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textEmail = new JTextField();
		textEmail.setBounds(314, 225, 290, 31);
		panel.add(textEmail);
		textEmail.setOpaque(true);
		textEmail.setColumns(10);
		textEmail.setBackground(new Color(204, 204, 204));

		JLabel lblTelephone = new JLabel("Tel\u00E9fono:");
		lblTelephone.setBounds(213, 267, 91, 31);
		panel.add(lblTelephone);
		lblTelephone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textTelephone = new JTextField();
		textTelephone.setBounds(314, 267, 290, 31);
		panel.add(textTelephone);
		textTelephone.setOpaque(true);
		textTelephone.setColumns(10);
		textTelephone.setBackground(new Color(204, 204, 204));

		JLabel lblAddress = new JLabel("Direcci\u00F3n:");
		lblAddress.setBounds(213, 309, 91, 31);
		panel.add(lblAddress);
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textAddress = new JTextField();
		textAddress.setBounds(314, 309, 290, 31);
		panel.add(textAddress);
		textAddress.setOpaque(true);
		textAddress.setColumns(10);
		textAddress.setBackground(new Color(204, 204, 204));

		btnAccept = new JButton("Aceptar");
		btnAccept.setForeground(Color.WHITE);
		btnAccept.setFont(new Font("Tunga", Font.BOLD, 17));
		btnAccept.setBorderPainted(false);
		btnAccept.setBackground(Color.GRAY);
		btnAccept.setBounds(506, 380, 98, 34);
		panel.add(btnAccept);
		btnAccept.addActionListener(this);

		btnClean = new JButton("Limpiar");
		btnClean.setForeground(Color.WHITE);
		btnClean.setFont(new Font("Tunga", Font.BOLD, 17));
		btnClean.setBorderPainted(false);
		btnClean.setBackground(Color.GRAY);
		btnClean.setBounds(398, 380, 98, 34);
		panel.add(btnClean);
		btnClean.addActionListener(this);

		// Pestaña borrar
		JPanel panelDelete = new JPanel();
		panelDelete.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabGRUB.addTab("Baja", null, panelDelete, null);
		panelDelete.setLayout(null);

		JLabel et_p3 = new JLabel("Estas en el panel Baja"); // Esta linea y la siguiente es solo usado para comprobar
																// que se cambiaba de pestaña
		et_p3.setBounds(894, 5, 105, 14);
		panelDelete.add(et_p3);

		// Pestaña modificar
		JPanel panelModify = new JPanel();
		panelModify.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabGRUB.addTab("Modificar", null, panelModify, null);
		panelModify.setLayout(null);

		JLabel et_p4 = new JLabel("Estas en el panel Modificar"); // Esta linea y la siguiente es solo usado para
																	// comprobar que se cambiaba de pestaña
		et_p4.setBounds(883, 5, 127, 14);
		panelModify.add(et_p4);

		// Pestaña listar
		JPanel panelList = new JPanel();
		panelList.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabGRUB.addTab("Listar", null, panelList, null);
		panelList.setLayout(null);

		JLabel et_p4_1 = new JLabel("Estas en el panel Listar"); // Esta linea y la siguiente es solo usado para
																	// comprobar que se cambiaba de pestaña
		et_p4_1.setBounds(892, 5, 110, 14);
		panelList.add(et_p4_1);

	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource().equals(mnUserMenu)) {
			this.dispose();
		}
		if (a.getSource().equals(btnAccept)) {
			alta(workerManager);
		}
		if (a.getSource().equals(btnClean)) {
			limpiar();
		}
	}

	private void alta(WorkerManager workerManager2) {
		// TODO Auto-generated method stub
		
	}

	private void limpiar() {
		textId_user.setText("");
		textName.setText("");
		textSurname.setText("");
		textEmail.setText("");
		textTelephone.setText("");
		textAddress.setText("");
	}

}
