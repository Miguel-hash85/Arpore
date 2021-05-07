package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

import javax.swing.JMenu;
import java.awt.ComponentOrientation;

public class AdminWindow extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelTop;

	public AdminWindow() {

		// Creamos el conjunto de pestañas
		JTabbedPane tabWorker = new JTabbedPane();
		tabWorker.setOpaque(true);
		tabWorker.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabWorker.setBounds(new Rectangle(0, 65, 1904, 1042));
		tabWorker.setBackground(new Color(204, 204, 204));
		tabWorker.getWidth();

		// Panel en la parte de arriba con el logo nombre y usuario
		panelTop = new JPanel();
		panelTop.setBackground(Color.WHITE);
		panelTop.setBounds(0, 0, 1904, 66);
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
		JMenu mnUserMenu = new JMenu("User");
		mnUserMenu.setIconTextGap(9);
		mnUserMenu.setIcon(new ImageIcon(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		mnUserMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mnUserMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		mnUserMenu.setDelay(0);
		mnUserMenu.setBounds(1720, 11, 157, 43);
		panelTop.add(mnUserMenu);

		// PopUp desde Menu usuario
		JMenuItem mntmNewMenuItem = new JMenuItem("Log out");
		mnUserMenu.add(mntmNewMenuItem);

		// Pestaña Worker
		JTabbedPane tabGRUB = new JTabbedPane();
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
		
		// Nombres de las pestañas con JPanel en el interior de cada uno dodne añadir tablas datos etc.
		JPanel panelAdd = new JPanel();
		tabGRUB.addTab("Alta", null, panelAdd, null);

		JLabel et_p2 = new JLabel("Estas en el panel Alta");  // Esta linea y la siguiente es solo usado para comprobar que se cambiaba de pestaña
		panelAdd.add(et_p2);

		
		JPanel panelDelete = new JPanel();
		tabGRUB.addTab("Baja", null, panelDelete, null);

		JLabel et_p3 = new JLabel("Estas en el panel Baja");  // Esta linea y la siguiente es solo usado para comprobar que se cambiaba de pestaña
		panelDelete.add(et_p3);

		
		JPanel panelModify = new JPanel();
		tabGRUB.addTab("Modificar", null, panelModify, null);

		JLabel et_p4 = new JLabel("Estas en el panel Modificar");  // Esta linea y la siguiente es solo usado para comprobar que se cambiaba de pestaña
		panelModify.add(et_p4);

		
		JPanel panelList = new JPanel();
		tabGRUB.addTab("Listar", null, panelList, null);

		JLabel et_p4_1 = new JLabel("Estas en el panel Listar");  // Esta linea y la siguiente es solo usado para comprobar que se cambiaba de pestaña
		panelList.add(et_p4_1);

		// Este trozo de codigo no sirve para nada, pero si lo borras no funciona
		JLabel lblArporeNotValid = new JLabel("Arpore");
		lblArporeNotValid.setForeground(Color.WHITE);
		lblArporeNotValid.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblArporeNotValid.setBounds(214, 6, 141, 48);
		getContentPane().add(lblArporeNotValid);
		

		// Parametros asociados a la ventana (tienen que ir los ultimos)
		setVisible(true);
		setTitle("Worker Window");
		getContentPane().setLayout(null);
		UIManager.put("TabbedPane.selected", Color.RED);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		getContentPane().setBackground(Color.WHITE);

	}

	public static void main(String[] args) {
		AdminWindow ventana = new AdminWindow();

	}

	{

		this.setSize(this.getToolkit().getScreenSize());
	}

}
