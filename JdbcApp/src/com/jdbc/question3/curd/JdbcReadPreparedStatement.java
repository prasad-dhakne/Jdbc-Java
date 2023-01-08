package com.jdbc.question3.curd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.jdbcutils.JdbcConnection;

public class JdbcReadPreparedStatement {
	public static void readRecords(){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null) {
				// Create a preparedStatement object
				String sqlSelectQuery = "select id, email, first_name, last_name from students";
				preparedStatement = connection.prepareStatement(sqlSelectQuery);
				
				// Send and execute the query
				resultSet = preparedStatement.executeQuery();
				
				// Process the result form ResultSet
				System.out.println("Id \tEmail\t\t\t First Name \t Last Name");
				while(resultSet.next()) {
					Integer id = resultSet.getInt("id");
					String email = resultSet.getString("email");
					String firstName = resultSet.getString("first_name");
					String lastName = resultSet.getString("last_name");
					System.out.println(id + "\t" + email + " \t" + firstName + "  \t" + lastName + "\t");
				}					
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcConnection.closeResourses(resultSet, preparedStatement, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
