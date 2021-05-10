package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class AdminManagerMySQLImplementation implements AdminManager {

	private Connection con;
	private PreparedStatement statement;

	// MySQL
	final String INSERTworker = "INSERT INTO worker(id, nombre, telefono) VALUES( ?, ?, ?)";
	final String GETworker = "SELECT * FROM worker WHERE id = ?";
	final String GETworkers = "SELECT * FROM worker";
	final String UPDATEworker = "UPDATE worker S41ET nombre = ?, telefono= ? WHERE id = ?";
	final String DELETEworker = "DELETE FROM worker WHERE id = ?";

	private void openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/agency?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");

		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	private void closeConnection() throws SQLException {
		System.out.println("Conexion Cerrada.");
		if (statement != null)
			statement.close();
		if (con != null)
			con.close();
		System.out.println("------------------------");
	}

	@Override
	public void addWorker(Worker worker) throws Exception {
		this.openConnection();

		try {
			statement = con.prepareStatement(INSERTworker);

			statement.setString(1, worker.getsId_user());
			statement.setString(2, worker.getsName());
			statement.setString(3, worker.getsSurname());
			statement.setString(3, worker.getsEmail());
			statement.setString(3, worker.getsTelephone());
			statement.setString(3, worker.getsAddress());
			statement.executeUpdate();

		} catch (SQLException e1) {
			String error = "Something went wrong, contact the supplier";
			Exception ex = new Exception(error);
			throw ex;

		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Worker> listWorker(Worker worker) throws Exception {
		ArrayList<Worker> workers = new ArrayList<>();
		 ResultSet rs = null;

		this.openConnection();

		try {
			statement = con.prepareStatement(GETworkers);

			 rs = statement.executeQuery();

			while (rs.next()) {
				worker = new Worker();
				worker.setsId_user(rs.getString("id"));
				worker.setsName(rs.getString("name"));
				worker.setsSurname(rs.getString("surname"));
				worker.setsEmail(rs.getString("email"));
				worker.setsTelephone(rs.getString("telephone"));
				worker.setsAddress(rs.getString("address"));
				workers.add(worker);
			}

		} catch (SQLException e) {
			System.out.println("SQL Error");
			e.printStackTrace();

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error in the DB closing");
				e.printStackTrace();
			}
		}
		return workers;
	}

	@Override
	public boolean modWorker(Worker worker) throws Exception {
		boolean changes = false;
		this.openConnection();

		try {
			statement = con.prepareStatement(UPDATEworker);

			statement.setString(1, worker.getsId_user());
			statement.setString(2, worker.getsName());
			statement.setString(3, worker.getsSurname());
			statement.setString(4, worker.getsEmail());
			statement.setString(5, worker.getsTelephone());
			statement.setString(6, worker.getsAddress());

			if (statement.executeUpdate() == 1)
				changes = true;
		} catch (SQLException e1) {
			System.out.println("Error in the SQL modification");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error in the DB closing");
				e.printStackTrace();
			}
		}
		return changes;
	}

	@Override
	public void deleteWorker(Worker worker) throws Exception {
		// Abrimos la conexión
		this.openConnection();

		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			statement = con.prepareStatement(DELETEworker);
			statement.setString(1, worker.getsId_user());
			statement.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Error in the SQL modification");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error in the DB closing");
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean getAdmin(String sId_user, String sPassword) throws Exception {
		boolean error;
		openConnection();
		CallableStatement cst = con.prepareCall("{CALL loginAdmin(?,?,?)}");
		cst.setString(1, sId_user);
		cst.setString(2, sPassword);
		cst.registerOutParameter(3, java.sql.Types.BOOLEAN);
		cst.execute();
		error=cst.getBoolean(3);	
		closeConnection();
		
		return error;
		
	}

}