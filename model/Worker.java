package model;

import java.time.LocalDate;
/**
 * 
 * @author 1dami
 *
 */
public class Worker extends User{
	private String sSocialSecurityNumber;
	private String sId_admin;
	private LocalDate lddate_s_w;
	private boolean bActive;
	
	
	//Setters and getters
	public String getsSocialSecurityNumber() {
		return sSocialSecurityNumber;
	}
	public void setsSocialSecurityNumber(String sSocialSecurityNumber) {
		this.sSocialSecurityNumber = sSocialSecurityNumber;
	}
	public String getsId_admin() {
		return sId_admin;
	}
	public void setsId_admin(String sId_admin) {
		this.sId_admin = sId_admin;
	}
	public LocalDate getLddate_s_w() {
		return lddate_s_w;
	}
	public void setLddate_s_w(LocalDate lddate_s_w) {
		this.lddate_s_w = lddate_s_w;
	}

	public boolean isbActive() {
		return bActive;
	}
	public void setbActive(boolean bActive) {
		this.bActive = bActive;
	}
	
}
