package com.devank.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.devank.entity.MobilePhone;
import com.devank.util.ConnectionBuilder;

public class MobilePhoneDAOImpl implements MobilePhoneDAO {

	@Override
	public ArrayList<MobilePhone> getAllModels() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionBuilder.createConnectionObject();
		ArrayList<MobilePhone> mobList = new ArrayList<>();
		Statement statement = connection.createStatement();
		ResultSet resultset=statement.executeQuery("SELECT * FROM MOBILE_PHONE");
		MobilePhone mobilePhone = null;
		while(resultset.next()) {
			int id=resultset.getInt("serial_number");
			String brand=resultset.getString("brand");
			String model=resultset.getString("model");
			int stockInHand=resultset.getInt("stock_in_hand");
			int costInRupees=resultset.getInt("cost_in_rupees");
			mobilePhone = new MobilePhone(id,brand,model,stockInHand,costInRupees);
			mobList.add(mobilePhone);
		}
		ConnectionBuilder.closeConnectionObject(connection);
		return mobList;
	}

	@Override
	public boolean updateStockAvailable(MobilePhone mobilePhone) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionBuilder.createConnectionObject();
		PreparedStatement pStatement = connection.prepareStatement("UPDATE MOBILE_PHONE "
				+ "SET stock_in_hand=? WHERE serial_number=?");
		pStatement.setInt(1, mobilePhone.getStockInHand()-1);
		pStatement.setInt(2, mobilePhone.getSerialNumber());
		int rows=pStatement.executeUpdate();
		ConnectionBuilder.closeConnectionObject(connection);
		if(rows>0)
			return true;
		return false;
	}

	@Override
	public MobilePhone returnModel(int modelID) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionBuilder.createConnectionObject();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM MOBILE_PHONE WHERE serial_number=?");
		pStatement.setInt(1, modelID);
		ResultSet resultset=pStatement.executeQuery();
		MobilePhone mobilePhone = null;
		if(resultset.next()) {
			int id = resultset.getInt("serial_number");
			String brand = resultset.getString("brand");
			String model = resultset.getString("model");
			int stockInHand = resultset.getInt("stock_in_hand");
			int costInRupees = resultset.getInt("cost_in_rupees");
			mobilePhone = new MobilePhone(id,brand,model,stockInHand,costInRupees);
		}
		ConnectionBuilder.closeConnectionObject(connection);
		return mobilePhone;
	}

}
