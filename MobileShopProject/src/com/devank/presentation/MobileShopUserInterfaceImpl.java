package com.devank.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.devank.entity.CompletePurchaseRecord;
import com.devank.entity.MobilePhone;
import com.devank.service.MobileShopService;
import com.devank.service.MobileShopServiceImpl;
import com.devank.util.InputOutput;

public class MobileShopUserInterfaceImpl implements MobileShopUserInterface {

	private MobileShopService mobileShopService = new MobileShopServiceImpl();
	@Override
	public void showMenu() {
		System.out.println();
		System.out.println("1. See all available mobile phone models.");
		System.out.println("2. Purchase a model.");
		System.out.println("3. View a customer's purchase history.");
		System.out.println("4. Exit");
	}

	@Override
	public void perform(int choice) {
		Scanner sc=new Scanner(System.in);
		
		switch(choice) {
		
		case 1:
			try {
				ArrayList<MobilePhone> availableList = mobileShopService.getAvailableModels();
				InputOutput.displayModels(availableList);
				break;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		case 2:
			try {
				ArrayList<MobilePhone> availableList = mobileShopService.getAvailableModels();
				InputOutput.displayModels(availableList);
				System.out.println("Enter the model ID of the phone to be purchased: ");
				int modelID = sc.nextInt();
				System.out.println("Does the customer have a Customer ID? (y/Y/n/N) ");
				String idPresence = sc.next();
				int customerID;
				if(idPresence.equals("y") || idPresence.equals("Y")) {
					System.out.println("enter customer ID: ");
					customerID = sc.nextInt();
				}
				else {
					System.out.println("Enter customer name: ");
					String customerName = sc.next();
					System.out.println("Enter customer e-mail ID: ");
					String customerEmailID = sc.next();
					System.out.println("Enter customer mobile number: ");
					String customerPhoneNumber = sc.next();
					customerID = mobileShopService.createNewCustomer(customerName, customerEmailID, customerPhoneNumber);
					System.out.println("Hey "+customerName+", your user ID is: "+customerID);
				}
				boolean purchaseStatus = mobileShopService.purchaseModel(customerID, modelID);
				if(purchaseStatus)
					System.out.println("Purchase completed.");
				else
					System.out.println("Purchase not completed.");
				break;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		case 3:
			try {
				System.out.println("Enter customer ID of the customer to be viewed: ");
				int customerID = sc.nextInt();
				ArrayList<CompletePurchaseRecord> customerHistory = mobileShopService.customerHistory(customerID);
				InputOutput.displayCustomerHistory(customerHistory);
				break;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		case 4:
			System.out.println("Good Bye!!");
			sc.close();
			System.exit(0);
			
		default:
			System.out.println("Invalid Choice");
		}

	}

}
