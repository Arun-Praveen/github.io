package com.cognizant.truyum.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cognizant.truyum.dao.ConnectionHandler;

public class ConnectionHandler {
	public static Connection getConnection() {
		BufferedInputStream bufferedInputStream = (BufferedInputStream) ConnectionHandler.class.getClassLoader()
				.getResourceAsStream("connection.properties");
		Properties prop = new Properties();
		try {
			prop.load(bufferedInputStream);
		} catch (IOException e) {
			System.out.println("unable to find the db.properties file");
		}
		String driver = (String) prop.get("driver");
		System.out.println("Driver Name--> " + driver);
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		}
		String user = (String) prop.get("user");
		String password = (String) prop.get("password");
		String connection_url = (String) prop.get("connection_url");
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(connection_url, user, password);
			System.out.println("Connection established");
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}

		return connection;
	}
}
