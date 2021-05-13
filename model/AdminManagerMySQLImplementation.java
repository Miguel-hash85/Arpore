package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminManagerMySQLImplementation extends ConnectionMySQLImplementation implements AdminManager {

	// MySQL
	final String INSERTworker = "INSERT INTO worker(id_user, name, surname, email, telephone, address, type_user, password, id_admin, date_s_w, socialSecurityNumber) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final String GETworker = "SELECT * FROM worker WHERE id_user = ?";
	final String GETworkers = "SELECT * FROM worker";
	final String UPDATEworker = "UPDATE worker S41ET nombre = ?, telefono= ? WHERE id = ?";
	final String DELETEworker = "DELETE FROM worker WHERE id = ?";

	@Override
	public void addWorker(Worker worker) throws Exception {
		openConnection();

		stmt = con.prepareStatement(INSERTworker);

		stmt.setString(1, worker.getsId_user());
		stmt.setString(2, worker.getsName());
		stmt.setString(3, worker.getsSurname());
		stmt.setString(4, worker.getsEmail());
		stmt.setString(5, worker.getsTelephone());
		stmt.setString(6, worker.getsAddress());
		stmt.setString(7, worker.getsId_admin());
		stmt.setString(8, worker.getsSocialSecurityNumber());
		stmt.setString(9, worker.getsType_user());
		stmt.setDate(10, worker.getLddate_s_w());
		stmt.executeUpdate();

		closeConnection();

	}

	@Override
	public ArrayList<Worker> listWorker(Worker worker) throws Exception {
		ArrayList<Worker> workers = new ArrayList<>();
		ResultSet rs = null;

		openConnection();
		stmt = con.prepareStatement(GETworkers);
		rs = stmt.executeQuery();

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
		stmt = con.prepareStatement(UPDATEworker);

		stmt.setString(1, worker.getsId_user());
		stmt.setString(2, worker.getsName());
		stmt.setString(3, worker.getsSurname());
		stmt.setString(4, worker.getsEmail());
		stmt.setString(5, worker.getsTelephone());
		stmt.setString(6, worker.getsAddress());

		if (stmt.executeUpdate() == 1)
			changes = true;
		closeConnection();

		return changes;
	}

	@Override
	public void deleteWorker(Worker worker) throws Exception {
		openConnection();

		stmt = con.prepareStatement(DELETEworker);
		stmt.setString(1, worker.getsId_user());
		stmt.executeUpdate();

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
	public boolean searchWorker(String sWorker) throws Exception {
		ResultSet rs = null;
		boolean searchedWorker = false;

		openConnection();

		stmt = con.prepareStatement(GETworker);
		stmt.setString(1, sWorker);
		rs = stmt.executeQuery();

		if (rs.next()) {
			searchedWorker = true;

			if (rs != null)
				rs.close();

			closeConnection();
		}
		return searchedWorker;
	}

}