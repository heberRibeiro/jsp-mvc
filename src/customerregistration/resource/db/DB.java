package customerregistration.resource.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() throws DbException {
		if (conn == null) {
			try {

				String user = "root";
				String password = "root";
				String dburl = "jdbc:mysql://localhost:3306/lojaunit?useTimezone=true&serverTimezone=UTC";

				DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // com.mysql.cj.jdbc.Driver
				conn = DriverManager.getConnection(dburl, user, password);

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection() {
		if (conn != null) {
			try {

				DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
				conn.close();

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeStatement(PreparedStatement pst) {
		if (pst != null) {
			try {

				pst.close();

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}