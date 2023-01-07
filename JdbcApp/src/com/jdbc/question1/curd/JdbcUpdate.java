package com.jdbc.question1.curd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.jdbcutils.JdbcConnection;

public class JdbcUpdate {
	public static void updateRecord() {	
		Connection connection = null;
		Statement statement = null;
		Scanner scanner = null;
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null) {
				statement = connection.createStatement();
				scanner = new Scanner(System.in);
				System.out.println("Enter the Id that you want to update :");
				String strId = scanner.nextLine().trim();
				strId = "'" + strId + "'";
				System.out.println("Which column you want to update?");
				System.out.println("1. email");
				System.out.println("2. first_name");
				System.out.println("3. last_name");
				System.out.println("Please Enter any one option from above :");
				String opt = scanner.nextLine().trim();
				int optionValue = Integer.parseInt(opt);
				String sqlUpdateQuery = null;
				switch(optionValue) {
				case 1:
					System.out.println("Please enter the new email");
					String email = scanner.nextLine();
					email = "'" + email.trim() + "'";
					sqlUpdateQuery = "update students set email="+email+"where(id="+strId+")";
					break;
				case 2:
					System.out.println("Please enter the new first_name");
					String first_name = scanner.nextLine();
					first_name = "'" + first_name.trim() + "'";
					sqlUpdateQuery = "update students set first_name="+first_name+"where(id="+strId+")";
					break;
				case 3:
					System.out.println("Please enter the new last_name");
					String last_name = scanner.nextLine();
					last_name = "'" + last_name.trim() + "'";
					sqlUpdateQuery = "update students set last_name="+last_name+"where(id="+strId+")";
					break;
				default:
					System.out.println("Invalid input selected! Please try again");
					break;
				}
				if(sqlUpdateQuery != null) {
					int rowAffected = statement.executeUpdate(sqlUpdateQuery);
					System.out.println(rowAffected + "row(s) affected");
				}
			}
		}catch(SQLException se) {
			System.out.println("Sql Exception Occured");
		}catch(Exception e) {
			System.out.println("Exception Occured");
		}finally {
			try {
				JdbcConnection.closeResourses(null, statement, connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
