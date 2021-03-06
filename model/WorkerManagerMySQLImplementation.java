package model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WorkerManagerMySQLImplementation extends ConnectionMySQLImplementation implements WorkerManager{

	
	@Override
	public void addObject(Object o) throws Exception {
		openConnection();
		
		if(o instanceof Household) {
			o = new Household();
			
				final String sINSERThousehold = "INSERT INTO household(sCod_household, sType_h, iSurface, iRoom_number, iBathroom_number, bLifter, bOutdoor_spaces, sCity, sType_acquisition, dPrice, bAvailability, sDescription) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			
				final String sINSERTbuyer = "INSERT INTO buyer(sId_user, sName, sSurname, sEmail, sTelephone, sAddress, sType_user, bActive, sCod_buyer, sType_h, iSurface, iRoom_number, iBathroom_number, bLifter, bOutdoor_spaces, sCity, dMaxPrice, dMinPrice) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = con.prepareStatement(sINSERTbuyer);
				
				stmt.setString(1, ((Buyer) o).getsId_user());
				stmt.setString(2, ((Buyer) o).getsName());
				stmt.setString(3, ((Buyer) o).getsSurname());
				stmt.setString(4, ((Buyer) o).getsEmail());
				stmt.setString(5, ((Buyer) o).getsTelephone());
				stmt.setString(6, ((Buyer) o).getsAddress());
				stmt.setString(7, ((Buyer) o).getsType_user());
				stmt.setBoolean(8, ((Buyer) o).isbActive());
				stmt.setString(9, ((Buyer) o).getsCod_buyer());
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
	public ArrayList<Household> listHouseholds() throws Exception{
		
		
		ArrayList<Household> arrHouseholds = new ArrayList<>();
		ResultSet rs = null;
		Household household;
		
		openConnection();
		
		final String sLISThouseholds ="SELECT * FROM households";
		stmt = con.prepareStatement(sLISThouseholds);
		
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
			household.setbAvailability(rs.getBoolean("availability"));
			household.setsDescription(rs.getString("description"));
			
			arrHouseholds.add(household);
		}
		closeConnection();
		return arrHouseholds;
	}
	
	@Override
	public ArrayList<Buyer> listBuyers() throws Exception{

		ArrayList<Buyer> arrBuyers = new ArrayList<Buyer>();
		ResultSet rs = null;
		Buyer buyer;
		
		//Abrimos la conexi?n
		openConnection();
		final String sLISTbuyers = "SELECT * FROM buyer";
		stmt = con.prepareStatement(sLISTbuyers); 
		
		rs = stmt.executeQuery();
		//while
		while(rs.next()) {
			buyer = new Buyer();
			buyer.setsId_user(rs.getString("id_user"));
			buyer.setsName(rs.getString("name"));
			buyer.setsSurname(rs.getString("surname"));
			buyer.setsEmail(rs.getString("email"));
			buyer.setsTelephone(rs.getString("telephone"));
			buyer.setsAddress(rs.getString("address"));
			buyer.setsType_user(rs.getString("type_user"));
			buyer.setsCod_buyer(rs.getString("cod_buyer"));
			buyer.setbActive(rs.getBoolean("active"));
			buyer.setsType_h(rs.getString("type_h"));
			buyer.setiSurface(rs.getInt("surface"));
			buyer.setiRoom_number(rs.getInt("room_number"));
			buyer.setiBathroom_number(rs.getInt("bathroom_number"));
			buyer.setbLifter(rs.getBoolean("lifter"));
			buyer.setbOutdoor_spaces(rs.getBoolean("outdoor_spaces"));
			buyer.setsCity(rs.getString("city"));
			buyer.setdMaxPrice(rs.getDouble("max_price"));
			buyer.setdMinPrice(rs.getDouble("min_price"));
			
			arrBuyers.add(buyer);
		}
		
		closeConnection();
		return arrBuyers;	
	}

	@Override
	public boolean modifyObject(Object o) throws Exception{
		boolean booChanges = false;
		
		openConnection();
		
		if(o instanceof Household) {
			 o = new Household();
			final String UPDATEhousehold = "UPDATE household SET cod_household = ?, type_h = ?, surface = ?, room_number = ?, bathroom_number = ?, lifter = ?, outdoor_spaces = ?, city = ?, type_acquisition = ?, price = ?, availability = ?, description = ?";
			stmt = con.prepareStatement(UPDATEhousehold);
			
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
			
			if(stmt.executeUpdate() == 1) {
				booChanges = true;
			}
		}else if(o instanceof Buyer) {
			o = new Buyer();
			final String UPDATEbuyer = "UPDATE buyer SET id_user = ?, name = ?, surname = ?, email = ?, telephone = ?, address = ?, type_user = ?, cod_buyer = ?, outdoor_spaces = ?, room_number = ?, bathroom_number = ?, max_price = ?, min_price = ?, type_h = ?, lifter = ?, city = ?, surface = ?";
			stmt = con.prepareStatement(UPDATEbuyer);
			
			stmt.setString(1, ((Buyer) o).getsId_user());
			stmt.setString(2, ((Buyer) o).getsName());
			stmt.setString(3, ((Buyer) o).getsSurname());
			stmt.setString(4, ((Buyer) o).getsEmail());
			stmt.setString(5, ((Buyer) o).getsTelephone());
			stmt.setString(6, ((Buyer) o).getsAddress());
			stmt.setString(7, ((Buyer) o).getsType_user());
			stmt.setString(8, ((Buyer) o).getsCod_buyer());
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
			
			if(stmt.executeUpdate() == 1) {
				booChanges = true;
			}
			
			closeConnection();
		}
		
		return false;
	}

	@Override
	public void deleteObject(Object o) throws Exception{
		openConnection();
		
		if(o instanceof Household) {
			final String DELETEhousehold = "DELETE FROM household WHERE cod_household = ?";
			stmt = con.prepareStatement(DELETEhousehold);
			
			stmt.setString(1, ((Household) o).getsCod_household());
			stmt.executeUpdate();
		}else if(o instanceof Buyer) {
			final String DELETEbuyer = "DELETE FROM buyer WHERE id_user = ?";
			stmt = con.prepareStatement(DELETEbuyer);
			
			stmt.setString(1, ((Buyer) o).getsId_user());
			stmt.executeUpdate();
		}
		
		closeConnection();
	}

	@Override
	public Visits organiceVisit(Household household) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Visits> listHousehold() throws Exception{
		return null;
	}


}
