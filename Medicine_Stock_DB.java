package com.medical.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Medicine_Stock_DB {

	
	
	public static boolean Medicine_Stock(Medicine_Stock md) {
		
		String q="insert into stock_management(Medicine_ID,Medicine_Name,Current_Stock,Sold_Stock, profit_loss) values(?,?,?,?,?)";
		boolean f=false;
		try {
			Connection conn=ConnectionProvider.createConn();
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			// set the values of parameter
			pstmt.setInt(1, md.getMedicineID());		
			pstmt.setString(2, md.getMedicineName());
			pstmt.setInt(3, md.getCurrent_stock());
			pstmt.setInt(4, md.getSold_stock());
    		pstmt.setString(5, md.getProfit_loss());
			
			// execute....
			pstmt.executeUpdate();
			f=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}		
	public static void Medicine_Stock() {
		
		try {
			Connection conn=ConnectionProvider.createConn();
			String q="select * from stock_management";
			Statement stmt = conn.createStatement();
			
			// execute....
			ResultSet rs = stmt.executeQuery(q);
			  System.out.println("Medicine_ID\t\t" +"Medicine_Name\t\t" +"Medicine_Type\t\t"+ "MFG_Date\t\t" + "Expiry_Date\t\t" + "Cost_Per_Strip");
			   while(rs.next()) {
				   int id = rs.getInt("Medicine_ID");
				   String Medicine_Name = rs.getString("Medicine_Name");
				   int current = rs.getInt("Current_Stock");
				   int sold = rs.getInt("Sold_Stock");
				   String profit = rs.getString("profit_loss");
						   System.out.println(id +"\t"+ Medicine_Name+"\t" + current+ "\t" + sold + "\t" + profit);
			   }
			   System.out.println("\n\n");
				   rs.close();
				   stmt.close();
				   conn.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static boolean UpdateMedicine_Stock(int userID, String name, int current,int sold,String profit) {
		boolean f=false;
		try {
			Connection conn=ConnectionProvider.createConn();
			
			String q="update stock_management  set Medicine_Name=? , Current_Stock=? , Sold_Stock=? , profit_loss=? where Medicine_ID=?";
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			// set the values of parameter
			
			pstmt.setString(1, name);
			pstmt.setInt(2, current);
			pstmt.setInt(3, sold);
			pstmt.setString(4,profit);
			pstmt.setInt(5, userID);
			// execute....
			pstmt.executeUpdate();
			f=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public static boolean deleteMedicine_Stock(int userID) {
		boolean f=false;
		try {
			Connection conn=ConnectionProvider.createConn();
			
			String q="delete from stock_management where Medicine_ID=?";
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			// set the values of parameter
			pstmt.setInt(1, userID);
			
			// execute....
			pstmt.executeUpdate();
			f=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	}
	

