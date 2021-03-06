package model;

import java.util.ArrayList;

public interface WorkerManager {
	public void addObject(Object o) throws Exception;
	public ArrayList<Buyer> listBuyers() throws Exception;
	public ArrayList<Household> listHouseholds() throws Exception;
	public boolean modifyObject(Object o) throws Exception;
	public void deleteObject(Object o) throws Exception;
	public Visits organiceVisit(Household household) throws Exception;
	public ArrayList<Visits> listHousehold() throws Exception;
}
