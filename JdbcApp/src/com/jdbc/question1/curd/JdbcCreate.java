package com.jdbc.question1.curd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.jdbcutils.JdbcConnection;

public class JdbcCreate {
	public static void createRecord() {
		Connection connection = null;
		Statement statement = null;
		Scanner scanner = null;
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null) {
				statement = connection.createStatement();
				
				scanner = new Scanner(System.in);
				System.out.println("Please Enter Email Id :-");
				String email = scanner.nextLine().trim();
				System.out.println("Please Enter First Name :-");
				String firstName = scanner.nextLine().trim();
				System.out.println("Please Enter Last Name :-");
				String lastName = scanner.nextLine().trim();
				//scanner.close();
				
				email = "'" + email + "'";
				firstName = "'" + firstName + "'";
				lastName = "'" + lastName + "'";
				
				String sqlInsertQuery = "insert into students(email, first_name, last_name) values("+email+","+firstName+","+lastName+")";
				int rowsAffected = statement.executeUpdate(sqlInsertQuery);
				System.out.println(rowsAffected +"row(s) affected");
				
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcConnection.closeResourses(null, statement, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
