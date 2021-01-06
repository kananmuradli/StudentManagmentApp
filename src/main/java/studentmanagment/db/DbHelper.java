package studentmanagment.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/studentmanagmentapp02?" + "useTimezone=true&"
					+ "serverTimezone=UTC";
			String user = "root";
			String password = "Kanan20012020";
			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return null;
	}
}
