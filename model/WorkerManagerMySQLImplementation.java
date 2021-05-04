package model;

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
	public ArrayList<Buyer> listBuyers() throws Exception{
		ArrayList<Buyer> rgbBuyers = new ArrayList<Buyer>();
		ResultSet rs = null;
		Buyer buyer;
		
		//Abrimos la conexión
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
			
		}
		
		closeConnection();
		return rgbBuyers;		
	}

	@Override
	public boolean modifyObject(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteObject(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Visits organiceVisit(Household household) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Visits> listHousehold() {
		// TODO Auto-generated method stub
		return null;
	}


}
