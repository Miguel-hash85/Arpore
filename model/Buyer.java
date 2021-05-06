package model;

public class Buyer extends User{
	
	
	private boolean bOutdoor_spaces;
	private int iRoom_number;
	private int iBathroom_number;
	private double dMaxPrice;
	private double dMinPrice;
	private String sType_h;
	private boolean bLifter;
	private String sCity;
	private int iSurface;
	private boolean bActive;
	
	//******************************Getters and setters*******************************************
	
	
	public boolean isbOutdoor_spaces() {
		return bOutdoor_spaces;
	}
	public void setbOutdoor_spaces(boolean bOutdoor_spaces) {
		this.bOutdoor_spaces = bOutdoor_spaces;
	}
	public int getiRoom_number() {
		return iRoom_number;
	}
	public void setiRoom_number(int iRoom_number) {
		this.iRoom_number = iRoom_number;
	}
	public int getiBathroom_number() {
		return iBathroom_number;
	}
	public void setiBathroom_number(int iBathroom_number) {
		this.iBathroom_number = iBathroom_number;
	}
	public double getdMaxPrice() {
		return dMaxPrice;
	}
	public void setdMaxPrice(double dMaxPrice) {
		this.dMaxPrice = dMaxPrice;
	}
	public double getdMinPrice() {
		return dMinPrice;
	}
	public void setdMinPrice(double dMinPrice) {
		this.dMinPrice = dMinPrice;
	}
	public String getsType_h() {
		return sType_h;
	}
	public void setsType_h(String sType_h) {
		this.sType_h = sType_h;
	}
	public boolean isbLifter() {
		return bLifter;
	}
	public void setbLifter(boolean bLifter) {
		this.bLifter = bLifter;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	public int getiSurface() {
		return iSurface;
	}
	public void setiSurface(int iSurface) {
		this.iSurface = iSurface;
	}
	public boolean isbActive() {
		return bActive;
	}
	public void setbActive(boolean bActive) {
		this.bActive = bActive;
	}
	
	
	
	
	
	
	
	

}
