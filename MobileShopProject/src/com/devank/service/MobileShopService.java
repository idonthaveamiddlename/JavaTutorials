package com.devank.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.devank.entity.*;

public interface MobileShopService {

	ArrayList<MobilePhone> getAvailableModels() throws ClassNotFoundException, SQLException;
	int createNewCustomer(String customerName,String customerEmailID,String customerPhoneNumber) throws ClassNotFoundException, SQLException;
	boolean purchaseModel(int customerID,int modelID) throws ClassNotFoundException, SQLException;
	ArrayList<CompletePurchaseRecord> customerHistory(int customerID) throws ClassNotFoundException, SQLException;
}
