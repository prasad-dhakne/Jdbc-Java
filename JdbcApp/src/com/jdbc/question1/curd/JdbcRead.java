package com.jdbc.question1.curd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.question1.jdbcutils.JdbcConnection;

public class JdbcRead {
	public static void readRecords(){
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null) {
				// Create a statement object
				statement = connection.createStatement();
				
				// Send and execute the query
				String sqlSelectQuery = "select id, email, first_name, last_name from students";
				resultSet = statement.executeQuery(sqlSelectQuery);
				
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
				JdbcConnection.closeResourses(resultSet, statement, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
