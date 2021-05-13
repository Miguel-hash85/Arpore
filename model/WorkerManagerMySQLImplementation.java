package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WorkerManagerMySQLImplementation extends ConnectionMySQLImplementation implements WorkerManager{

	
	@Override
	public void addObject(Object o) throws Exception {
		openConnection();
		
		if(o instanceof Household) {
			o = new Household();
			
				final String sINSERThousehold = "INSERT INTO household(cod_household, type_h, surface, room_number, bathroom_number, lifter, outdoor_spaces, city, type_acquisition, price, availability, description) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = con.prepareStatement(sINSERThousehold);
				
				stmt.setString(1, ((Household) o).getsCod_household());
				stmt.setString(2, ((Household) o).getsType_h());
				stmt.setInt(3, ((Household) o).getiSurface());
				stmt.setInt(4, ((Household) o).getiRoom_number());
				stmt.setInt(5, ((Household) o).getiBathroom_number());
				stmt.setBoolean(6, ((Household) o).isbLifter());
				stmt.setBoolean(7, ((Household) o).isbOutdoor_spaces());
				stmt.setString(8, ((Household) o).getsCity());
				stmt.setString(9, ((Household) o).getsType_acquisition());
				stmt.setDouble(10, ((Household) o).getdPrice());
				stmt.setBoolean(11, ((Household) o).isbAvailability());
				stmt.setString(12, ((Household) o).getsDescription());
				
				stmt.executeUpdate();
			
		}else if(o instanceof Buyer) {
			o = new Buyer();
			
				final String sINSERTbuyer = "INSERT INTO buyer(id_user, password, name, surname, email, telephone, address, type_user, active, type_h, surface, room_number, bathroom_number, lifter, outdoor_spaces, city, maxPrice, minPrice) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = con.prepareStatement(sINSERTbuyer);
				
				stmt.setString(1, ((Buyer) o).getsId_user());
				stmt.setString(2, ((Buyer) o).getsPassword());
				stmt.setString(3, ((Buyer) o).getsName());
				stmt.setString(4, ((Buyer) o).getsSurname());
				stmt.setString(5, ((Buyer) o).getsEmail());
				stmt.setString(6, ((Buyer) o).getsTelephone());
				stmt.setString(7, ((Buyer) o).getsAddress());
				stmt.setString(8, ((Buyer) o).getsType_user());
				stmt.setBoolean(9, ((Buyer) o).isbActive());
				stmt.setString(10, ((Buyer) o).getsType_h());
				stmt.setInt(11, ((Buyer) o).getiSurface());
				stmt.setInt(12, ((Buyer) o).getiRoom_number());
				stmt.setInt(13, ((Buyer) o).getiBathroom_number());
				stmt.setBoolean(14, ((Buyer) o).isbLifter());
				stmt.setBoolean(15, ((Buyer) o).isbOutdoor_spaces());
				stmt.setString(16, ((Buyer) o).getsCity());
				stmt.setDouble(17, ((Buyer) o).getdMaxPrice());
				stmt.setDouble(18, ((Buyer) o).getdMinPrice());
				
				stmt.executeUpdate();
			
			closeConnection();
		}
		
		
	}

	@Override
	public ArrayList<Buyer> listBuyers() throws Exception{
		ArrayList<Buyer> arrBuyers = new ArrayList<Buyer>();
		ResultSet rs = null;
		Buyer buyer;
		
		openConnection();
		final String sLISTbuyers = "SELECT * FROM buyer";
		stmt = con.prepareStatement(sLISTbuyers); 
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			buyer = new Buyer();
			buyer.setsId_user(rs.getString("id_user"));
			buyer.setsName(rs.getString("name"));
			buyer.setsSurname(rs.getString("surname"));
			buyer.setsEmail(rs.getString("email"));
			buyer.setsTelephone(rs.getString("telephone"));
			buyer.setsAddress(rs.getString("address"));
			buyer.setsType_user(rs.getString("type_user"));
			
			arrBuyers.add(buyer);
		}
		
		rs.close();
		closeConnection();
		return arrBuyers;		
	}

	@Override
	public boolean modifyObject(Object o) throws Exception {
		openConnection();
		boolean changes = false;
		if(o instanceof Buyer) {			
			final String sUPDATEbuyer = "UPDATE buyer SET id_user = ?, password = ?, name = ?, surname = ?, email = ?, telephone = ?, address = ?, type_user = ?, active = ?, outdoor_spaces = ?, room_number = ?, bathromm_number = ?, max_price = ?, min_price = ?, type_h = ?, lifter = ?, city = ?, surface = ?";
			stmt = con.prepareStatement(sUPDATEbuyer);
			
			stmt.setString(1, ((Buyer) o).getsId_user());
			stmt.setString(2, ((Buyer) o).getsPassword());
			stmt.setString(3, ((Buyer) o).getsName());
			stmt.setString(4, ((Buyer) o).getsSurname());
			stmt.setString(5, ((Buyer) o).getsEmail());
			stmt.setString(6, ((Buyer) o).getsTelephone());
			stmt.setString(7, ((Buyer) o).getsAddress());
			stmt.setString(8, ((Buyer) o).getsType_user());
			stmt.setBoolean(9, ((Buyer) o).isbActive());
			stmt.setBoolean(10, ((Buyer) o).isbOutdoor_spaces());
			stmt.setInt(11, ((Buyer) o).getiRoom_number());
			stmt.setInt(12, ((Buyer) o).getiBathroom_number());
			stmt.setDouble(13, ((Buyer) o).getdMaxPrice());
			stmt.setDouble(14, ((Buyer) o).getdMinPrice());
			stmt.setString(15, ((Buyer) o).getsType_h());
			stmt.setBoolean(16, ((Buyer) o).isbLifter());
			stmt.setString(17, ((Buyer) o).getsCity());
			stmt.setInt(18, ((Buyer) o).getiSurface());
			
			if(stmt.executeUpdate() == 1)
				changes = true;
			
			
		}else if(o instanceof Household) {
			final String sUPDATEhousehold = "UPDATE household SET cod_household = ?, type_h = ?, surface = ?, room_number = ? bathroom_number = ?, lifter = ?, outdoor_spaces = ?, city = ?, type_acquisition = ?, price = ?, avalability = ?, description = ?";
			
			stmt = con.prepareStatement(sUPDATEhousehold);
			
			stmt.setString(1, ((Household) o).getsCod_household());
			stmt.setString(2, ((Household) o).getsType_h());
			stmt.setInt(3, ((Household) o).getiSurface());
			stmt.setInt(4, ((Household) o).getiRoom_number());
			stmt.setInt(5, ((Household) o).getiBathroom_number());
			stmt.setBoolean(6, ((Household) o).isbLifter());
			stmt.setBoolean(7, ((Household) o).isbOutdoor_spaces());
			stmt.setString(8, ((Household) o).getsCity());
			stmt.setString(9, ((Household) o).getsType_acquisition());
			stmt.setDouble(10, ((Household) o).getdPrice());
			stmt.setBoolean(11, ((Household) o).isbAvailability());
			stmt.setString(12, ((Household) o).getsDescription());
			
			if(stmt.executeUpdate() == 1)
				changes = true;
			
		}
		closeConnection();
		return changes;
		
		
	}

	@Override
	public void deleteObject(Object o) throws Exception {
		openConnection();
		if(o instanceof Buyer) {
			final String sDELETEbuyer = "DELETE FROM buyer WHERE id_user = ?";
			stmt = con.prepareStatement(sDELETEbuyer);
			stmt.setString(1, ((Buyer) o).getsId_user());
			
		stmt.executeUpdate();
		}else if(o instanceof Household){
			final String sDELETEhousehold = "DELETE FROM household WHERE cod_household = ?";
			stmt = con.prepareStatement(sDELETEhousehold);
			stmt.setString(1, ((Household) o).getsCod_household());
			
		stmt.executeUpdate();
		}
		closeConnection();
	}
	
	@Override
	public boolean getWorker(String sId_user, String sPassword) throws Exception 
	{
		
		boolean error;
		openConnection();
		CallableStatement cst = con.prepareCall("{CALL loginWorker(?,?,?)}");
		cst.setString(1, sId_user);
		cst.setString(2, sPassword);
		cst.registerOutParameter(3, java.sql.Types.BOOLEAN);
		cst.execute();
		error=cst.getBoolean(3);	
		closeConnection();
		
		return error;
		
		
	}
	
	@Override
	public boolean getBuyer(String sI_duser) throws Exception {
		
		ResultSet rs = null;
		Boolean bIsCreated = false;
		
		openConnection();
		final String sSEARCHbuyer = "SELECT * FROM buyer WHERE id_user = ?";
		stmt = con.prepareStatement(sSEARCHbuyer);
		stmt.setString(1, sI_duser);
		rs = stmt.executeQuery();
		if(rs.next()) 
			bIsCreated = true;
		if(rs != null)
			rs.close();
		closeConnection();
		return bIsCreated;
	}

	@Override
	public Visits organiceVisit(Household household) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Household> listHousehold() throws Exception{
		ArrayList<Household> arrHouseholds = new ArrayList<Household>();
		ResultSet rs;
		Household household;
		
		openConnection();
		final String sLISThousehold = "SELECT * FROM household";
		stmt = con.prepareStatement(sLISThousehold);
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
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
			household.setbAvailability(rs.getBoolean("avalability"));
			household.setsDescription(rs.getString("descripcion"));
			
			arrHouseholds.add(household);
		}
		rs.close();
		closeConnection();
		return arrHouseholds;
	}

	@Override
	public ArrayList<Visits> listVisits() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
