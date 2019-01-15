package com.devank.entity;

public class MobilePhone {

	private int serialNumber;
	private String brand;
	private String model;
	private int stockInHand;
	private int costInRupees;
	
	public MobilePhone() {};
	
	public MobilePhone(int serialNumber, String brand, String model, int stockInHand, int costInRupees) {
		super();
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.model = model;
		this.stockInHand = stockInHand;
		this.costInRupees = costInRupees;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
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

	public int getStockInHand() {
		return stockInHand;
	}

	public void setStockInHand(int stockInHand) {
		this.stockInHand = stockInHand;
	}

	public int getCostInRupees() {
		return costInRupees;
	}

	public void setCostInRupees(int costInRupees) {
		this.costInRupees = costInRupees;
	}

	@Override
	public String toString() {
		return "MobilePhone [serialNumber=" + serialNumber + ", brand=" + brand + ", model=" + model + ", stockInHand="
				+ stockInHand + ", costInRupees=" + costInRupees + "]";
	}
	
}
