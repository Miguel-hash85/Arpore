package model;

public class Visits {

	private String sCod_household;
	private String sId_buyer;
	private String sId_worker;
	private java.sql.Timestamp ldtDate_time_visit;
	private boolean confirmed;
	
	
	//Setters and Getters
	public String getsCod_household() {
		return sCod_household;
	}
	public void setsCod_household(String sCod_household) {
		this.sCod_household = sCod_household;
	}
	public String getsId_buyer() {
		return sId_buyer;
	}
	public void setsId_buyer(String sId_buyer) {
		this.sId_buyer = sId_buyer;
	}
	public String getsId_worker() {
		return sId_worker;
	}
	public void setsId_worker(String sId_worker) {
		this.sId_worker = sId_worker;
	}
	
	public java.sql.Timestamp getLdtDate_time_visit() {
		return ldtDate_time_visit;
	}
	public void setLdtDate_time_visit(java.sql.Timestamp ldtDate_time_visit) {
		this.ldtDate_time_visit = ldtDate_time_visit;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
}
