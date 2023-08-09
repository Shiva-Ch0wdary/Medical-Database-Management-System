package com.medical.manage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Medical_Main {
	
	public static void main(String[] args)throws IOException {
		System.out.println("Welcome to Medical Store Application..");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1. Customer_Details");
			System.out.println("2. Medicine_Stock");
			System.out.println("3. Distributor_Details");
			System.out.println("4. Stock_management");
			System.out.println("5. exit");
			int c = Integer.parseInt(br.readLine());
			switch(c) {
			case 1:
				Customer_Main.Customer_Details();
				break;
			case 2:
				Medicine_Main.Medicine_Stock();
				break;
			case 3:
				Distributor_Main.Distributor_Details();
				break;
			case 4:
				
				Medicine_Stock_Main.Medicine_stock_main();
			case 5:
				System.exit(c);
             default:
            	 System.out.println("Please select right Key");
			}		
		
	}
}
}