package cz.vutbr.feec.dbconnection.dbconn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static volatile Connection databaseConnection;
	private DatabaseConnection() {}
	
	public static Connection getDBConnection() {
		if (databaseConnection == null) {
			synchronized (DatabaseConnection.class) {
				if (databaseConnection == null) {
					try {
						Class.forName("org.sqlite.JDBC");
						databaseConnection = DriverManager.getConnection("jdbc:sqlite:db/students.db");
					} 
					catch (SQLException | ClassNotFoundException e) {
						e.printStackTrace(); // log it
					}
				}
			}
	    }
		return databaseConnection;
	}
	public static void closeConnection() {
		try {
			databaseConnection.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
