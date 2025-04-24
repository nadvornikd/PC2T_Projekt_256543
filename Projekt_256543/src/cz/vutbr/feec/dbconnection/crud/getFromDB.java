package cz.vutbr.feec.dbconnection.crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cz.vutbr.feec.dbconnection.dbconn.DatabaseConnection;

public class getFromDB {

	  public getFromDB() {}
	  
	  public String performStatementSelect(String selectQuery) {
		    if (selectQuery == null) {
		    	throw new NullPointerException("query must not be null!");
		    } else if (selectQuery.isEmpty()) {
		    	throw new IllegalArgumentException("query must not be empty!");
		    }
		    
		    String input = null;
		    
		    Connection conn = DatabaseConnection.getDBConnection();
		    try (Statement prStmt = conn.createStatement();
		    	ResultSet rs = prStmt.executeQuery(selectQuery)){
		    	while (rs.next()) {
		    		input = (rs.getString("id") + "," + rs.getString("name") + ","
		    				+ rs.getString("surname") + "," + rs.getString("year") + "," + rs.getString("age")+","+ rs.getString("marks"));	
		    	}
		    } 
		    catch (SQLException e) {
		    	e.printStackTrace();
		    }
		    return input;
	  }
	  
	  public String getAllStudents() {
		  return performStatementSelect("SELECT * FROM student");
	  }
	  
	  public boolean testIfUserExists(int id) {
		    Connection conn = DatabaseConnection.getDBConnection();
		    String testUserExistence = "SELECT * FROM user WHERE email = ?";

		    try (PreparedStatement prStmt = conn.prepareStatement(testUserExistence);) {
			      prStmt.setLong(1, id);
			      ResultSet rs = prStmt.executeQuery();
			      if (rs.next())
			    	  return true;
			      else
			    	  return false;
		    } 
		    catch (SQLException e) {
			      e.printStackTrace();
			      return false;
		    }
	  }
}