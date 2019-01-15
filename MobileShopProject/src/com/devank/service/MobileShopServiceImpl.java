package com.devank.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.devank.entity.CompletePurchaseRecord;
import com.devank.entity.Customer;
import com.devank.entity.MobilePhone;
import com.devank.entity.Purchase;
import com.devank.persistence.CustomerDAO;
import com.devank.persistence.CustomerDAOImpl;
import com.devank.persistence.MobilePhoneDAO;
import com.devank.persistence.MobilePhoneDAOImpl;
import com.devank.persistence.PurchaseDAO;
import com.devank.persistence.PurchaseDAOImpl;
import com.devank.util.DateHelper;

public class MobileShopServiceImpl implements MobileShopService{

	CustomerDAO customerDAO = new CustomerDAOImpl();
	MobilePhoneDAO mobilePhoneDAO = new MobilePhoneDAOImpl();
	PurchaseDAO purchaseDAO = new PurchaseDAOImpl();
	
	@Override
	public ArrayList<MobilePhone> getAvailableModels() throws ClassNotFoundException, SQLException {
		return mobilePhoneDAO.getAllModels();
	}

	@Override
	public int createNewCustomer(String customerName, String customerEmailID, String customerPhoneNumber) throws ClassNotFoundException, SQLException {
		boolean returnStatus = false;
		int customerID = customerDAO.countTotalRecords();
		Customer customer = new Customer(customerID,customerName,customerEmailID,customerPhoneNumber);
		returnStatus = customerDAO.createCustomerRecord(customer);
		if(returnStatus)
			return customerID;
		return -1;
	}

	@Override
	public boolean purchaseModel(int customerID, int modelID) throws ClassNotFoundException, SQLException{
		boolean purchaseStatus = false;
		boolean stockUpdateStatus = false;
		int purchaseID = purchaseDAO.countAllPurchases();
		Date now = new Date();
		String date = DateHelper.convertToSQLFormat(now);
		MobilePhone mobilePhone = mobilePhoneDAO.returnModel(modelID);
		if(mobilePhone.getStockInHand()<=0)
			return false;
		Purchase purchase = new Purchase(purchaseID,customerID,modelID,date);
		purchaseStatus = purchaseDAO.makePurchase(purchase);
		if(purchaseStatus)
			stockUpdateStatus = mobilePhoneDAO.updateStockAvailable(mobilePhone);
		return (purchaseStatus && stockUpdateStatus);
	}

	@Override
	public ArrayList<CompletePurchaseRecord> customerHistory(int customerID) throws ClassNotFoundException, SQLException{
		ArrayList<CompletePurchaseRecord> cumulativeList = new ArrayList<>();
		ArrayList<Purchase> purchaseList = purchaseDAO.getCustomerPurchases(customerID);
		Customer customer = customerDAO.returnCustomerRecord(customerID);
		int modelID;
		for(Purchase purchase:purchaseList) {
			modelID = purchase.getModelID();
			MobilePhone mobilePhone = mobilePhoneDAO.returnModel(modelID);
			CompletePurchaseRecord completePurchaseRecord = new CompletePurchaseRecord(mobilePhone,customer,purchase);
			cumulativeList.add(completePurchaseRecord);
		}
		return cumulativeList;
	}

}
