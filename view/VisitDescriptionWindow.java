package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import model.BuyerManager;
import model.Household;
import model.Visits;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Dimension;

public class VisitDescriptionWindow extends JDialog implements ActionListener{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Visits visit;
	private BuyerManager buyerManager;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancel;
	private JButton btnConfirmar;
	private JButton btnComprobarCasa;
	private JTable tableVisits;
	private BuyerWindow buyerWindow;
	
	
	public VisitDescriptionWindow(BuyerManager buyerManager, Visits visit, JTable tableVisits, BuyerWindow buyerWindow) {
		
		this.buyerWindow=buyerWindow;
		this.buyerManager=buyerManager;		
		this.visit=visit;
		this.tableVisits=tableVisits;
		
		setSize(new Dimension(800, 650));
		getContentPane().setLayout(null);
		setModal(true);
		JLabel lblLogo43x43 = new JLabel("");
		lblLogo43x43.setBounds(22, 11, 43, 43);
		lblLogo43x43.setIcon(new ImageIcon(BuyerWindow.class.getResource("/resources/Logo43x43.png")));
		getContentPane().add(lblLogo43x43);

		
		
		JLabel lblNewLabel = new JLabel("Arpore");
		lblNewLabel.setBounds(10, 56, 129, 49);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		getContentPane().add(lblNewLabel);
		
		JLabel lblTitleDescVisit = new JLabel("Estos son los detalles de tu visita:");
		lblTitleDescVisit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitleDescVisit.setBounds(116, 139, 367, 43);
		getContentPane().add(lblTitleDescVisit);
		
		JLabel lblTrabajador = new JLabel("Trabajador que dirige la visita:");
		lblTrabajador.setBounds(116, 193, 187, 37);
		getContentPane().add(lblTrabajador);
		
		JLabel lblHousehold = new JLabel("Casa a visitar :");
		lblHousehold.setBounds(116, 231, 187, 37);
		getContentPane().add(lblHousehold);
		
		JLabel lbldate = new JLabel("D\u00EDa y hora de la visita:");
		lbldate.setBounds(116, 270, 187, 37);
		getContentPane().add(lbldate);
		
		btnComprobarCasa = new JButton("Ver casa!");
		btnComprobarCasa.setBounds(309, 354, 140, 28);
		btnComprobarCasa.setBorderPainted(false);
		btnComprobarCasa.setForeground(Color.WHITE);
		btnComprobarCasa.setBackground(Color.GRAY);
		btnComprobarCasa.setFont(new Font("Tunga", Font.BOLD, 17));
		getContentPane().add(btnComprobarCasa);
		btnComprobarCasa.addActionListener(this);
		
		btnConfirmar = new JButton("Confirmar Visita");
		btnConfirmar.setBounds(439, 509, 140, 28);
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(Color.GRAY);
		btnConfirmar.setFont(new Font("Tunga", Font.BOLD, 17));
		getContentPane().add(btnConfirmar);
		btnConfirmar.addActionListener(this);
		
		btnCancel = new JButton("Cancelar Visita");
		btnCancel.setBounds(600, 509, 140, 28);
		btnCancel.setBorderPainted(false);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setFont(new Font("Tunga", Font.BOLD, 17));
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
		JLabel lblTrabajadorInfo = new JLabel("");
		lblTrabajadorInfo.setBounds(313, 193, 187, 37);
		lblTrabajadorInfo.setText(visit.getsId_worker());
		getContentPane().add(lblTrabajadorInfo);
		
		JLabel lblCasaInfo = new JLabel("");
		lblCasaInfo.setBounds(313, 231, 187, 37);
		lblCasaInfo.setText(visit.getsCod_household());
		getContentPane().add(lblCasaInfo);
		
		JLabel lblDiaInfo = new JLabel("");
		lblDiaInfo.setBounds(313, 270, 187, 37);
		getContentPane().add(lblDiaInfo);
		lblDiaInfo.setText(String.valueOf(visit.getLdtDate_time_visit()));
	    UIManager.put("TabbedPane.selected", Color.RED);
	}

	
	@Override
	public void actionPerformed(ActionEvent click) {
		
		if (click.getSource().equals(btnCancel)){
			try {
				if(buyerManager.updateVisitF(visit.getsCod_household(), visit.getsId_buyer(), visit.getsId_worker()))
					JOptionPane.showMessageDialog(this, "Datos actualizados.");
				tableVisits.revalidate();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "No se han podido actualizar los datos.");
				e.printStackTrace();
			}
			buyerWindow.genTableVisits(visit.getsId_buyer());
		}
		if(click.getSource().equals(btnConfirmar)){
			try {
				if(buyerManager.updateVisitT(visit.getsCod_household(), visit.getsId_buyer(), visit.getsId_worker()))
					JOptionPane.showMessageDialog(this, "Datos actualizados.");
				tableVisits.revalidate();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "No se han podido actualizar los datos.");
				e.printStackTrace();
			}
			buyerWindow.genTableVisits(visit.getsId_buyer());
		}
		if (click.getSource().equals(btnComprobarCasa)){
			Household household=new Household();
			try {
				household=buyerManager.getHousehold(visit.getsCod_household());
				HouseholdDetailWindow householdDetailWindow= new HouseholdDetailWindow(buyerManager, household, visit);
				householdDetailWindow.setVisible(true);
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(this, "No se ha podido cargar la pantalla de detalles de la casa.");
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
}

