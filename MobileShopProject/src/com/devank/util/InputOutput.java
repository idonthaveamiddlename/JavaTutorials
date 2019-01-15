package com.devank.util;

import java.util.ArrayList;
import com.devank.entity.*;

public class InputOutput {

	public static void displayModels(ArrayList<MobilePhone> modelList) {
		System.out.println("Available models: ");
		for(MobilePhone mobilePhone:modelList) {
			System.out.println("Model ID: "+mobilePhone.getSerialNumber());
			System.out.println("Model: "+mobilePhone.getBrand()+" "+mobilePhone.getModel());
			System.out.println("Remaining stock: "+mobilePhone.getStockInHand());
			System.out.println("Cost (Rs.): "+mobilePhone.getCostInRupees());
			System.out.println();
		}
	}
	
	public static void displayCustomerHistory(ArrayList<CompletePurchaseRecord> customerHistory) {
		for(CompletePurchaseRecord customerItem:customerHistory) {
			System.out.println("Customer name: "+customerItem.getCustomerName());
			System.out.println("Customer ID: "+customerItem.getCustomerID());
			System.out.println("Customer E-Mail ID: "+customerItem.getCustomerEmailID());
			System.out.println("Customer phone number: "+customerItem.getCustomerPhoneNumber());
			System.out.println();
			break;
		}
		for(CompletePurchaseRecord customerItem:customerHistory) {
			System.out.println("Purchase ID: "+customerItem.getPurchaseID());
			System.out.println("Model: "+customerItem.getBrand()+" "+customerItem.getModel());
			System.out.println("Model ID: "+customerItem.getModelID());
			System.out.println("Cost (Rs.) : "+customerItem.getCostInRupees());
			System.out.println();
		}
	}
}
