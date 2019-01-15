package com.devank.persistence;

import java.sql.SQLException;

import com.devank.entity.Customer;

public interface CustomerDAO {

	Customer returnCustomerRecord(int customerID) throws ClassNotFoundException, SQLException;
	boolean createCustomerRecord(Customer customer) throws ClassNotFoundException, SQLException;
	int countTotalRecords() throws ClassNotFoundException, SQLException;
}
