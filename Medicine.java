package com.medical.manage;

public  class Medicine {
    private int medicineID;
    private String MedicineName;
    private String MedicineType;
    private String MGF_Date;
    private String Expiray_Date;
    private int Cost_Per_Strip;
	public Medicine(int medicineID, String medicineName, String medicineType, String mGF_Date, String expiray_Date,
			int cost_per_strip) {
		super();
		this.medicineID = medicineID;
		MedicineName = medicineName;
		MedicineType = medicineType;
		MGF_Date = mGF_Date;
		Expiray_Date = expiray_Date;
		Cost_Per_Strip=cost_per_strip;
	}
	public Medicine(String medicineName, String medicineType, String mGF_Date, String expiray_Date,
			int cost_per_strip) {
		super();
		MedicineName = medicineName;
		MedicineType = medicineType;
		MGF_Date = mGF_Date;
		Expiray_Date = expiray_Date;
		Cost_Per_Strip = cost_per_strip;
	}
	public Medicine() {
		super();
	}
	@Override
	public String toString() {
		return "Medicine [medicineID=" + medicineID + ", MedicineName=" + MedicineName + ", MedicineType="
				+ MedicineType + ", MGF_Date=" + MGF_Date + ", Expiray_Date=" + Expiray_Date + ", Cost_Per_Strip="
				+ Cost_Per_Strip + "]";
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
	public String getMedicineType() {
		return MedicineType;
	}
	public void setMedicineType(String medicineType) {
		MedicineType = medicineType;
	}
	public String getMGF_Date() {
		return MGF_Date;
	}
	public void setMGF_Date(String mGF_Date) {
		MGF_Date = mGF_Date;
	}
	public String getExpiray_Date() {
		return Expiray_Date;
		}
	public void setExpiray_Date(String expiray_Date) {
		Expiray_Date = expiray_Date;
	}
	public int getCost_Per_Strip() {
		return Cost_Per_Strip;
	}
	public void setCost_Per_Strip(int cost) {
		Cost_Per_Strip = cost;
	}
	
	}
    	

