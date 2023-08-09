package com.medical.manage;

abstract class Customer_Details {
	    protected int ID;
	    protected String Customer_Name;
	    protected String Date;
	    protected String Phone_No;
	    protected int Age_Of_Patient;
	    protected String Medicine_Name;
	    protected int Quantity;
	    
		public Customer_Details(String customer_Name, String date, String phone_No, int age_Of_Patient,String medicine_Name, int quantity) {
			this.Customer_Name = customer_Name;
			this.Date = date;
			this.Phone_No = phone_No;
			this.Age_Of_Patient = age_Of_Patient;
			this.Medicine_Name = medicine_Name;
			this.Quantity = quantity;
		}
		public abstract int gettotalBill();
		public Customer_Details() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
class CustomerBill extends Customer_Details{
	public int cost_per_strip;
	public CustomerBill(String customer_Name,String date, String phone_No,int age,String medicine_name, int quantity) {
		super(customer_Name,date,phone_No,age,medicine_name,quantity);
	}
	public CustomerBill() {
		super();
	}
	@Override
	public int gettotalBill() {
	return (cost_per_strip*Quantity);
	}
	
	   
		public String getCustomer_Name() {
			return Customer_Name;
		}
		public void setCustomer_Name(String customer_Name) {
			Customer_Name = customer_Name;
		}
		public String getDate() {
			return Date;
		}
       public void setDate(String date) {
			Date = date;
		}
		public String getPhone_No() {
			return Phone_No;
		}
		public void setPhone_No(String phone_No) {
			Phone_No = phone_No;
		}
		public int getAge_Of_Patient() {
			return Age_Of_Patient;
		}
		public void setAge_Of_Patient(int age_Of_Patient) {
			Age_Of_Patient = age_Of_Patient;
		}
		public String getMedicine_Name() {
			return Medicine_Name;
		}
		public void setMedicine_Name(String medicine_Name) {
			Medicine_Name = medicine_Name;
		}
        public  int getQuantity() {
			return super.Quantity;
		}
		public void setQuantity(int quantity) {
			super.Quantity = quantity;
		}
		public void setCost_Per_Strip(int cost_Per_Strip) {
			cost_per_strip = cost_Per_Strip;
		}
		public int getCost_Per_Strip() {
			return cost_per_strip;
		}
		
		@Override
		public String toString() {
			return "Customer_Details [ID=" + ID + ", Customer_Name=" + Customer_Name + ", Date=" + Date + ", Phone_No="
					+ Phone_No + ", Age_Of_Patient=" + Age_Of_Patient + ", Medicine_Name=" + Medicine_Name
					+ ", Quantity=" + Quantity + ", Cost_Per_Strip=" + ", Total=" + "]";
		}
}
