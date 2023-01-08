package com.jdbc.question3.curd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.jdbcutils.JdbcConnection;

public class JdbcDeletePreparedStatement {
	public static void deleteRecord() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = null;
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null) {
				System.out.println("Please enter Id that you want to delete :");
				scanner = new Scanner(System.in);
				String strId = scanner.nextLine().trim();
				//strId = "'" + strId + "'";
				Integer ID = Integer.parseInt(strId);
				String sqlDeleteQuery = "delete from students where(id=?)";
				preparedStatement = connection.prepareStatement(sqlDeleteQuery);
				int rowsAffected = 0;
				if(preparedStatement != null) {
					preparedStatement.setInt(1, ID);
					rowsAffected = preparedStatement.executeUpdate();
				}
				System.out.println(rowsAffected + "row(s) affected");
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
