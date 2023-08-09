package com.medical.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Distributor_DB {
	
	public static boolean insertDistributorToDB(Distributor dr) {
		
		boolean f=false;
		try {
			Connection conn=ConnectionProvider.createConn();
			
			String q="insert into distributor_details(Distributor_Name,Phone_No,Address,Medicine_Name,Quantity,Wholesale_Price,Selling_Price,Total_Amount) values(?,?,?,?,?,?,?,?)";
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			// set the values of parameter
		
			pstmt.setString(1, dr.getDistributorName());
			pstmt.setString(2, dr.getPhone_No());
			pstmt.setString(3, dr.getAddress());
    		pstmt.setString(4, dr.getMedicine_Name());
			pstmt.setInt(5, dr.getQuantity());
			pstmt.setInt(6, dr.getWholesale_price());
			pstmt.setInt(7, dr.getSelling_Price());
			pstmt.setInt(8, dr.getTotal_Amount());
			// execute....
			pstmt.executeUpdate();
			f=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public static boolean deleteMedicine(int userID) {
		boolean f=false;
		try {
			Connection conn=ConnectionProvider.createConn();
			
			String q="delete from Distributor_Details where ID=?";
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

	
	public static void ShowAllDistributor() {
		
		try {
			Connection conn=ConnectionProvider.createConn();
			
			String q="select * from Distributor_Details";
			Statement stmt = conn.createStatement();
			
			// execute....
			ResultSet rs = stmt.executeQuery(q);
			  System.out.println("ID\t" +"Distributor_Name\t" +"Phone_no\t"+ "Address\t" + "\tMedicine_Name\t" + "\tQuantity\t" + "\t Wholesale_Price\t" + "  Selling_Price\t" + "  Total_Amount");
			   while(rs.next()) {
				   int id = rs.getInt("ID");
				   String name = rs.getString("Distributor_Name");
				   String phone = rs.getString("Phone_no");
				   String add = rs.getString("Address");
				   String M_name = rs.getString("Medicine_Name");
				   int qnty = rs.getInt("Quantity");
				   int whole = rs.getInt("Wholesale_Price");
				   int selling = rs.getInt("Selling_Price");
				   int total = rs.getInt("Total_Amount");
						   System.out.println(id +"\t\t"+ name+"\t\t" + phone+ "\t\t" + add + "\t\t" + M_name + "\t\t" + qnty + "\t\t" + whole+ "\t\t" + selling + "\t\t" + total);
			   }
			   System.out.println("\n\n");
				   rs.close();
				   stmt.close();
				   conn.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
