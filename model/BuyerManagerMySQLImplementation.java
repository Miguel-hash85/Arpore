package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuyerManagerMySQLImplementation implements BuyerManager{
	
	
	private Connection con;
	private PreparedStatement stmt;
	private Buyer buyer;
	private Household household;
	private Visits visit;
	
	//**********************sentences HOUSEHOLD********************************
	final String sSELECThousehold = "SELECT * FROM household WHERE cod_household=?";
	final String sSELECTallHouseholds="SELECT * from household";
	final String sUPDATEhousehold = "UPDATE household set availability=? where cod_household=?";
	
	//*********************sentences VISITS************************************
	final String sSELECTvisit = "SELECT * FROM visits WHERE cod_household=?";
	
	

	@Override
	public void buyHousehold(Household household) throws Exception {
		
		//When a house
		
	}

	@Override
	public ArrayList<Household> listHousehold() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Visits> listVisits(String id_user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}