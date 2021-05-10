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

import components.RowsRenderer;
import model.BuyerManager;
import model.Household;
import model.Visits;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollBar;

public class BuyerWindow extends JDialog implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JPanel panelHouseholds = new JPanel();
	private JPanel panelVisits = new JPanel();
	private BuyerManager buyerManager;
	
	
	
	private JTable tableHouseHolds;
	private JTable tableVisits;
	private JScrollPane scrollPaneTableHousehold;
	private JScrollPane scrollPaneTableVisits;

	public BuyerWindow(BuyerManager buyerManager, String strId_buyer) {
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		this.buyerManager=buyerManager;
		
		
		
		
		
		
		// Creamos el conjunto de pestañas
		JTabbedPane tabBuyer = new JTabbedPane();
		tabBuyer.setBounds(0, 65, 1904, 1042);
		tabBuyer.setOpaque(true);
		tabBuyer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabBuyer.setBackground(new Color(204,204,204));
		tabBuyer.getWidth();
		getContentPane().setLayout(null);
		
		
		
		
		
		
		tabBuyer.addTab("Households", null, panelHouseholds, null);
		
		tabBuyer.addTab("Visits", null, panelVisits, null);
		
		
		panelVisits.setLayout(null);
		panelHouseholds.setLayout(null);
		

		
		
		
		
		
		
		
		
				getContentPane().add(tabBuyer);
		
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
		lblNewLabel.setBounds(0, 0, 1904, 1041);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		getContentPane().add(lblNewLabel);
	    UIManager.put("TabbedPane.selected", Color.RED);
	    
	    //*********************TABLE HOUSEHOLD CREATION**********************************
	    /*
		 * Creamos la tabla de HouseHolds accediendo a la tabla Household de la base de datos.
		 * Para acceder a la base de datos, utilizamos el metodo listHouseholds de la clase BuyerManagerMySQLImplementation
		 * */
	    ArrayList<Household> arrHouseholds=new ArrayList<Household>();
	    try {
			arrHouseholds=buyerManager.listHouseholds();
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
				scrollPaneTableHousehold.setBounds(75, 140, 1750, 600);
				panelHouseholds.add(scrollPaneTableHousehold);
				
				String titulos[]={"TIPO", "SUPERFICIE","CIUDAD","PRECIO","DESCRIPCION"};
				tableHouseHolds = new JTable(mHouseholdsTable,  titulos) 
				{
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					//***********************METODO PARA HACER QUE LA TABLA NO SEA EDITABLE, Y ASI HACER DOBLE CLICK************************************
					//Para ello sobreescribimos el metodo que ya tiene la clase JTable.isCellEditable
					public boolean isCellEditable(int row, int column) 
					{
						for(int i=0;i<tableVisits.getRowCount();i++)
						{
							if(row==i) 
							{
								return false;
							}
						}
						return true;
					}
				};
				//***********************FIN METODO PARA HACER QUE LA TABLA NO SEA EDITABLE, Y ASI HACER DOBLE CLICK************************************
				tableHouseHolds.setSelectionBackground(new Color(0, 230, 168));
				tableHouseHolds.setSelectionForeground(Color.WHITE);
				tableHouseHolds.setRowMargin(0);
				tableHouseHolds.setRowHeight(30);
				tableHouseHolds.setShowVerticalLines(true);
				tableHouseHolds.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panelHouseholds.add(tableHouseHolds);
				scrollPaneTableHousehold.setViewportView(tableHouseHolds);
				
				JTableHeader tableHeader = tableHouseHolds.getTableHeader();
				tableHeader.setBackground(new Color(0, 191, 140));
				tableHeader.setForeground(Color.WHITE);
				tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
				tableHeader.setBorder(null);
				tableHeader.setEnabled(false);
				
				
			}else
			{
				JOptionPane.showMessageDialog(this, "No hay casas en el sistema.");
			}
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(this, "Error al generar la tabla");
			e.printStackTrace();
		}
	  //*********************END TABLE HOUSEHOLD CREATION**********************************
	    
	    

		 //******* **************TABLE VISITS CREATION**********************************
		/*
		 * Creamos la tabla de visitas accediendo a la tabla en la base de datos llamada Visits.
		 * Para acceder a la base de datos, utilizamos el metodo listVisits de la clase BuyerManagerMySQLImplementation
		 * */
	    ArrayList<Visits> arrVisits=new ArrayList<Visits>();
	    try {
	    	arrVisits=buyerManager.listVisits(strId_buyer);
			if (arrVisits.size()>0)
			{
				String mVisitsTable[][] = new String[arrVisits.size()][5];
				for(int i=0; i<arrVisits.size(); i++) {
					
					
					mVisitsTable[i][0] = arrVisits.get(i).getsCod_household();
					mVisitsTable[i][1] = arrVisits.get(i).getsId_worker();									
					mVisitsTable[i][2] = arrVisits.get(i).getsId_buyer();					
					mVisitsTable[i][3] = String.valueOf(arrVisits.get(i).getLdtDate_time_visit());
					mVisitsTable[i][4] = String.valueOf(arrVisits.get(i).isConfirmed());
					
					
					
					
					
				}
				
				scrollPaneTableVisits = new JScrollPane();
				scrollPaneTableVisits.setBounds(75, 140, 1750, 600);
				panelVisits.add(scrollPaneTableVisits);
				
				String titulos[]={"CASA","TRABAJADOR","CLIENTE","FECHA", "CONFIRMADA"};
				tableVisits = new JTable(mVisitsTable,  titulos) {
					/**
						 * 
						 */
						private static final long serialVersionUID = 1L;
	
					//***********************METODO PARA HACER QUE LA TABLA NO SEA EDITABLE, Y ASI HACER DOBLE CLICK************************************
					//Para ello sobreescribimos el metodo que ya tiene la clase JTable.isCellEditable
					public boolean isCellEditable(int row, int column) 
					{
						for(int i=0;i<tableVisits.getRowCount();i++)
						{
							if(row==i) 
							{
								return false;
							}
						}
						return true;
					}
				};
				//***********************FIN METODO PARA HACER QUE LA TABLA NO SEA EDITABLE, Y ASI HACER DOBLE CLICK************************************
				
			
				//Pintamos cada fila de un color, según esté confirmada o no la visita
				//Para ello hemos creado una clase(RowsRenderer), que extiende de DefaultTableCellRenderer, y con la cual accedemos a cada celda que nos interese
				RowsRenderer rRowsRenderer=new RowsRenderer(4);
				tableVisits.setDefaultRenderer(Object.class, rRowsRenderer);
				
					
						
				
				tableVisits.setSelectionBackground(new Color(0, 230, 168));
				tableVisits.setSelectionForeground(Color.WHITE);
				tableVisits.setRowMargin(0);
				tableVisits.setRowHeight(30);
				tableVisits.setShowVerticalLines(true);
				tableVisits.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panelVisits.add(tableVisits);
				scrollPaneTableVisits.setViewportView(tableVisits);
				
				JTableHeader tableHeader = tableVisits.getTableHeader();
				tableHeader.setBackground(new Color(0, 191, 140));
				tableHeader.setForeground(Color.WHITE);
				tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
				tableHeader.setBorder(null);
				tableHeader.setEnabled(false);
				tableVisits.addMouseListener(this);
				tableVisits.isCellEditable(arrVisits.size(), 4);
				
				
				
				
			}else
			{
				JOptionPane.showMessageDialog(this, "No hay casas en el sistema.");
			}
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(this, "Error al generar la tabla");
			e.printStackTrace();
		}
		
		 //*********************END TABLE VISITS CREATION**********************************
	}
	
	
	
	
	{

		this.setSize(this.getToolkit().getScreenSize());
	}
	
	//***********************GESTION DEL DOBLE CLICK************************************
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if(arg0.getClickCount()==2) 
		{
			JOptionPane.showMessageDialog(this, "Has clicado la tabla.");
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//***********************FIN GESTION DEL DOBLE CLICK********************************
	
	


	
}
