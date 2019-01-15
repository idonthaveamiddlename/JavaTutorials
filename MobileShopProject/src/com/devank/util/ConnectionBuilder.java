package com.devank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {

	public static Connection createConnectionObject() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		//enter your selected database name instead of mydb
		//enter the password for your database instead of password
		connection=DriverManager.getConnection("jdbc:mysql"
				+ "://localhost/mydb", "root", "password");
		return connection;
	}
	
	public static void closeConnectionObject(Connection connection) throws SQLException {
		connection.close();
	}
}
