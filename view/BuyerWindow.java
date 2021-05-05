package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BuyerManager;
import java.awt.Color;
import java.awt.Font;

public class BuyerWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private BuyerManager data;
	private JButton btnListVisits;

	public BuyerWindow() {
		setBounds(100, 100, 700, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnListHouses = new JButton("List Houses");
		btnListHouses.setForeground(Color.WHITE);
		btnListHouses.setFont(new Font("Tunga", Font.BOLD, 17));
		btnListHouses.setBorderPainted(false);
		btnListHouses.setBackground(Color.GRAY);
		btnListHouses.setBounds(376, 219, 200, 72);
		contentPanel.add(btnListHouses);

		btnListVisits = new JButton("List Visits");
		btnListVisits.setForeground(Color.WHITE);
		btnListVisits.setFont(new Font("Tunga", Font.BOLD, 17));
		btnListVisits.setBorderPainted(false);
		btnListVisits.setBackground(Color.GRAY);
		btnListVisits.setBounds(167, 219, 199, 72);
		contentPanel.add(btnListVisits);

	    this.setSize(this.getToolkit().getScreenSize());
	}
}
