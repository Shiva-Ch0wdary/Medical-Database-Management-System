package com.medical.manage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Distributor_Main{
	
		public static void Distributor_Details()throws IOException  {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PREES 1 to ADD Distributor");
			System.out.println("PREES 2 to Delete Distributor");
//			System.out.println("PREES 3 to UpdteDistributorDetails");
			System.out.println("PREES 3 to Display AllDistributor");
			System.out.println("PREES 4 to Exit");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				System.out.println("Enter Distributor Name");
				String name = br.readLine();
				System.out.println("Enter Phone_no");
				String phone = br.readLine();
				
				System.out.println("Enter Address");
				String address = br.readLine();
				System.out.println("Enter Medicine_Name");
				String Medicine_name = br.readLine();
				System.out.println("Enter Quantity");
				int quantity = Integer.parseInt(br.readLine());
				System.out.println("Enter Wholesale_Price");
				int wholesale = Integer.parseInt(br.readLine());
				System.out.println("Enter Selling_Price");
				int selling = Integer.parseInt(br.readLine());
				System.out.println("Enter Total_Amount");
				int total = Integer.parseInt(br.readLine());
				
				Distributor dr = new Distributor(name,phone,address,Medicine_name,quantity,wholesale,selling,total);
				 boolean answer =  Distributor_DB.insertDistributorToDB(dr);
				 if(answer) {
					 System.out.println("\nDistributor Add Successfully");
				 }else
				 {
					 System.out.println("Something went Wrong try Again.....");
				 }
				  
				
			}else if(c==2) {
				// Delete Medicine
				System.out.println("Enter ID to Delete");
				int userID = Integer.parseInt(br.readLine());
				boolean f=Distributor_DB.deleteMedicine(userID);
				if(f) {
					System.out.println("Deleted Successfully..........");
				}else {
					System.out.println("Something went wrong.....");
				}
			}else if(c==3) {
				Distributor_DB.ShowAllDistributor();
			}else if(c==4) {
//				exit
				System.exit(c);
			}
			else {
				
			}
}
		
	}
		
}
