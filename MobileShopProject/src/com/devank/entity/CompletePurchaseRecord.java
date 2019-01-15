package com.devank.entity;

public class CompletePurchaseRecord {

	private int purchaseID;
	private int customerID;
	private int modelID;
	private String customerName;
	private String customerEmailID;
	private String customerPhoneNumber;
	private String brand;
	private String model;
	private int costInRupees;
	
	public CompletePurchaseRecord() {};
	
	public CompletePurchaseRecord(MobilePhone mobilePhone, Customer customer, Purchase purchase) {
		this.purchaseID = purchase.getPurchaseID();
		this.customerID = customer.getCustomerID();
		this.modelID = mobilePhone.getSerialNumber();
		this.customerName = customer.getCustomerName();
		this.customerEmailID = customer.getCustomerEmailID();
		this.customerPhoneNumber = customer.getCustomerPhoneNumber();
		this.brand = mobilePhone.getBrand();
		this.model = mobilePhone.getModel();
		this.costInRupees = mobilePhone.getCostInRupees();
	}

	public int getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getModelID() {
		return modelID;
	}

	public void setModelID(int modelID) {
		this.modelID = modelID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailID() {
		return customerEmailID;
	}

	public void setCustomerEmailID(String customerEmailID) {
		this.customerEmailID = customerEmailID;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCostInRupees() {
		return costInRupees;
	}

	public void setCostInRupees(int costInRupees) {
		this.costInRupees = costInRupees;
	}

	@Override
	public String toString() {
		return "CompletePurchaseRecord [purchaseID=" + purchaseID + ", customerID=" + customerID + ", modelID="
				+ modelID + ", customerName=" + customerName + ", customerEmailID=" + customerEmailID
				+ ", customerPhoneNumber=" + customerPhoneNumber + ", brand=" + brand + ", model=" + model
				+ ", costInRupees=" + costInRupees + "]";
	}
	
	
}
