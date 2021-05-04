package model;

import java.util.ArrayList;

public interface BuyerManager {
	
	 public void buyHousehold(Household household) throws Exception;
	 public ArrayList<Household> listHousehold()throws Exception;
	 public ArrayList <Visits> listVisits(String id_user)throws Exception;

}