package model;

public class User {

	private String sId_user;
	private String sName;
	private String sSurname;
	private String sEmail;
	private String sTelephone;
	private String sAddress;
	private String sType_user;
	private String sPassword;
	
	
	//Setters and Getters
	
	
	public String getsId_user() {
		return sId_user;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public void setsId_user(String sId_user) {
		this.sId_user = sId_user;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsSurname() {
		return sSurname;
	}
	public void setsSurname(String sSurname) {
		this.sSurname = sSurname;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsTelephone() {
		return sTelephone;
	}
	public void setsTelephone(String sTelephone) {
		this.sTelephone = sTelephone;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getsType_user() {
		return sType_user;
	}
	public void setsType_user(String sType_user) {
		this.sType_user = sType_user;
	}
	
	
}
