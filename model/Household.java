package model;

public class Household {

	private String sCod_household;
	private String sType_h;
	private int iSurface;
	private int iRoom_number;
	private int iBathroom_number;
	private boolean bLifter;
	private boolean bOutdoor_spaces;
	private String sCity;
	private String sType_acquisition;
	private double dPrice;
	private boolean bAvailability;
	private String sDescription;
	
	//Setters and Getters
	public String getsCod_household() {
		return sCod_household;
	}
	public void setsCod_household(String sCod_household) {
		this.sCod_household = sCod_household;
	}
	public String getsType_h() {
		return sType_h;
	}
	public void setsType_h(String sType_h) {
		this.sType_h = sType_h;
	}
	public int getiSurface() {
		return iSurface;
	}
	public void setiSurface(int iSurface) {
		this.iSurface = iSurface;
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
	public boolean isbLifter() {
		return bLifter;
	}
	public void setbLifter(boolean bLifter) {
		this.bLifter = bLifter;
	}
	public boolean isbOutdoor_spaces() {
		return bOutdoor_spaces;
	}
	public void setbOutdoor_spaces(boolean bOutdoor_spaces) {
		this.bOutdoor_spaces = bOutdoor_spaces;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	public String getsType_acquisition() {
		return sType_acquisition;
	}
	public void setsType_acquisition(String sType_acquisition) {
		this.sType_acquisition = sType_acquisition;
	}
	public double getdPrice() {
		return dPrice;
	}
	public void setdPrice(double dPrice) {
		this.dPrice = dPrice;
	}
	public boolean isbAvailability() {
		return bAvailability;
	}
	public void setbAvailability(boolean bAvailability) {
		this.bAvailability = bAvailability;
	}
	public String getsDescription() {
		return sDescription;
	}
	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}
}
