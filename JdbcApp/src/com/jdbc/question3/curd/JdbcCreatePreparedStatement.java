package com.jdbc.question3.curd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.jdbcutils.JdbcConnection;

public class JdbcCreatePreparedStatement {
	public static void createRecord() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = null;
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null) {
				String sqlInsertQuery = "insert into students(email, first_name, last_name) values(?,?,?)";
				preparedStatement = connection.prepareStatement(sqlInsertQuery);
				
				scanner = new Scanner(System.in);
				System.out.println("Please Enter Email Id :-");
				String email = scanner.nextLine().trim();
				System.out.println("Please Enter First Name :-");
				String firstName = scanner.nextLine().trim();
				System.out.println("Please Enter Last Name :-");
				String lastName = scanner.nextLine().trim();
				
				int rowsAffected = 0;
				if(preparedStatement != null) {
					preparedStatement.setString(1, email);
					preparedStatement.setString(2, firstName);
					preparedStatement.setString(3, lastName);
					rowsAffected = preparedStatement.executeUpdate();
				}
				System.out.println(rowsAffected +"row(s) affected");
				
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcConnection.closeResourses(null, preparedStatement, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
