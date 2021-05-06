package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public AdminWindow() {
		getContentPane().setBackground(Color.WHITE);
		
		// Creamos el conjunto de pestañas
		JTabbedPane tabWorker = new JTabbedPane();
		tabWorker.setOpaque(true);
		tabWorker.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabWorker.setBounds(new Rectangle(0, 65, 1904, 1042));
		tabWorker.setBackground(new Color(204,204,204));
		tabWorker.getWidth();
		
		JTabbedPane tabGRUB = new JTabbedPane();
		tabGRUB.setOpaque(true);
		tabGRUB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabGRUB.setAlignmentY(10.0f);
		tabGRUB.setAlignmentX(10.0f);
		tabGRUB.setMinimumSize(new Dimension(90, 5));
		tabGRUB.setPreferredSize(new Dimension(60, 5));
		tabGRUB.setBounds(new Rectangle(0, 40, 1904, 1042));
		tabGRUB.setBackground(new Color(204,204,204));
		tabWorker.addTab("Worker", null, tabGRUB, "");
		
		
		
		JPanel panelAdd = new JPanel();
		tabGRUB.addTab("Alta", null, panelAdd, null);
		
		JLabel et_p2 = new JLabel("Estas en el panel Alta");
		panelAdd.add(et_p2);
		
		JPanel panelDelete = new JPanel();
		tabGRUB.addTab("Baja", null, panelDelete, null);
		
		JLabel et_p3 = new JLabel("Estas en el panel Baja");
		panelDelete.add(et_p3);
		
		JPanel panelModify = new JPanel();
		tabGRUB.addTab("Modificar", null, panelModify, null);
		
		JLabel et_p4 = new JLabel("Estas en el panel Modificar");
		panelModify.add(et_p4);
		
		JPanel panelList = new JPanel();
		tabGRUB.addTab("Listar", null, panelList, null);
		
		JLabel et_p4_1 = new JLabel("Estas en el panel Listar");
		panelList.add(et_p4_1);
		
				getContentPane().add(tabWorker);
		
		JLabel lblLogo43x43 = new JLabel("");
		lblLogo43x43.setIcon(new ImageIcon(AdminWindow.class.getResource("/resources/Logo43x43.png")));
		lblLogo43x43.setBounds(10, 11, 43, 43);
		getContentPane().add(lblLogo43x43);
		
		JLabel lblArporeNotValid = new JLabel("Arpore");
		lblArporeNotValid.setForeground(Color.WHITE);
		lblArporeNotValid.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblArporeNotValid.setBounds(214, 6, 141, 48);
		getContentPane().add(lblArporeNotValid);

		// Parametros asociados a la ventana
		setVisible(true);
		setTitle("Ejemplo JTabbedPane");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Arpore");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(63, 11, 140, 43);
		getContentPane().add(lblNewLabel);
	    UIManager.put("TabbedPane.selected", Color.RED);
	}

	public static void main(String[] args) {

		AdminWindow ventana = new AdminWindow();

	}

	{

		this.setSize(this.getToolkit().getScreenSize());
	}
}
