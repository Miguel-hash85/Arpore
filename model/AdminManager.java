package model;

import java.util.ArrayList;



public interface AdminManager {
	
	public void addWorker(Worker worker) throws Exception;	
	public ArrayList<Worker> listWorker(Worker worker) throws Exception;	
	public boolean modWorker(Worker worker) throws Exception;	
	public void deleteWorker(Worker worker) throws Exception;
	boolean getAdmin(String sId_user, String sPassword) throws Exception;

}
