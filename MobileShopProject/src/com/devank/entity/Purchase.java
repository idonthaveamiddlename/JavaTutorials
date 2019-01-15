package com.devank.entity;

public class Purchase {

	private int purchaseID;
	private int customerID;
	private int modelID;
	private String dateOfPurchase;
	
	public Purchase() {}

	public Purchase(int purchaseID, int customerID, int modelID, String dateOfPurchase) {
		super();
		this.purchaseID = purchaseID;
		this.customerID = customerID;
		this.modelID = modelID;
		this.dateOfPurchase = dateOfPurchase;
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

	public String getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseID=" + purchaseID + ", customerID=" + customerID + ", modelID=" + modelID
				+ ", dateOfPurchase=" + dateOfPurchase + "]";
	};
}
