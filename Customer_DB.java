package com.medical.manage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

	public class Customer_DB {
		
		public static boolean insertCustomerToDB(CustomerBill cust,String Medicine_Name) {
			
			boolean f=false;
			int pr=0;
			
			String q="insert into CustomerDetails(Customer_Name,Date,Phone_No,Age_Of_Patient,Medicine_Name,Quantity,Cost_Per_Strip,Total) values(?,?,?,?,?,?,?,?)";
			String p="select Cost_Per_Strip from medicine_Details where Medicine_Name =?";
			try {
				Connection con=ConnectionProvider.createConn();
				PreparedStatement stmt = con.prepareStatement(p);
				stmt.setString(1,Medicine_Name);
		          ResultSet rs = stmt.executeQuery();
		          if(rs.next()) {
		           pr=rs.getInt("Cost_Per_Strip");
		           System.out.println(pr);
		          }
		          System.out.println(pr);
		          stmt.close();
		          con.close();
		          if(pr!=0) {
				//PreparedStatement
		          cust.setCost_Per_Strip(pr);
		          Connection conn=ConnectionProvider.createConn();  
				PreparedStatement pstmt = conn.prepareStatement(q);
				// set the values of parameter
				pstmt.setString(1, cust.getCustomer_Name());
				pstmt.setString(2, cust.getDate());
				pstmt.setString(3, cust.getPhone_No());
				pstmt.setInt(4, cust.getAge_Of_Patient());
	    		pstmt.setString(5, cust.getMedicine_Name());
				pstmt.setInt(6, cust.getQuantity());
				pstmt.setInt(7,cust.getCost_Per_Strip());
				pstmt.setInt(8, cust.gettotalBill());
				// execute....
				pstmt.executeUpdate();
				f=true;
		          }
		          if(f==false) {
		        	  System.out.println("Medicine is not aviable in Medical Store Please Check medicine details\n");
		          }
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return f;
		}
		public static boolean deleteCustomer(int userID) {
			boolean f=false;
			try {
				Connection conn=ConnectionProvider.createConn();
				
				String q="delete from CustomerDetails where ID=?";
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

		public static int StringCount(String str) {
			int count=0;
			for(int i = 0;i< str.length();i++) {
				if(str.charAt(i) !=' ')
					count++;
			}
			return count;
		}
		
		public static int  NumberCount(int cn) {
			int count = 0;
			for(;cn != 0; cn /=10, ++count);
          return count;			
		}
		public static void ShowAllCustomer() {
			
			try {
				Connection conn=ConnectionProvider.createConn();
				
				String q="SELECT * FROM CustomerDetails";
				Statement stmt = conn.createStatement();
				
				// execute....
				ResultSet rs = stmt.executeQuery(q);
				
				  System.out.println("| ID            |" +" Customer_Name |" + " Date          |" + " Phone_no      |"+ " Age_Patient   |" + " Medicine_Name |" + " Quantity      |" + "Cost_Per_Strip |" + " Total       |");
				   while(rs.next()) {
					   int count;
					   char c=32;
					   int id = rs.getInt("ID");
					   String name = rs.getString("Customer_Name");
					   String date = rs.getString("Date");
					   String phone = rs.getString("Phone_no");
					   String age = rs.getString("Age_Of_Patient");
					   String M_name = rs.getString("Medicine_Name");
					   int qnty = rs.getInt("Quantity");
					   int cost = rs.getInt("Cost_Per_Strip");
					   int total = rs.getInt("Total");
					   System.out.print("|");
					   System.out.print(id);
					   count=NumberCount(id);
					   int space=15-count;
					   for(int i=0;i<space;i++) {
					   System.out.print(c);
					   }
					   System.out.print("|");
					   System.out.print(name);
					   count=StringCount(name);
					  
					   space=15-count;
					   for(int i=0;i<space;i++) {
					   System.out.print(c);
					   }
					   System.out.print("|");
					   System.out.print(date);
					   count=StringCount(date);
					  
					   space=15-count;
					   for(int i=0;i<space;i++) {
					   System.out.print(c);
					   }
					   System.out.print("|");
					   System.out.print(phone);
					   count=StringCount(phone);
					  
					   space=15-count;
					   for(int i=0;i<space;i++) {
					   System.out.print(c);
					   }
					   System.out.print("|");
					   System.out.print(age);
					   count=StringCount(age);
					  
					   space=15-count;
					   for(int i=0;i<space;i++) {
					   System.out.print(c);
					   }
					   System.out.print("|");
					   System.out.print(M_name);
					   count=StringCount(M_name);
					  
					   space=15-count;
					   for(int i=0;i<space;i++) {
					   System.out.print(c);
					   }
					   System.out.print("|");
					   System.out.print(qnty);
					   count=NumberCount(qnty);
					   space=15-count;
					   for(int i=0;i<space;i++) {
					   System.out.print(c);
					   }
					   System.out.print("|");
					   System.out.print(cost);
					   count=NumberCount(cost);
					   space=15-count;
					   for(int i=0;i<space;i++) {
					   System.out.print(c);
					   }
					   System.out.print("|");
					   System.out.print(total);
					   count=NumberCount(total);
					   space=15-count;
					   for(int i=0;i<space;i++) {
					   System.out.print(c);
					   }
					   System.out.print("|\n");
					   
//							   System.out.println(id +"\t"+ name+"\t"+ date + "\t" + phone+ "\t" + age + "\t" + M_name + "\t" + qnty + "\t" + cost  + "\t" + total);
					   
				   }
				   System.out.println("\n\n");
					   rs.close();
					   stmt.close();
					   conn.close();

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void SearchCus(String Cus_name) {
			try {
				Connection conn = ConnectionProvider.createConn();
				String q = "select * from customerdetails where Customer_Name = ?";
				PreparedStatement st = conn.prepareStatement(q);
				st.setString(1,Cus_name);
				ResultSet rs = st.executeQuery();
				  System.out.println("Customer_ID\t\t" +"Customer_Name\t\t" +"Date\t\t"+ "Phone_No\t\t" + "Age_Of_Patient\t\t"+"Medicine_Nmae\t\t"+"Quantity"+ "Cost_Per_Strip\t\t"+"Total");
				   while(rs.next()) {
					   int id = rs.getInt("ID");
					   String name = rs.getString("Customer_Name");
					   String date = rs.getString("Date");
					   String phone = rs.getString("Phone_No");
					   String age = rs.getString("Age_Of_Patient");
					   String M_name = rs.getString("Medicine_Name");
					   int qnty = rs.getInt("Quantity");
					   int cost = rs.getInt("Cost_Per_Strip");
					   int total = rs.getInt("Total");
					   
					   System.out.println(id +"\t"+ name+"\t"+ date + "\t" + phone+ "\t" + age + "\t" + M_name + "\t" + qnty + "\t" + cost  + "\t" + total);
				   }
				   
				   System.out.println("\n\n");
					   rs.close();
					   st.close();
					   conn.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		
			
		}

		
		
		public static void SearchCustomerbyID(int Cus_ID) {
			try {
				Connection conn = ConnectionProvider.createConn();
				String q = "select * from customerdetails where ID = ?";
				PreparedStatement st = conn.prepareStatement(q);
				st.setInt(1,Cus_ID);
				ResultSet rs = st.executeQuery();
				  System.out.println("Customer_ID\t\t" +"Customer_Name\t\t" +"Date\t\t"+ "Phone_No\t\t" + "Age_Of_Patient\t\t"+"Medicine_Nmae\t\t"+"Quantity"+ "Cost_Per_Strip\t\t"+"Total");
				   while(rs.next()) {
					   int id = rs.getInt("ID");
					   String name = rs.getString("Customer_Name");
					   String date = rs.getString("Date");
					   String phone = rs.getString("Phone_No");
					   String age = rs.getString("Age_Of_Patient");
					   String M_name = rs.getString("Medicine_Name");
					   int qnty = rs.getInt("Quantity");
					   int cost = rs.getInt("Cost_Per_Strip");
					   int total = rs.getInt("Total");
					   
					   System.out.println(id +"\t"+ name+"\t"+ date + "\t" + phone+ "\t" + age + "\t" + M_name + "\t" + qnty + "\t" + cost  + "\t" + total);
				   }
				   
				   System.out.println("\n\n");
					   rs.close();
					   st.close();
					   conn.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		
			
		}

		
	}


