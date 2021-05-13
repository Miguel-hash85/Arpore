package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import components.RowsRenderer;
import model.BuyerManager;
import model.Household;
import model.Visits;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class BuyerWindow extends JDialog implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JPanel panelHouseholds = new JPanel();
	private JPanel panelVisits = new JPanel();
	private BuyerManager buyerManager;
	private Visits visit=new Visits();;
	private Household household;
	private String strId_buyer;
	private JPanel panel;
	private JButton btnBuscar;
	
	private DefaultTableModel dtmTableCleaner;
	private JTable tableHouseHolds=new JTable();
	private JTable tableVisits;
	private JScrollPane scrollPaneTableHousehold;
	private JScrollPane scrollPaneTableVisits;
	private final ButtonGroup buttonGroupTamano = new ButtonGroup();
	private final ButtonGroup buttonGroupNhabit = new ButtonGroup();
	private final ButtonGroup buttonGroupNbanios = new ButtonGroup();
	private final ButtonGroup buttonGroupOutdoor = new ButtonGroup();
	
	private JComboBox comboBoxTipo;
	private JComboBox comboBoxPrecioMin;
	private JComboBox comboBoxPrecioMax;
	private JComboBox comboBoxPoblacion;
	private JRadioButton rdbtnIndiferente;
	private JRadioButton rdbtn50;
	private JRadioButton rdbtn100;
	private JRadioButton rdbtn200;
	private JRadioButton rdbtn300;
	private JRadioButton rdbtn500;
	private JRadioButton rdbtnbanios1;
	private JRadioButton rdbtnbanios2;
	private JRadioButton rdbtnbanios3;
	private JRadioButton rdbtnHabitaciones1;
	private JRadioButton rdbtnhabitaciones2;
	private JRadioButton rdbtnhabitaciones3;
	private JCheckBox chckbxTerraza;
	private JCheckBox chckbxJardn;
	private JCheckBox chckbxBalcon;
	private JCheckBox chckbxAscensor;

	public BuyerWindow(BuyerManager buyerManager, String strId_buyer) {
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		this.buyerManager=buyerManager;
		this.strId_buyer=strId_buyer;
				
		// Creamos el conjunto de pestañas
		JTabbedPane tabBuyer = new JTabbedPane();
		tabBuyer.setBounds(0, 65, 1904, 1042);
		tabBuyer.setOpaque(true);
		tabBuyer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabBuyer.setBackground(new Color(204,204,204));
		tabBuyer.getWidth();
		getContentPane().setLayout(null);
				
		tabBuyer.addTab("Households", null, panelHouseholds, null);
		panelHouseholds.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(27, 42, 109, 23);
		panelHouseholds.add(lblTipo);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(27, 94, 109, 23);
		panelHouseholds.add(lblPrecio);
		
		JLabel lblTamano = new JLabel("Tama\u00F1o: ");
		lblTamano.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTamano.setBounds(396, 42, 109, 23);
		panelHouseholds.add(lblTamano);
		
		JLabel lblPoblacion = new JLabel("Poblacion: ");
		lblPoblacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoblacion.setBounds(27, 140, 109, 23);
		panelHouseholds.add(lblPoblacion);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(1677, 202, 126, 23);
		panelHouseholds.add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setToolTipText("Selecciona el tipo de vivienda");
		comboBoxTipo.setBounds(180, 42, 214, 23);
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Selecciona el tipo de vivienda", "Casa", "Piso", "Chalet", "Caserio"}));
		panelHouseholds.add(comboBoxTipo);
		
		comboBoxPrecioMin = new JComboBox();
		comboBoxPrecioMin.setToolTipText("Min");
		comboBoxPrecioMin.setBounds(180, 94, 98, 23);
		comboBoxPrecioMin.setModel(new DefaultComboBoxModel(new String[] {"Min", "<50000", "50000", "100000", "150000", "200000", "250000", "300000", "500000", "750000", "1000000", "1500000", "2000000"}));
		panelHouseholds.add(comboBoxPrecioMin);
		
		comboBoxPrecioMax = new JComboBox();
		comboBoxPrecioMax.setBounds(296, 94, 98, 23);
		comboBoxPrecioMax.setModel(new DefaultComboBoxModel(new String[] {"Max", "50000", "75000", "100000", "250000", "500000", "750000", "1000000", "1500000", "2000000", ">2000000"}));
		panelHouseholds.add(comboBoxPrecioMax);
		
		comboBoxPoblacion = new JComboBox();
		comboBoxPoblacion.setToolTipText("Poblacion");
		comboBoxPoblacion.setBounds(180, 140, 214, 23);
		comboBoxPoblacion.setModel(new DefaultComboBoxModel(new String[] {"Selecciona la poblaci\u00F3n", "Alonsotegi", "Amorebieta", "Arrigorriaga", "Bakio", "Balmaseda", "Barakaldo", "Basauri", "Bermeo", "Bilbao", "Durango", "Erandio", "Ermua", "Etxebarri", "Galdakao", "Gernika", "Getxo", "Gorliz", "Karrantza", "Leioa", "Lekeitio", "Mungia", "Muskiz", "Ondarroa", "Plentzia", "Portugalete", "Santurtzi", "Sopela", "Urduliz", "Ordu\u00F1a", "Zamudio"}));
		panelHouseholds.add(comboBoxPoblacion);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 1867, 917);
		panel.setBackground(Color.WHITE);
		panelHouseholds.add(panel);
		panel.setLayout(null);
		
		rdbtn200 = new JRadioButton(">200 m\u00B2");
		rdbtn200.setBounds(443, 115, 102, 23);
		panel.add(rdbtn200);
		buttonGroupTamano.add(rdbtn200);
		rdbtn200.setToolTipText("Indiferente");
		
		rdbtn300 = new JRadioButton(">300 m\u00B2");
		rdbtn300.setBounds(567, 115, 102, 23);
		panel.add(rdbtn300);
		buttonGroupTamano.add(rdbtn300);
		rdbtn300.setToolTipText("Indiferente");
		
		rdbtn500 = new JRadioButton(">500 m\u00B2");
		rdbtn500.setBounds(691, 115, 99, 23);
		panel.add(rdbtn500);
		buttonGroupTamano.add(rdbtn500);
		rdbtn500.setToolTipText("Indiferente");
		
		//RADIO BUTTONS
		
		rdbtnIndiferente = new JRadioButton("Indiferente");
		rdbtnIndiferente.setBounds(443, 64, 102, 23);
		panel.add(rdbtnIndiferente);
		buttonGroupTamano.add(rdbtnIndiferente);
		rdbtnIndiferente.setToolTipText("Indiferente");
		
		rdbtn50 = new JRadioButton(">50 m\u00B2");
		rdbtn50.setBounds(567, 64, 102, 23);
		panel.add(rdbtn50);
		buttonGroupTamano.add(rdbtn50);
		rdbtn50.setToolTipText("Indiferente");
		
		rdbtn100 = new JRadioButton("> 100 m\u00B2");
		rdbtn100.setBounds(691, 64, 99, 23);
		panel.add(rdbtn100);
		buttonGroupTamano.add(rdbtn100);
		rdbtn100.setToolTipText("Indiferente");
		
		JLabel lblNBanios = new JLabel("N\u00BA ba\u00F1os: ");
		lblNBanios.setBounds(812, 115, 109, 23);
		panel.add(lblNBanios);
		lblNBanios.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNhabitaciones = new JLabel("N\u00BA habitaciones: ");
		lblNhabitaciones.setBounds(812, 64, 109, 23);
		panel.add(lblNhabitaciones);
		lblNhabitaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		
		rdbtnbanios1 = new JRadioButton("1");
		rdbtnbanios1.setBounds(939, 115, 79, 23);
		panel.add(rdbtnbanios1);
		buttonGroupNbanios.add(rdbtnbanios1);
		rdbtnbanios1.setToolTipText("Indiferente");
		
		rdbtnHabitaciones1 = new JRadioButton("1");
		rdbtnHabitaciones1.setBounds(939, 64, 79, 23);
		panel.add(rdbtnHabitaciones1);
		buttonGroupNhabit.add(rdbtnHabitaciones1);
		rdbtnHabitaciones1.setToolTipText("Indiferente");
		
		rdbtnbanios2 = new JRadioButton("2");
		rdbtnbanios2.setBounds(1033, 115, 79, 23);
		panel.add(rdbtnbanios2);
		buttonGroupNbanios.add(rdbtnbanios2);
		rdbtnbanios2.setToolTipText("Indiferente");
		
		rdbtnhabitaciones2 = new JRadioButton("2");
		rdbtnhabitaciones2.setBounds(1033, 64, 79, 23);
		panel.add(rdbtnhabitaciones2);
		buttonGroupNhabit.add(rdbtnhabitaciones2);
		rdbtnhabitaciones2.setToolTipText("Indiferente");
		
		rdbtnbanios3 = new JRadioButton("3 o m\u00E1s");
		rdbtnbanios3.setBounds(1135, 115, 91, 23);
		panel.add(rdbtnbanios3);
		buttonGroupNbanios.add(rdbtnbanios3);
		rdbtnbanios3.setToolTipText("Indiferente");
		
		rdbtnhabitaciones3 = new JRadioButton("3 o m\u00E1s");
		rdbtnhabitaciones3.setBounds(1135, 64, 91, 23);
		panel.add(rdbtnhabitaciones3);
		buttonGroupNhabit.add(rdbtnhabitaciones3);
		rdbtnhabitaciones3.setToolTipText("Indiferente");
		
		JLabel lblCaracteristicas = new JLabel("Caracteristicas:");
		lblCaracteristicas.setBounds(1270, 64, 109, 23);
		panel.add(lblCaracteristicas);
		lblCaracteristicas.setHorizontalAlignment(SwingConstants.RIGHT);
		
		chckbxTerraza = new JCheckBox("Terraza");
		buttonGroupOutdoor.add(chckbxTerraza);
		chckbxTerraza.setBounds(1435, 64, 142, 23);
		panel.add(chckbxTerraza);
		
		chckbxJardn = new JCheckBox("Jard\u00EDn");
		buttonGroupOutdoor.add(chckbxJardn);
		chckbxJardn.setBounds(1435, 115, 142, 23);
		panel.add(chckbxJardn);
		
		chckbxBalcon = new JCheckBox("Balc\u00F3n");
		buttonGroupOutdoor.add(chckbxBalcon);
		chckbxBalcon.setBounds(1624, 64, 142, 23);
		panel.add(chckbxBalcon);
		
		chckbxAscensor = new JCheckBox("Ascensor");
		buttonGroupOutdoor.add(chckbxAscensor);
		chckbxAscensor.setBounds(1624, 115, 142, 23);
		panel.add(chckbxAscensor);
		
		tabBuyer.addTab("Visits", null, panelVisits, null);
		
		
		panelVisits.setLayout(null);
				
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
	    
	    scrollPaneTableVisits = new JScrollPane();
		scrollPaneTableVisits.setBounds(75, 140, 1750, 600);
		panelVisits.add(scrollPaneTableVisits);
		genTableVisits(strId_buyer);
		
	    scrollPaneTableHousehold = new JScrollPane();
		scrollPaneTableHousehold.setBounds(75, 240, 1750, 600);
		panel.add(scrollPaneTableHousehold);
	    //METODOS PARA GENERAR LAS TABLAS
	    genTableHouse(null);   
	    
		
	}
	
	{

		this.setSize(this.getToolkit().getScreenSize());
	}
	
	//***********************GESTION DEL DOBLE CLICK************************************
	
	@Override
	public void actionPerformed(ActionEvent clickButton) {
		
		/*
		 * 
	private JComboBox comboBoxTipo;
	private JComboBox comboBoxPrecioMin;
	private JComboBox comboBoxPrecioMax;
	private JComboBox comboBoxPoblacion;
	private JRadioButton rdbtnIndiferente;
	private JRadioButton rdbtn50;
	private JRadioButton rdbtn100;
	private JRadioButton rdbtn200;
	private JRadioButton rdbtn300;
	private JRadioButton rdbtn500;
	private JRadioButton rdbtnbanios1;
	private JRadioButton rdbtnbanios2;
	private JRadioButton rdbtnbanios3;
	private JRadioButton rdbtnHabitaciones1;
	private JRadioButton rdbtnhabitaciones2;
	private JRadioButton rdbtnhabitaciones3;
	private JCheckBox chckbxTerraza;
	private JCheckBox chckbxJardn;
	private JCheckBox chckbxBalcon;
	private JCheckBox chckbxAscensor;
		 * */
		//UNA VEZ QUE CLICKAMOS EN EL BOTON BUSCAR, GENERAMOS UN SELECT CONSTRUIDO A TRAVÉS DE LAS SELECCIONES HECHAS EN LOS RADIOBUTTONS
		String strQueryFinal=new String();
		if (clickButton.getSource().equals(btnBuscar)){
			
			//grupo de superficie
			if(rdbtn50.isSelected()) 
			{
				strQueryFinal=strQueryFinal+" and surface>=50";
			}else if(rdbtn100.isSelected())
			{
				strQueryFinal=strQueryFinal+" and surface>=100";
			}else if(rdbtn200.isSelected()) 
			{
				strQueryFinal=strQueryFinal+" and surface>=200";
			}else if(rdbtn300.isSelected()) 
			{
				strQueryFinal=strQueryFinal+" and surface>=300";
			}else if(rdbtn500.isSelected()) 
			{
				strQueryFinal=strQueryFinal+" and surface>=500";
			}
			
			//grupo de numero de habitaciones
			if(rdbtnHabitaciones1.isSelected()) 
			{
				strQueryFinal=strQueryFinal+" and room_number=1";
			}else if(rdbtnhabitaciones2.isSelected()) 
			{
				strQueryFinal=strQueryFinal+" and room_number=2";
			}else if(rdbtnhabitaciones3.isSelected())
			{
				strQueryFinal=strQueryFinal+" and room_number>2";
			}
			genTableHouse(strQueryFinal);
			
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent click) {
		
		if(click.getClickCount()==2) 
		{
			if(click.getSource().equals(tableVisits)) {
				try {
					visit=new Visits();
					String sVisitSelectedHH=String.valueOf(tableVisits.getValueAt(tableVisits.getSelectedRow(), 0));
					String sVisitSelectedBuyer=String.valueOf(tableVisits.getValueAt(tableVisits.getSelectedRow(), 1));
					String sVisitSelectedWorker=String.valueOf(tableVisits.getValueAt(tableVisits.getSelectedRow(), 2));
					visit=buyerManager.getVisit(sVisitSelectedHH, sVisitSelectedBuyer, sVisitSelectedWorker);
					VisitDescriptionWindow descriptionWindow=new VisitDescriptionWindow(buyerManager, visit, tableVisits, this);
					descriptionWindow.setVisible(true);
					tableVisits.revalidate();
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			else 
			{
				try {
					String sHHSelected=String.valueOf(tableHouseHolds.getValueAt(tableHouseHolds.getSelectedRow(), 0));
					household=buyerManager.getHousehold(sHHSelected);
					HouseholdDetailWindow householdDetailWindow= new HouseholdDetailWindow(buyerManager, household, null);
					householdDetailWindow.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void genTableHouse(String strQueryFinal) 
	{
		//*********************TABLE HOUSEHOLD CREATION**********************************
	    /*
		 * Creamos la tabla de HouseHolds accediendo a la tabla Household de la base de datos.
		 * Para acceder a la base de datos, utilizamos el metodo listHouseholds de la clase BuyerManagerMySQLImplementation
		 * */
		String strQueryFinalSend=new String();
		if(strQueryFinal==null)
			strQueryFinalSend=null;
		else
			strQueryFinalSend="SELECT * from household where cod_household like 'hh%'"+strQueryFinal;
	    ArrayList<Household> arrHouseholds=new ArrayList<Household>();
	    try {
			arrHouseholds=buyerManager.listHouseholds(strQueryFinalSend);
			if (arrHouseholds.size()>0)
			{
				String mHouseholdsTable[][] = new String[arrHouseholds.size()][6];
				for(int i=0; i<arrHouseholds.size(); i++) {
					
					mHouseholdsTable[i][0] = arrHouseholds.get(i).getsCod_household();
					mHouseholdsTable[i][1] = arrHouseholds.get(i).getsType_h();
					mHouseholdsTable[i][2] = String.valueOf(arrHouseholds.get(i).getiSurface())+" m\u00B2";									
					mHouseholdsTable[i][3] = arrHouseholds.get(i).getsCity();					
					mHouseholdsTable[i][4] = String.valueOf(arrHouseholds.get(i).getdPrice())+"\u20ac";					
					mHouseholdsTable[i][5] = arrHouseholds.get(i).getsDescription();					
				}				
				
				
				String titulos[]={"COD","TIPO", "SUPERFICIE","CIUDAD","PRECIO","DESCRIPCION"};
				dtmTableCleaner= new DefaultTableModel(mHouseholdsTable,  titulos);	
				//dtmTableCleaner.setRowCount(0);
				dtmTableCleaner.setRowCount(arrHouseholds.size());
				tableHouseHolds = new JTable(dtmTableCleaner)
				{
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					//***********************METODO PARA HACER QUE LA TABLA NO SEA EDITABLE, Y ASI HACER DOBLE CLICK************************************
					//Para ello sobreescribimos el metodo que ya tiene la clase JTable.isCellEditable
					public boolean isCellEditable(int row, int column) 
					{
						for(int i=0;i<tableHouseHolds.getRowCount();i++)
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
				tableHouseHolds.addMouseListener(this);
				tableHouseHolds.isCellEditable(arrHouseholds.size(), 5);
				
				
			}else
			{
				JOptionPane.showMessageDialog(this, "No hay casas en el sistema.");
			}
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(this, "Error al generar la tabla");
			e.printStackTrace();
		}
	  //*********************END TABLE HOUSEHOLD CREATION**********************************
	}
	
	public void genTableVisits(String strId_buyer) 
	{
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
					mVisitsTable[i][1] = arrVisits.get(i).getsId_buyer();									
					mVisitsTable[i][2] = arrVisits.get(i).getsId_worker();					
					mVisitsTable[i][3] = String.valueOf(arrVisits.get(i).getLdtDate_time_visit());
					mVisitsTable[i][4] = String.valueOf(arrVisits.get(i).isbConfirmed());					
				}				
								
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
				panel.add(tableVisits);
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
			 visit=new Visits();
			e.printStackTrace();
		}
	    finally 
	    {
	    	visit=new Visits();
	    }
		
		 //*********************END TABLE VISITS CREATION**********************************
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
}


