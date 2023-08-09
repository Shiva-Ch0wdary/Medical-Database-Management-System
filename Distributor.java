package com.medical.manage;

public class Distributor {
	  private int ID;
	    private String DistributorName;
	    private String Phone_No;
	    private String Address;
	    private String Medicine_Name;
	    private int Quantity;
	    private int Wholesale_price;
	    private int Selling_Price;
	    private int Total_Amount;
		public Distributor(int iD, String distributorName, String phone_No, String address, String medicine_Name,
				int quantity, int wholesale_price, int selling_Price, int total_Amount) {
			super();
			ID = iD;
			DistributorName = distributorName;
			Phone_No = phone_No;
			Address = address;
			Medicine_Name = medicine_Name;
			Quantity = quantity;
			Wholesale_price = wholesale_price;
			Selling_Price = selling_Price;
			Total_Amount = total_Amount;
		}
		public Distributor(String distributorName, String phone_No, String address, String medicine_Name, int quantity,
				int wholesale_price, int selling_Price, int total_Amount) {
			super();
			DistributorName = distributorName;
			Phone_No = phone_No;
			Address = address;
			Medicine_Name = medicine_Name;
			Quantity = quantity;
			Wholesale_price = wholesale_price;
			Selling_Price = selling_Price;
			Total_Amount = total_Amount;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public String getDistributorName() {
			return DistributorName;
		}
		public void setDistributorName(String distributorName) {
			DistributorName = distributorName;
		}
		public String getPhone_No() {
			return Phone_No;
		}
		public void setPhone_No(String phone_No) {
			Phone_No = phone_No;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public String getMedicine_Name() {
			return Medicine_Name;
		}
		public void setMedicine_Name(String medicine_Name) {
			Medicine_Name = medicine_Name;
		}
		public int getQuantity() {
			return Quantity;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
		public int getWholesale_price() {
			return Wholesale_price;
		}
		public void setWholesale_price(int wholesale_price) {
			Wholesale_price = wholesale_price;
		}
		public int getSelling_Price() {
			return Selling_Price;
		}
		public void setSelling_Price(int selling_Price) {
			Selling_Price = selling_Price;
		}
		public int getTotal_Amount() {
			return Total_Amount;
		}
		public void setTotal_Amount(int total_Amount) {
			Total_Amount = total_Amount;
		}
		@Override
		public String toString() {
			return "Distributor [ID=" + ID + ", DistributorName=" + DistributorName + ", Phone_No=" + Phone_No
					+ ", Address=" + Address + ", Medicine_Name=" + Medicine_Name + ", Quantity=" + Quantity
					+ ", Wholesale_price=" + Wholesale_price + ", Selling_Price=" + Selling_Price + ", Total_Amount="
					+ Total_Amount + "]";
		}
		
}
