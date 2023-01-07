package com.jdbc.jdbcutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	
	public static Connection getJdbcConnection() throws SQLException {
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/sms";
		String username = "root";
		String password = "pashya";
		
		connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}
	
	public static void closeResourses(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
		if(resultSet != null) {
			resultSet.close();
		}
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}

}
