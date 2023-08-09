package com.medical.manage;
import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Medicine_DB {

	public static boolean insertMedicineToDB(Medicine md) {
		
		boolean f=false;
		int pr=0;
		try {
			Connection conn=ConnectionProvider.createConn();
			
			String q="insert into Medicine_Details(Medicine_Name,Medicine_Type,MFG_Date,Expiry_Date,Cost_Per_Strip) values(?,?,?,?,?)";
			String p="select Medicine_ID from medicine_Details where Medicine_Name =?";
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			// set the values of parameter
		
			pstmt.setString(1, md.getMedicineName());
			pstmt.setString(2, md.getMedicineType());
			pstmt.setString(3, md.getMGF_Date());
    		pstmt.setString(4, md.getExpiray_Date());
			pstmt.setInt(5, md.getCost_Per_Strip());
			
			// execute....
			pstmt.executeUpdate();
			f=true;
			
			pstmt.close();
			
		
		if(f==true) {
			PreparedStatement stmt = conn.prepareStatement(p);
			stmt.setString(1,md.getMedicineName());
	          ResultSet rs = stmt.executeQuery();
	          if(rs.next()) {
	           pr=rs.getInt("Medicine_ID");
	           System.out.println(pr);
	          }
	          stmt.close();
	          conn.close();
			System.out.println("You have to Add Medicine in Medicine_Stock\n please Enter same Medicine_Name");
			InsertIntoMedicineStock(pr);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public static void InsertIntoMedicineStock(int ID)throws IOException
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  System.out.println("Enter medicine name");
		  String name = br.readLine();
		  
		  System.out.println("Enter Curent_Stock");
		  int current=Integer.parseInt(br.readLine());
		  System.out.println("Enter Sold_Stock");
		  int sold=Integer.parseInt(br.readLine());
		  System.out.println("Enter profit_loss");
		  String profit=br.readLine();
		  
		  // create medicine object to store medicine
		  Medicine_Stock md=new Medicine_Stock(ID,name,current,sold,profit);
		  
		 boolean answer =  Medicine_Stock_DB.Medicine_Stock(md);
		 if(answer) {
			 System.out.println("Stock Add Successfully");
		 }else
		 {
			 System.out.println("Something went Wrong try Again.....");
		 }
		  
		 System.out.println(md);
			
		}
		
	public static boolean deleteMedicine(int userID) {
	boolean f=false;
	try {
		Connection conn=ConnectionProvider.createConn();
		
		String q="delete from Medicine_Details where Medicine_ID=?";
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
	
	public static void ShowAllMedicine() {
	
		try {
			Connection conn=ConnectionProvider.createConn();
			String q="select * from Medicine_Details";
			Statement stmt = conn.createStatement();
			
			// execute....
			ResultSet rs = stmt.executeQuery(q);
			  System.out.println("Medicine_ID\t\t" +"Medicine_Name\t\t" +"Medicine_Type\t\t"+ "MFG_Date\t\t" + "Expiry_Date\t\t" + "Cost_Per_Strip");
			   while(rs.next()) {
				   int id = rs.getInt("Medicine_ID");
				   String Medicine_Name = rs.getString("Medicine_Name");
				   String Medicine_Type = rs.getString("Medicine_Type");
				   String MFG_Date = rs.getString("MFG_Date");
				   String Expiry_Date = rs.getString("Expiry_Date");
				   int Cost_Per_Strip = rs.getInt("Cost_Per_Strip");
						   System.out.println(id +"\t"+ Medicine_Name+"\t" + Medicine_Type+ "\t" + MFG_Date + "\t" + Expiry_Date + "\t" + Cost_Per_Strip);
			   }
			   System.out.println("\n\n");
				   rs.close();
				   stmt.close();
				   conn.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean UpdateMedicine(int userID, String name, String Type, String MFG, String Expiry,int Cost_Per_Strip) {
		boolean f=false;
		try {
			Connection conn=ConnectionProvider.createConn();
			
			String q="update Medicine_Details  set Medicine_Name=? , Medicine_Type=? , MFG_Date=? , Expiry_Date=? ,Cost_Per_Strip=? where Medicine_ID=?";
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			// set the values of parameter
			pstmt.setInt(7, userID);
			pstmt.setString(1, name);
			pstmt.setString(2, Type);
			pstmt.setString(3,MFG);
			pstmt.setString(4,Expiry);
			pstmt.setInt(5, Cost_Per_Strip);
			// execute....
			pstmt.executeUpdate();
			f=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public static boolean SearchMedicine(String Medicine) {
		boolean f=true;
		try {
			Connection conn = ConnectionProvider.createConn();
			String q = "select * from Medicine_details where Medicine_Name = ?";
			PreparedStatement st = conn.prepareStatement(q);
			st.setString(1,Medicine);
			ResultSet rs = st.executeQuery();
			  System.out.println("Medicine_ID\t\t" +"Medicine_Name\t\t" +"Medicine_Type\t\t"+ "MFG_Date\t\t" + "Expiry_Date\t\t" + "Cost_Per_Strip");
			   while(rs.next()) {
				   int id = rs.getInt("Medicine_ID");
				   String Medicine_Name = rs.getString("Medicine_Name");
				   String Medicine_Type = rs.getString("Medicine_Type");
				   String MFG_Date = rs.getString("MFG_Date");
				   String Expiry_Date = rs.getString("Expiry_Date");
				   int Cost_Per_Strip = rs.getInt("Cost_Per_Strip");
				   System.out.println(id +"\t"+ Medicine_Name+"\t" + Medicine_Type+ "\t" + MFG_Date + "\t" + Expiry_Date + "\t" + Cost_Per_Strip);
			   }
			   System.out.println("\n\n");
				   rs.close();
				   st.close();
				   conn.close();

		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return f;
	}
}