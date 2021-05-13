package model;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BuyerManagerMySQLImplementation extends ConnectionMySQLImplementation implements BuyerManager{
	
	
	//private Connection con;
	//private PreparedStatement stmt;
	private Buyer buyer;
	private Household household;
	private Visits visit;
	
	//**********************BUYER SENTENCES ***********************************
	final String sSELECTbuyer="SELECT * FROM buyer where id_buyer=?";
	//**********************HOUSEHOLD sentences ********************************
	final String sSELECThousehold = "SELECT * FROM household WHERE cod_household=?";
	final String sSELECTfilter="SELECT * FROM household WHERE type_h=? and surface=? and room_number=? and bathroom_number=? and lifter=? and outdoor_spaces=? and city=? and type_acquisition=? and price=? and availability=? and description=?";
	final String sUPDATEhousehold = "UPDATE household set availability=? where cod_household=?";
	
	//*********************VISITS sentences ************************************
	final String sSELECTALLvisits="SELECT * FROM visits WHERE id_buyer=?";
	final String sSELECTvisit = "SELECT * FROM visits WHERE id_buyer=? and cod_household=? and id_worker=?";
	final String sUPDATEconfirmedF="UPDATE visits SET confirmed=? where cod_household=? and id_buyer=? and id_worker=?";
	final String sUPDATEconfirmedT="UPDATE visits SET confirmed=? where cod_household=? and id_buyer=? and id_worker=?";
	
	
	

	//***************METODO PARA COMPRAR UNA VIVIENDA***************************************
	@Override
	public boolean buyHousehold(Household household) throws Exception {
		
		//When a house is bought, We update it, changing the cod_household from 1 to 0
		boolean bComprado=false;
		openConnection();
		//Actualizamos el campo availability, y lo ponemos en false.
		stmt = con.prepareStatement(sUPDATEhousehold);
		stmt.setBoolean(1, household.isbAvailability());
		if(stmt.executeUpdate()==1)
			//Cuando la compra haya sido realizada(availiability=false) utilizaremos un JoptionPane para informar al user
			bComprado=true;
		closeConnection();
		return bComprado;
		
	}
	
	
	//Metodo que devuelve un listado de todas las casas disponibles
	//Para ello, aplicaremos un filtro, y en base a éste, crearemos un ArrayList con los campos encontrados que coincidan.
	@Override
	public ArrayList<Household> listHouseholds(String strQueryFinalSend) throws Exception {
		
		
		String sSELECTallHouseholds="SELECT * from household";
		if(strQueryFinalSend!=null)
			sSELECTallHouseholds=strQueryFinalSend;
		ResultSet rs = null;
		ArrayList<Household> rgbHouseholdList=new ArrayList<Household>();
		openConnection();
		stmt = con.prepareStatement(sSELECTallHouseholds);
		rs = stmt.executeQuery();
		while (rs.next()) 
		{
			household=new Household();
			household.setsCod_household(rs.getString("cod_household"));
			household.setsType_h(rs.getString("type_h"));
			household.setiSurface(rs.getInt("surface"));
			household.setiRoom_number(rs.getInt("room_number"));
			household.setiBathroom_number(rs.getInt("bathroom_number"));
			household.setbLifter(rs.getBoolean("lifter"));
			household.setbOutdoor_spaces(rs.getBoolean("outdoor_spaces"));
			household.setsCity(rs.getString("city"));
			household.setsType_acquisition(rs.getString("type_acquisition"));
			household.setdPrice(rs.getDouble("price"));
			household.setbAvailability(rs.getBoolean("availability"));
			household.setsDescription(rs.getString("description"));
			rgbHouseholdList.add(household);
		}
		if (rs != null)
			rs.close();
		closeConnection();
		return rgbHouseholdList;
	}
	
	//Metodo que genera un arrayList con las visitas registradas en la base de datos
	@Override
	public ArrayList<Visits> listVisits(String id_user) throws Exception {
		
		ResultSet rs = null;
		ArrayList<Visits> arrVisits=new ArrayList<Visits>();
		openConnection();
		stmt = con.prepareStatement(sSELECTALLvisits);
		stmt.setString(1, id_user);
		rs = stmt.executeQuery();
		while (rs.next()) 
		{
			visit=new Visits();
			visit.setsCod_household(rs.getString("cod_household"));
			visit.setsId_buyer(rs.getString("id_buyer"));
			visit.setsId_worker(rs.getString("id_worker"));
			visit.setLdtDate_time_visit(rs.getTimestamp("date_time_visit"));
			visit.setbConfirmed(rs.getBoolean("confirmed"));
			arrVisits.add(visit);
			
		}
		if (rs != null)
			rs.close();
		closeConnection();
		return arrVisits;
	}
	
	//Metodo para recoger una visita a traves de la posicion que ocupa en la tabla.
	
	@Override
	public Visits getVisit(String cod_household, String id_buyer, String id_worker) throws Exception 
	{
		
		ResultSet rs = null;
		openConnection();
		stmt = con.prepareStatement(sSELECTvisit);
		stmt.setString(1, id_buyer);
		stmt.setString(2, cod_household);
		stmt.setString(3, id_worker);
		rs = stmt.executeQuery();
		if(rs.next()) 
		{	
			visit=new Visits();
			visit.setsCod_household(rs.getString("cod_household"));
			visit.setsId_buyer(rs.getString("id_buyer"));
			visit.setsId_worker(rs.getString("id_worker"));
			visit.setLdtDate_time_visit(rs.getTimestamp("date_time_visit"));
			visit.setbConfirmed(rs.getBoolean("confirmed"));
		}
		if (rs != null)
			rs.close();
		closeConnection();
		return visit;
	}
	
	@Override
	public boolean updateVisitF(String cod_household, String id_buyer, String id_worker) throws Exception {
		
		boolean bChanges=false;
		openConnection();
		stmt = con.prepareStatement(sUPDATEconfirmedF);
		stmt.setBoolean(1, false);
		stmt.setString(2, cod_household);
		stmt.setString(3, id_buyer);
		stmt.setString(4, id_worker);
		if (stmt.executeUpdate()==1) 
			bChanges=true;
		closeConnection();
		return bChanges;
	}
	
	@Override
	public boolean updateVisitT(String cod_household, String id_buyer, String id_worker) throws Exception {
		
		boolean bChanges=false;
		openConnection();
		stmt = con.prepareStatement(sUPDATEconfirmedT);
		stmt.setBoolean(1, true);
		stmt.setString(2, cod_household);
		stmt.setString(3, id_buyer);
		stmt.setString(4, id_worker);
		if (stmt.executeUpdate()==1) 
			bChanges=true;
		closeConnection();
		return bChanges;
		
	}
	

	
	//Method which makes a select, and return an object of type household
	@Override
	public Household getHousehold(String sCod_household) throws Exception{
		
		ResultSet rs = null;
		openConnection();
		
			stmt = con.prepareStatement(sSELECThousehold);
			stmt.setString(1, sCod_household);
			rs = stmt.executeQuery();
			if(rs.next()) 
			{
				household = new Household();
				household.setsCod_household(rs.getString("cod_household"));
				household.setsType_h(rs.getString("type_h"));
				household.setiSurface(rs.getInt("surface"));
				household.setiRoom_number(rs.getInt("room_number"));
				household.setiBathroom_number(rs.getInt("bathroom_number"));
				household.setbLifter(rs.getBoolean("lifter"));
				household.setbOutdoor_spaces(rs.getBoolean("outdoor_spaces"));
				household.setsCity(rs.getString("city"));
				household.setsType_acquisition(rs.getString("type_acquisition"));
				household.setdPrice(rs.getDouble("price"));
				household.setbAvailability(rs.getBoolean("availability"));
				household.setsDescription(rs.getString("description"));
			}
			if (rs != null) 				
				rs.close();
				
		
		closeConnection();
		return household;
	}
	
	
	@Override
	public boolean getBuyer(String sId_user, String sPassword) throws Exception 
	{
		
		boolean error;
		openConnection();
		CallableStatement cst = con.prepareCall("{CALL loginBuyer(?,?,?)}");
		cst.setString(1, sId_user);
		cst.setString(2, sPassword);
		cst.registerOutParameter(3, java.sql.Types.BOOLEAN);
		cst.execute();
		error=cst.getBoolean(3);	
		closeConnection();
		
		return error;
		
		
	}


	


	
	

}