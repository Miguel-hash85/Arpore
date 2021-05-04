package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ConnectionMySQLImplementation {

	protected Connection con;
	protected PreparedStatement stmt;
	
	
	
	public void openConnection() throws Exception{
		
			  //String url = "jdbc:mysql://localhost/nombreBaseDatos";
			  String url ="jdbc:mysql://localhost:3306/agency?serverTimezone=Europe/Madrid&useSSL=false";
			  //con =  DriverManager.getConnection(url+"?" +"user=____&password=_____");
			  con =  DriverManager.getConnection(url,"root" ,"abcd*1234");

			
		}
	
	public void closeConnection() throws Exception{
		if (stmt != null) 		
			stmt.close();
		
		if(con != null)			
			con.close();
			
	}
	
}
