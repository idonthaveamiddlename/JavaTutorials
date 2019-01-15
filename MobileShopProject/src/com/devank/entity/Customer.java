package com.devank.entity;

public class Customer {

	private int customerID;
	private String customerName;
	private String customerEmailID;
	private String customerPhoneNumber;
	
	public Customer() {};
	
	public Customer(int customerID, String customerName, String customerEmailID, String customerPhoneNumber) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmailID = customerEmailID;
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerEmailID="
				+ customerEmailID + ", customerPhoneNumber=" + customerPhoneNumber + "]";
	}
}
