package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class WorkerManagerMySQLImplementation extends ConnectionMySQLImplementation implements WorkerManager{

	
	@Override
	public void addObject(Object o) throws Exception {
		openConnection();
		closeConnection();
		
	}

	@Override
	public ArrayList<Buyer> listObject() {
		// TODO Auto-generated method stub
		return null;
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
