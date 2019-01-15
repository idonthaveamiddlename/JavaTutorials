package com.devank.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import com.devank.entity.Purchase;

public interface PurchaseDAO {

	boolean makePurchase(Purchase purchase) throws ClassNotFoundException, SQLException;
	ArrayList<Purchase> getCustomerPurchases(int customerID) throws ClassNotFoundException, SQLException;
	int countAllPurchases() throws SQLException, ClassNotFoundException;
}
