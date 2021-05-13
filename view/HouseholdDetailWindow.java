package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BuyerManager;
import model.Household;
import model.Visits;

import javax.swing.JTable;

public class HouseholdDetailWindow extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Household household=new Household();
	private BuyerManager buyerManager;
	private Visits visit;
	private JButton btnVisitar;
	

	

	/**
	 * Create the dialog.
	 * @param buyerManager 
	 * @param household 
	 * @param visit 
	 */
	public HouseholdDetailWindow(BuyerManager buyerManager, Household household, Visits visit) {
		
		
		this.buyerManager=buyerManager;
		this.visit=visit;
		this.household=household;
		setModal(true);
		setBounds(100, 100, 802, 755);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JLabel lblLogo43x43 = new JLabel("");
			lblLogo43x43.setBounds(29, 11, 43, 43);
			lblLogo43x43.setIcon(new ImageIcon(BuyerWindow.class.getResource("/resources/Logo43x43.png")));
			getContentPane().add(lblLogo43x43);

			
			
			JLabel lblNewLabel = new JLabel("Arpore");
			lblNewLabel.setBounds(20, 48, 88, 67);
			lblNewLabel.setForeground(Color.DARK_GRAY);
			lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
			getContentPane().add(lblNewLabel);
		}
		
		JLabel lblDetailsHouse = new JLabel("Detalles de la casa :");
		lblDetailsHouse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDetailsHouse.setBounds(106, 102, 325, 48);
		getContentPane().add(lblDetailsHouse);
		
		
		
		
		btnVisitar = new JButton("Visitar!");
		btnVisitar.setBounds(320, 633, 129, 31);
		btnVisitar.setBorderPainted(false);
		btnVisitar.setForeground(Color.WHITE);
		btnVisitar.setBackground(Color.GRAY);
		btnVisitar.setFont(new Font("Tunga", Font.BOLD, 17));
		btnVisitar.addActionListener(this);
		getContentPane().add(btnVisitar);
		
		JLabel lblCodigoObj = new JLabel("New label");
		lblCodigoObj.setBounds(373, 161, 260, 24);
		lblCodigoObj.setText(household.getsCod_household());
		getContentPane().add(lblCodigoObj);
		
		JLabel lblTypeHouse = new JLabel("Tipo de vivienda: ");
		lblTypeHouse.setBounds(106, 186, 260, 24);
		getContentPane().add(lblTypeHouse);
		
		JLabel lblSuperficie = new JLabel("Superficie de la vivienda: ");
		lblSuperficie.setBounds(106, 211, 260, 24);
		getContentPane().add(lblSuperficie);
		
		JLabel lblCodeHouse = new JLabel("Codigo de la vivienda: ");
		lblCodeHouse.setBounds(106, 161, 260, 24);
		getContentPane().add(lblCodeHouse);
		
		JLabel lblHabitaciones = new JLabel("Numero de habitaciones:  ");
		lblHabitaciones.setBounds(106, 236, 260, 24);
		getContentPane().add(lblHabitaciones);
		
		JLabel lblBanios = new JLabel("Numero de ba\u00F1os:  ");
		lblBanios.setBounds(106, 260, 260, 24);
		getContentPane().add(lblBanios);
		
		JLabel lblLifter = new JLabel("Ascensor disponible :  ");
		lblLifter.setBounds(106, 285, 260, 24);
		getContentPane().add(lblLifter);
		
		JLabel lblOutdoor = new JLabel("Espacios exteriores: ");
		lblOutdoor.setBounds(106, 310, 260, 24);
		getContentPane().add(lblOutdoor);
		
		JLabel lblCity = new JLabel("Ciudad:");
		lblCity.setBounds(106, 332, 260, 24);
		getContentPane().add(lblCity);
		
		JLabel lblTransaction = new JLabel("Tipo de transaccion: ");
		lblTransaction.setBounds(106, 357, 260, 24);
		getContentPane().add(lblTransaction);
		
		JLabel lblPrice = new JLabel("Precio:  ");
		lblPrice.setBounds(106, 387, 260, 24);
		getContentPane().add(lblPrice);
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setBounds(106, 444, 260, 24);
		getContentPane().add(lblDescripcion);
		
		JLabel lblTipoObj = new JLabel((String) null);
		lblTipoObj.setBounds(373, 186, 260, 24);
		lblTipoObj.setText(household.getsType_h());
		getContentPane().add(lblTipoObj);
		
		JLabel lblSurfaceObj = new JLabel((String) null);
		lblSurfaceObj.setBounds(373, 211, 260, 24);
		lblSurfaceObj.setText(String.valueOf(household.getiSurface())+" m\u00B2");
		getContentPane().add(lblSurfaceObj);
		
		JLabel lblRoomsObj = new JLabel((String) null);
		lblRoomsObj.setBounds(373, 236, 260, 24);
		lblRoomsObj.setText(String.valueOf(household.getiRoom_number()));
		getContentPane().add(lblRoomsObj);
		
		JLabel lblBaniosObj = new JLabel((String) null);
		lblBaniosObj.setBounds(373, 260, 260, 24);
		lblBaniosObj.setText(String.valueOf(household.getiBathroom_number()));
		getContentPane().add(lblBaniosObj);
		
		JLabel lblLifterObj = new JLabel((String) null);
		lblLifterObj.setBounds(373, 285, 260, 24);
		lblLifterObj.setText(String.valueOf(household.isbLifter()));
		getContentPane().add(lblLifterObj);
		
		JLabel lblOutObj = new JLabel((String) null);
		lblOutObj.setBounds(373, 310, 260, 24);
		lblOutObj.setText(String.valueOf(household.isbOutdoor_spaces()));
		getContentPane().add(lblOutObj);
		
		JLabel lblCityObj = new JLabel((String) null);
		lblCityObj.setBounds(373, 332, 260, 24);
		lblCityObj.setText(household.getsCity());
		getContentPane().add(lblCityObj);
		
		JLabel lblTransObj = new JLabel((String) null);
		lblTransObj.setBounds(373, 357, 260, 24);
		lblTransObj.setText(household.getsType_acquisition());
		getContentPane().add(lblTransObj);
		
		JLabel lblPriceObj = new JLabel((String) null);
		lblPriceObj.setBounds(373, 387, 260, 24);
		lblPriceObj.setText(String.valueOf(household.getdPrice())+"\u20ac");
		getContentPane().add(lblPriceObj);
		
		JLabel lblDescObj = new JLabel((String) null);
		lblDescObj.setBounds(106, 452, 533, 94);
		lblDescObj.setText(household.getsDescription());
		getContentPane().add(lblDescObj);
	}




	@Override
	public void actionPerformed(ActionEvent click) {
		
		if(click.getSource().equals(btnVisitar)){
			if(visit!=null) {
				try {
					if(buyerManager.updateVisitT(visit.getsCod_household(), visit.getsId_buyer(), visit.getsId_worker()))
						JOptionPane.showMessageDialog(this, "Datos actualizados.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "No se han podido actualizar los datos.");
					e.printStackTrace();
				}
			}
			else 
			{
				btnVisitar.setEnabled(false);
			}
			
		}
		
	}
}

