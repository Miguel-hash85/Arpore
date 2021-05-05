package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class AdminWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public AdminWindow() {

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
		
		this.setSize(this.getToolkit().getScreenSize());
	}
}
