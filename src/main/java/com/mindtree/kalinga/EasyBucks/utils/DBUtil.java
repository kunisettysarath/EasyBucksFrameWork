package com.mindtree.kalinga.EasyBucks.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil extends PropertyUtil {
	Connection con;

	/*
	 * Method for establishing connection to MySQL database
	 */
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName(getData("mysqlDriver"));
		con = DriverManager.getConnection(getData("dbUrl"), getData("username"), getData("password"));
	}

	/*
	 * Method for inserting data in the database
	 */
	public void insertData(String query) throws ClassNotFoundException, SQLException {
		connect();
		PreparedStatement pStmt = con.prepareStatement(query);
		pStmt.executeQuery();
	}

	/*
	 * Method for fetching the data from the database
	 */
	public ResultSet selectData(String query) throws ClassNotFoundException, SQLException {
		connect();
		PreparedStatement pStmt = con.prepareStatement(query);
		ResultSet result = pStmt.executeQuery();
		return result;
	}

	/*
	 * Method for closing connection
	 */
	public void closeConnection() throws SQLException {
		con.close();
	}
}