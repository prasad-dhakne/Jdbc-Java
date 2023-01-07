package com.jdbc.question1.curd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.jdbcutils.JdbcConnection;

public class JdbcDelete {
	public static void deleteRecord() {
		Connection connection = null;
		Statement statement = null;
		Scanner scanner = null;
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null) {
				statement = connection.createStatement();
				System.out.println("Please enter Id that you want to delete :");
				scanner = new Scanner(System.in);
				String strId = scanner.nextLine().trim();
				strId = "'" + strId + "'";
				String sqlDeleteQuery = "delete from students where(id="+strId+")";
				int rowsAffected = statement.executeUpdate(sqlDeleteQuery);
				System.out.println(rowsAffected + "row(s) affected");
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
