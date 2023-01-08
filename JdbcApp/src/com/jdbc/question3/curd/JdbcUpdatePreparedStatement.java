package com.jdbc.question3.curd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.jdbcutils.JdbcConnection;

public class JdbcUpdatePreparedStatement {
	public static void updateRecord() {	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = null;
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null) {
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
				String email = null, first_name = null, last_name = null;
				char ch = 'n';
				switch(optionValue) {
				case 1:
					System.out.println("Please enter the new email");
					email = scanner.nextLine();
					ch = 'e';
					sqlUpdateQuery = "update students set email=? where(id="+strId+")";
					break;
				case 2:
					System.out.println("Please enter the new first_name");
					first_name = scanner.nextLine();
					ch = 'f';
					sqlUpdateQuery = "update students set first_name=? where(id="+strId+")";
					break;
				case 3:
					System.out.println("Please enter the new last_name");
					last_name = scanner.nextLine();
					ch = 'l';
					sqlUpdateQuery = "update students set last_name=? where(id="+strId+")";
					break;
				default:
					System.out.println("Invalid input selected! Please try again");
					break;
				}
				int rowAffected = 0;
				if(sqlUpdateQuery != null) {
					preparedStatement = connection.prepareStatement(sqlUpdateQuery);
					if(preparedStatement != null && ch != 'n') {
						if(ch == 'e') preparedStatement.setString(1, email);
						if(ch == 'f') preparedStatement.setString(1, first_name);
						if(ch == 'l') preparedStatement.setString(1, last_name);
						rowAffected = preparedStatement.executeUpdate();
					}
					System.out.println(rowAffected + "row(s) affected");
				}
			}
		}catch(SQLException se) {
			System.out.println("Sql Exception Occured");
		}catch(Exception e) {
			System.out.println("Exception Occured");
		}finally {
			try {
				JdbcConnection.closeResourses(null, preparedStatement, connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
