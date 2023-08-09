package com.medical.manage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Medicine_Main {
	public static void Medicine_Stock()throws IOException  {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PREES 1 to ADD medicine");
			System.out.println("PREES 2 to Delete Medicine");
			System.out.println("PREES 3 to UpdteMedicine");
			System.out.println("PREES 4 to Display AllMedicine");
			System.out.println("PREES 5 to Display Search_Medicine_By_Name");
			System.out.println("PREES 6 to Exit");
			int c = Integer.parseInt(br.readLine());
			 
			if(c==1) {
				  System.out.println("Enter medicine name");
				  String Medicine_Name = br.readLine();
				  
				  System.out.println("Enter MedicineType");
				  String MedicineType=br.readLine();
	    		  System.out.println("Enter MFG_Date");
	    		  String MFG_Date=br.readLine();
				  System.out.println("Enter Expiry_Date");
				  String Expiry_Date=br.readLine();
				  System.out.println("Enter Cost_Per_Strip");
				  int Cost_Per_Strip=Integer.parseInt(br.readLine());
				  
				  // create medicine object to store medicine
				  Medicine md=new Medicine(Medicine_Name,MedicineType,MFG_Date,Expiry_Date,Cost_Per_Strip);
				  
				 boolean answer =  Medicine_DB.insertMedicineToDB(md);
				 if(answer) {
					 System.out.println("Medicine Add Successfully");
				 }else
				 {
					 System.out.println("Something went Wrong try Again.....");
				 }
			}
			else if(c==2) {
				// Delete Medicine
				System.out.println("Enter Medicine to Delete");
				int userID = Integer.parseInt(br.readLine());
				boolean f=Medicine_DB.deleteMedicine(userID);
				if(f) {
					System.out.println("Deleted Successfully..........");
				}else {
					System.out.println("Something went wrong.....");
				}
			}
			else if(c==4) {
				Medicine_DB.ShowAllMedicine();
			}
			else if(c==3) {
				System.out.println("Enter Medicine_ID to Update");
				int userID = Integer.parseInt(br.readLine());
				String name = br.readLine();
				String Type = br.readLine();
				String MFG = br.readLine();
				String Expiry = br.readLine();
				int Cost_Per_Strip = Integer.parseInt(br.readLine());
				boolean f=Medicine_DB.UpdateMedicine(userID,name,Type,MFG,Expiry,Cost_Per_Strip);
				if(f) {
					System.out.println("Update Successfully..........");
				}else {
					System.out.println("Something went wrong.....");
				}
				
			}else if(c==5) {
				System.out.println("Enter Medicine Name");
				String Mname = br.readLine();
				boolean f=Medicine_DB.SearchMedicine(Mname);
			}else if(c==6){
				// exit
				System.exit(c); 
				}
			
				else {
					
				}
			}   }		
		}

