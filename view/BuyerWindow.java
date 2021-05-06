package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BuyerManager;
import model.BuyerManagerMySQLImplementation;

public class BuyerWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private BuyerManager data;
	private JButton btnListHouses;
	private JButton btnlistVisits;

	
	public BuyerWindow(BuyerManagerMySQLImplementation buyerV) {
		data=buyerV;
		setBounds(100, 100, 700, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnListHouses = new JButton("List Houses");
		btnListHouses.setBounds(112, 47, 206, 96);
		contentPanel.add(btnListHouses);
		
		btnlistVisits = new JButton("List Visits");
		btnlistVisits.setBounds(374, 47, 206, 96);
		contentPanel.add(btnlistVisits);
		
	}
}
