package com.medical.manage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Medicine_Stock_Main {
		public static void Medicine_stock_main()throws IOException  {
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("PREES 1 to Delete Medicine_Stock");
				System.out.println("PREES 2 to UpdteMedicine_Stock");
				System.out.println("PREES 3 to Display AllMedicine");
				System.out.println("PREES 4 to Exit");
				int c = Integer.parseInt(br.readLine());
				 
				if(c==1) {
					// Delete Medicine
					System.out.println("Enter Medicine to Delete");
					int userID = Integer.parseInt(br.readLine());
					boolean f=Medicine_Stock_DB.deleteMedicine_Stock(userID);
					if(f) {
						System.out.println("Deleted Successfully..........");
					}else {
						System.out.println("Something went wrong.....");
					}
				}
				else if(c==3) {
					Medicine_Stock_DB.Medicine_Stock();
				}
				else if(c==2) {
					System.out.println("Enter Medicine_ID to Update");
					int userID = Integer.parseInt(br.readLine());
					 System.out.println("Enter medicine name");
					  String name = br.readLine();
					  
		    		  System.out.println("Enter Curent_Stock");
		    		  int current=Integer.parseInt(br.readLine());
					  System.out.println("Enter Sold_Stock");
					  int sold=Integer.parseInt(br.readLine());
					  System.out.println("Enter profit_loss");
					  String profit=br.readLine();
					boolean f=Medicine_Stock_DB.UpdateMedicine_Stock(userID,name,current,sold,profit);
					if(f) {
						System.out.println("Update Successfully..........");
					}else {
						System.out.println("Something went wrong.....");
					}
					
				}else if(c==4){
					// exit
					System.exit(c); 
					}
				
					else {
						
					}
				}   }		
			}



