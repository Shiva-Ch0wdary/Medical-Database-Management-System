package com.medical.manage;
import java.sql.*;

public class ConnectionProvider {

	static final String URL ="jdbc:mysql://localhost:3306/Mini_Project";
	static Connection conn=null;
	public static Connection createConn() {
	 
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to database.......");
		conn=DriverManager.getConnection(URL,"root","Akash@6396739099");
		
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		
		e.printStackTrace();
	}
	return conn;
}
}
