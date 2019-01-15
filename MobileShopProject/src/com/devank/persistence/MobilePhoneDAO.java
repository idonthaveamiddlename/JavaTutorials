package com.devank.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import com.devank.entity.MobilePhone;

public interface MobilePhoneDAO {

	ArrayList<MobilePhone> getAllModels() throws ClassNotFoundException, SQLException;
	boolean updateStockAvailable(MobilePhone mobilePhone) throws SQLException, ClassNotFoundException;
	MobilePhone returnModel(int modelID) throws SQLException, ClassNotFoundException;
}
