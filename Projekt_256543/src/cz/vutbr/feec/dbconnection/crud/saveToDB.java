package cz.vutbr.feec.dbconnection.crud;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cz.vutbr.feec.dbconnection.dbconn.DatabaseConnection;

public class saveToDB {
	  public saveToDB() {}

	  public void performInsertQuery(String insertQuery) {
	    if (insertQuery == null) {
	    	throw new NullPointerException("query must not be null!");
	    } 
	    else if (insertQuery.isEmpty()) {
	    	throw new IllegalArgumentException("query must not be empty!");
	    }
	    Connection conn = DatabaseConnection.getDBConnection();
	    try (PreparedStatement prStmt = conn.prepareStatement(insertQuery);) {
		      int rowsInserted = prStmt.executeUpdate();
		      System.out.println("Added user: " + rowsInserted);
	    } 
	    catch (SQLException e) {
		      e.printStackTrace();
	    }
	  }
	  public void insertNewUser(int id, String name, String surname, int year, String course) {
	    if (name == null || surname == null || course == null)
	    	throw new NullPointerException("Name, surname and course must be set");

	    Connection conn = DatabaseConnection.getDBConnection();

	    String insertUser = "";

	    try (PreparedStatement prStmt = conn.prepareStatement(insertUser)) {
		      prStmt.setLong(1, id);
		      prStmt.setString(2, name);
		      prStmt.setString(3, surname);
		      prStmt.setLong(4, year);
		      prStmt.setString(5, course);
	
		      prStmt.executeUpdate();
		      System.out.println("User inserted to database");
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();
	    }
	  }


}