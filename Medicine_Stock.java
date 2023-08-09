package com.medical.manage;
import java.sql.*;
import java.sql.DriverManager;
public class Medicine_Stock {
	private int medicineID;
    public Medicine_Stock(int medicineID, String medicineName, int current_stock, int sold_stock, String profit_loss) {
		super();
		this.medicineID = medicineID;
		MedicineName = medicineName;
		Current_stock = current_stock;
		Sold_stock = sold_stock;
		this.profit_loss = profit_loss;
	}
	private String MedicineName;
    private int Current_stock;
    private int Sold_stock;
    private String profit_loss;
	public Medicine_Stock(String medicineName, int current_stock, int sold_stock, String profit_loss) {
		super();
		MedicineName = medicineName;
		Current_stock = current_stock;
		Sold_stock = sold_stock;
		this.profit_loss = profit_loss;
	}
	public Medicine_Stock() {
		super();
	}
	public int getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}
	public String getMedicineName() {
		return MedicineName;
	}
	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}
	public int getCurrent_stock() {
		return Current_stock;
	}
	public void setCurrent_stock(int current_stock) {
		Current_stock = current_stock;
	}
	public int getSold_stock() {
		return Sold_stock;
	}
	public void setSold_stock(int sold_stock) {
		Sold_stock = sold_stock;
	}
	public String getProfit_loss() {
		return profit_loss;
	}
	public void setProfit_loss(String profit_loss) {
		this.profit_loss = profit_loss;
	}
    
    
    
}
