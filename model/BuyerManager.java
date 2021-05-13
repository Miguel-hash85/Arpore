package model;

import java.util.ArrayList;

public interface BuyerManager {
	
	//comentario para probar github
	 public boolean buyHousehold(Household household) throws Exception;
	 public ArrayList<Household> listHouseholds(String strQueryFinalSend)throws Exception;
	 public Household getHousehold(String sCod_household) throws Exception;
	 public ArrayList <Visits> listVisits(String id_user)throws Exception;
	 public boolean getBuyer(String sId_buyer, String sPassword) throws Exception;
	 public Visits getVisit(String cod_household, String Id_buyer, String Id_worker) throws Exception;
	 public boolean updateVisitF(String cod_household, String Id_buyer, String Id_worker)throws Exception;
	 public boolean updateVisitT(String cod_household, String Id_buyer, String Id_worker)throws Exception;
	 

}