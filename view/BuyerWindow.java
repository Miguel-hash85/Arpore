package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

import model.BuyerManager;
import model.Household;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class BuyerWindow extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private BuyerManager buyerManager;
	private JTable tableHouseHolds;
	private Household household;
	private JScrollPane scrollPaneTableHousehold;

	public BuyerWindow(BuyerManager buyerV) {
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		this.buyerManager=buyerV;
		
		// Creamos el conjunto de pestañas
		JTabbedPane tabBuyer = new JTabbedPane();
		tabBuyer.setOpaque(true);
		tabBuyer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabBuyer.setBounds(new Rectangle(0, 65, 1904, 1042));
		tabBuyer.setBackground(new Color(204,204,204));
		tabBuyer.getWidth();
		
		JTabbedPane tabGRUB = new JTabbedPane();
		tabGRUB.setOpaque(true);
		tabGRUB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabGRUB.setAlignmentY(10.0f);
		tabGRUB.setAlignmentX(10.0f);
		tabGRUB.setMinimumSize(new Dimension(90, 5));
		tabGRUB.setPreferredSize(new Dimension(60, 5));
		tabGRUB.setBounds(new Rectangle(0, 40, 1904, 1042));
		tabGRUB.setBackground(new Color(204,204,204));
		tabBuyer.addTab("Buyer", null, tabGRUB, "");
		
		
		
		JPanel panelHouseholds = new JPanel();
		tabGRUB.addTab("Households", null, panelHouseholds, null);
		

		
		
		
		JPanel panelDelete = new JPanel();
		tabGRUB.addTab("Baja", null, panelDelete, null);
		
		JLabel et_p3 = new JLabel();
		panelDelete.add(et_p3);
		
		JPanel panelModify = new JPanel();
		tabGRUB.addTab("Modificar", null, panelModify, null);
		
		JLabel et_p4 = new JLabel();
		panelModify.add(et_p4);
		
		JPanel panelList = new JPanel();
		tabGRUB.addTab("Listar", null, panelList, null);
		
		JLabel et_p4_1 = new JLabel();
		panelList.add(et_p4_1);
		
				getContentPane().add(tabBuyer);
		
		JLabel lblLogo43x43 = new JLabel("");
		lblLogo43x43.setIcon(new ImageIcon(BuyerWindow.class.getResource("/resources/Logo43x43.png")));
		lblLogo43x43.setBounds(10, 11, 43, 43);
		getContentPane().add(lblLogo43x43);
		
		JLabel lblArporeNotValid = new JLabel("Arpore");
		lblArporeNotValid.setForeground(Color.WHITE);
		lblArporeNotValid.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblArporeNotValid.setBounds(214, 6, 141, 48);
		getContentPane().add(lblArporeNotValid);

		
		
		JLabel lblNewLabel = new JLabel("Arpore");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(63, 11, 140, 43);
		getContentPane().add(lblNewLabel);
	    UIManager.put("TabbedPane.selected", Color.RED);
	    
	    //*********************TABLE CREATION**********************************
	    ArrayList<Household> arrHouseholds=new ArrayList<Household>();
	    try {
			arrHouseholds=buyerV.listHouseholds();
			if (arrHouseholds.size()>0)
			{
				String mHouseholdsTable[][] = new String[arrHouseholds.size()][5];
				for(int i=0; i<arrHouseholds.size(); i++) {
					
					
					mHouseholdsTable[i][0] = arrHouseholds.get(i).getsType_h();
					mHouseholdsTable[i][1] = String.valueOf(arrHouseholds.get(i).getiSurface());									
					mHouseholdsTable[i][2] = arrHouseholds.get(i).getsCity();					
					mHouseholdsTable[i][3] = String.valueOf(arrHouseholds.get(i).getdPrice())+"\u20ac";					
					mHouseholdsTable[i][4] = arrHouseholds.get(i).getsDescription();
					
				}
				
				scrollPaneTableHousehold = new JScrollPane();
				scrollPaneTableHousehold.setBounds(50, 400, 500, 200);
				contentPanel.add(scrollPaneTableHousehold);
				
				String titulos[] = {"TIPO", "SUPERFICIE","CIUDAD","PRECIO","DESCRIPCION"};
				tableHouseHolds = new JTable(mHouseholdsTable,  titulos);
				tableHouseHolds.setSelectionBackground(new Color(0, 230, 168));
				tableHouseHolds.setSelectionForeground(Color.WHITE);
				tableHouseHolds.setRowMargin(0);
				tableHouseHolds.setRowHeight(25);
				tableHouseHolds.setShowVerticalLines(false);
				tableHouseHolds.setFont(new Font("Tahoma", Font.PLAIN, 12));
				scrollPaneTableHousehold.setViewportView(tableHouseHolds);
				
				JTableHeader tableHeader = tableHouseHolds.getTableHeader();
				tableHeader.setBackground(new Color(0, 191, 140));
				tableHeader.setForeground(Color.WHITE);
				tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
				tableHeader.setBorder(null);
				tableHeader.setEnabled(false);
				panelHouseholds.add(tableHeader);
				panelHouseholds.add(scrollPaneTableHousehold);
				panelHouseholds.add(tableHouseHolds);
				
			}else
			{
				JOptionPane.showMessageDialog(this, "No hay casas en el sistema.");
			}
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(this, "Error al generar la tabla");
			e.printStackTrace();
		}
	}

	
	
	{

		this.setSize(this.getToolkit().getScreenSize());
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
