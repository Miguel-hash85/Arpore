package model;

import java.util.ArrayList;

public interface BuyerManager {
	
	//comentario para probar github
	 public boolean buyHousehold(Household household) throws Exception;
	 public ArrayList<Household> listHouseholds()throws Exception;
	 public ArrayList <Visits> listVisits(String id_user)throws Exception;
	 boolean getBuyer(String sId_user, String sPassword) throws Exception;

}