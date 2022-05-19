package cafeJDBCProject.com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo {
	
//	Variables that JDBC will use:
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/cafe"; //ADDED IN CAFE AFTER YOU CREATED THE DB ON CMD MySQL
    final String USER = "root";
    final String PASSWORD = "root";
    
    
//  importing connection from java.sql
	Connection conn;
    
	
//	Method to connect to our database
	public Connection connect() {
//  contains code that we are attempting to use
		try { 
			Class.forName(JDBC_DRIVER); // Finds the JDBC DB to use
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Successfully Connected to MySQL Database");
		} catch (Exception e) { // Takes in an exception. says what to do when this error occurs (print details of this error)
			e.printStackTrace();
		}
		return conn; // This returns the connection we just created
	}

}
