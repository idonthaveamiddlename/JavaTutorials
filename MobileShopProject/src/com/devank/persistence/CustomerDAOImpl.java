package com.devank.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.devank.entity.Customer;
import com.devank.util.ConnectionBuilder;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public Customer returnCustomerRecord(int customerID) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionBuilder.createConnectionObject();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE customer_id=?");
		pStatement.setInt(1, customerID);
		ResultSet resultset=pStatement.executeQuery();
		Customer customer = null;
		if(resultset.next()) {
			int id = resultset.getInt("customer_id");
			String name = resultset.getString("cust_name");
			String emailID = resultset.getString("email_id");
			String mobileNumber = resultset.getString("mob_number");
			customer = new Customer(id,name,emailID,mobileNumber);
		}
		ConnectionBuilder.closeConnectionObject(connection);
		return customer;
	}

	@Override
	public boolean createCustomerRecord(Customer customer) throws ClassNotFoundException, SQLException {
		boolean returnStatus=false;
		Connection connection = ConnectionBuilder.createConnectionObject();
		PreparedStatement pStatement = connection.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?,?,?)");
		pStatement.setInt(1, customer.getCustomerID());
		pStatement.setString(2, customer.getCustomerName());
		pStatement.setString(3, customer.getCustomerEmailID());
		pStatement.setString(4, customer.getCustomerPhoneNumber());
		int rows=pStatement.executeUpdate();
		if(rows>0)
			returnStatus=true;
		ConnectionBuilder.closeConnectionObject(connection);
		return returnStatus;
	}

	@Override
	public int countTotalRecords() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionBuilder.createConnectionObject();
		int count=0;
		Statement statement = connection.createStatement();
		ResultSet resultset=statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
		if(resultset.next()) {
			count = resultset.getInt(1);
		}
		ConnectionBuilder.closeConnectionObject(connection);
		return count;
	}

}
