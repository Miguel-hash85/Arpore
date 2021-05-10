package model;

public class Admin extends User {
	private String cod_admin;
	private String sRegion;


	// Setters and Getters
	public String getCod_admin() {
		return cod_admin;
	}

	public void setCod_adminString(String cod_admin) {
		this.cod_admin = cod_admin;
	}

	public String getsRegion() {
		return sRegion;
	}

	public void setsRegion(String sRegion) {
		this.sRegion = sRegion;
	}
}
