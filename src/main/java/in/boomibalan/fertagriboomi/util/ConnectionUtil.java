package in.boomibalan.fertagriboomi.util;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {

		Connection conn = null;
		String url = null;
		String userName = null;
		String password = null;

		try {

//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection(url, userName, password);

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://aws.connect.psdb.cloud/fertagriboomi?sslMode=VERIFY_IDENTITY", "9lao3t2chn3iq6t5ipuc",
					"pscale_pw_D6LWyCiTb6Lb5mZxp1iazPGcJtk3SCD8Gcfm6O2CJXL");

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return conn;

	}

	public static void close(Connection connection, PreparedStatement presta) {
		try {
			if (presta != null) {
				presta.close();
			}
			if (connection != null) {

				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection connection, PreparedStatement presta, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (presta != null) {
				presta.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}