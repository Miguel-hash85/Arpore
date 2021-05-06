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
	final String sSELECTallHouseholds="SELECT * from household";
	final String sSELECTfilter="SELECT * FROM household WHERE type_h=? and surface=? and room_number=? and bathroom_number=? and lifter=? and outdoor_spaces=? and city=? and type_acquisition=? and price=? and availability=? and description=?";
	final String sUPDATEhousehold = "UPDATE household set availability=? where cod_household=?";
	
	//*********************VISITS sentences ************************************
	final String sSELECTvisit = "SELECT * FROM visits WHERE id_buyer=?";
	
	

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
	//Para ello, aplicaremos un filtro, y en base a �ste, crearemos un ArrayList con los campos encontrados que coincidan.
	@Override
	public ArrayList<Household> listHousehold() throws Exception {
		
		ResultSet rs = null;
		ArrayList<Household> rgbHouseholdList=new ArrayList<Household>();
		openConnection();
		stmt = con.prepareStatement(sSELECTfilter);
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
			household.setsType_acquisition(rs.getString("type_acquisiton"));
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

	@Override
	public ArrayList<Visits> listVisits(String id_user) throws Exception {
		
		ResultSet rs = null;
		ArrayList<Visits> rgbVisitas=new ArrayList<Visits>();
		openConnection();
		stmt = con.prepareStatement(sSELECTvisit);
		rs = stmt.executeQuery();
		while (rs.next()) 
		{
			
		}
		if (rs != null)
			rs.close();
		closeConnection();
		return rgbVisitas;
	}

	
	//Method which makes a select, and return an object of type household
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
				household.setsType_acquisition(rs.getString("type_acquisiton"));
				household.setdPrice(rs.getDouble("price"));
				household.setbAvailability(rs.getBoolean("availability"));
				household.setsDescription(rs.getString("description"));
			}
			if (rs != null) 				
				rs.close();
				
		
		closeConnection();
		return household;
	}
	
	public boolean getBuyer(String sId_buyer, String sPassword) throws Exception 
	{
		CallableStatement cst = con.prepareCall("{CALL loginBuyer(?,?)}");
		return true;
		
	}
	

}