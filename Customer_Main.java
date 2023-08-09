package com.medical.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Customer_Main {

	public static void Customer_Details()throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PREES 1 to ADD Customer");
			System.out.println("PREES 2 to Delete Customer");
			System.out.println("PREES 3 to Display AllCustomers");
			System.out.println("PREES 4 to Search Customer By Name");
			System.out.println("PREES 5 to Search Customer By ID");
			System.out.println("PREES 6 to Exit");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				System.out.println("Enter Customer Name");
				String name = br.readLine();
				System.out.println("Enter Date");
				String date = br.readLine();
				System.out.println("Enter Phone_no");
				String phone = br.readLine();
				System.out.println("Enter Age_Of_Patient");
				int age = Integer.parseInt(br.readLine());
				System.out.println("Enter Medicine_Name");
				String Medicine_name = br.readLine();
				System.out.println("Enter Quantity");
				int quantity = Integer.parseInt(br.readLine());
				CustomerBill cust = new CustomerBill(name,date,phone,age,Medicine_name,quantity);
				 boolean answer =  Customer_DB.insertCustomerToDB(cust,Medicine_name);
				 if(answer) {
					 System.out.println("\nCustomer Add Successfully");
				 }else
				 {
					 System.out.println("Something went Wrong try Again.....");
				 }
				  
				
			}else if(c==2) {
				// Delete Medicine
				System.out.println("Enter ID to Delete");
				int userID = Integer.parseInt(br.readLine());
				boolean f=Customer_DB.deleteCustomer(userID);
				if(f) {
					System.out.println("Deleted Successfully..........");
				}else {
					System.out.println("Something went wrong.....");
				}
			}else if(c==3) {
				Customer_DB.ShowAllCustomer();
			}else if(c==4) {
				System.out.println("Enter Customer Name");
				String name = br.readLine();
				Customer_DB.SearchCus(name);
				}else if(c==5) {
				
					System.out.println("Enter Customer ID");
					int id = Integer.parseInt(br.readLine());
					Customer_DB.SearchCustomerbyID(id);	
				}else if(c==6){
				
				System.exit(c);
			}
			else {
				
			}
}
		
	}
	
}


