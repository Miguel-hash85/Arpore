package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminManagerMySQLImplementation extends ConnectionMySQLImplementation implements AdminManager {

	private Connection con;
	private PreparedStatement statement;

	// MySQL
	final String INSERTworker = "INSERT INTO worker(id, nombre, telefono) VALUES( ?, ?, ?)";
	final String GETworker = "SELECT * FROM worker WHERE id = ?";
	final String GETworkers = "SELECT * FROM worker";
	final String UPDATEworker = "UPDATE worker S41ET nombre = ?, telefono= ? WHERE id = ?";
	final String DELETEworker = "DELETE FROM worker WHERE id = ?";

	
	@Override
	public void addWorker(Worker worker) throws Exception {
		openConnection();

		statement = con.prepareStatement(INSERTworker);

		statement.setString(1, worker.getsId_user());
		statement.setString(2, worker.getsName());
		statement.setString(3, worker.getsSurname());
		statement.setString(3, worker.getsEmail());
		statement.setString(3, worker.getsTelephone());
		statement.setString(3, worker.getsAddress());
		statement.executeUpdate();

		closeConnection();

	}

	@Override
	public ArrayList<Worker> listWorker(Worker worker) throws Exception {
		ArrayList<Worker> workers = new ArrayList<>();
		ResultSet rs = null;

		openConnection();
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
		closeConnection();
		rs.close();
		closeConnection();
		return workers;
	}

	@Override
	public boolean modWorker(Worker worker) throws Exception {
		boolean changes = false;

		openConnection();
		statement = con.prepareStatement(UPDATEworker);

		statement.setString(1, worker.getsId_user());
		statement.setString(2, worker.getsName());
		statement.setString(3, worker.getsSurname());
		statement.setString(4, worker.getsEmail());
		statement.setString(5, worker.getsTelephone());
		statement.setString(6, worker.getsAddress());

		if (statement.executeUpdate() == 1)
			changes = true;
		closeConnection();

		return changes;
	}

	@Override
	public void deleteWorker(Worker worker) throws Exception {
		openConnection();

		statement = con.prepareStatement(DELETEworker);
		statement.setString(1, worker.getsId_user());
		statement.executeUpdate();

		closeConnection();
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
		error = cst.getBoolean(3);
		closeConnection();

		return error;

	}

	@Override
	public boolean searchWorker(String worker) throws Exception {
		ResultSet rs = null;
		boolean searchedWorker = false;

		openConnection();

		statement = con.prepareStatement(GETworker);
		statement.setString(1, worker);
		rs = statement.executeQuery();

		if (rs.next()) {
			searchedWorker = true;

			if (rs != null)
				rs.close();

			closeConnection();

		}
		return searchedWorker;
	}

}