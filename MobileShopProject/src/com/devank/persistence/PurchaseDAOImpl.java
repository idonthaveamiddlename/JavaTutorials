package com.devank.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.devank.entity.Purchase;
import com.devank.util.ConnectionBuilder;

public class PurchaseDAOImpl implements PurchaseDAO {

	@Override
	public boolean makePurchase(Purchase purchase) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionBuilder.createConnectionObject();
		boolean returnStatus = false;
		PreparedStatement pStatement = connection.prepareStatement("INSERT INTO PURCHASE VALUES(?,?,?,?)");
		pStatement.setInt(1, purchase.getPurchaseID());
		pStatement.setInt(2, purchase.getCustomerID());
		pStatement.setInt(3, purchase.getModelID());
		pStatement.setString(4, purchase.getDateOfPurchase());
		int rows=pStatement.executeUpdate();
		if(rows>0)
			returnStatus=true;
		ConnectionBuilder.closeConnectionObject(connection);
		return returnStatus;
	}

	@Override
	public ArrayList<Purchase> getCustomerPurchases(int customerID) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionBuilder.createConnectionObject();
		ArrayList<Purchase> purchaseList = new ArrayList<>();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM PURCHASE WHERE cust_id=?");
		pStatement.setInt(1, customerID);
		ResultSet resultSet = pStatement.executeQuery();
		Purchase purchase = null;
		while(resultSet.next()) {
			int id = resultSet.getInt("purchase_id");
			int custID = resultSet.getInt("cust_id");
			int modelID = resultSet.getInt("model_id");
			String date = resultSet.getDate("date_of_purchase").toString();
			purchase = new Purchase(id,custID,modelID,date);
			purchaseList.add(purchase);
		}
		ConnectionBuilder.closeConnectionObject(connection);
		return purchaseList;
	}

	@Override
	public int countAllPurchases() throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionBuilder.createConnectionObject();
		int count=0;
		Statement statement = connection.createStatement();
		ResultSet resultset=statement.executeQuery("SELECT COUNT(*) FROM PURCHASE");
		if(resultset.next()) {
			count = resultset.getInt(1);
		}
		ConnectionBuilder.closeConnectionObject(connection);
		return count;
	}

}
