package com.jdbc.question2.curd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.jdbc.jdbcutils.JdbcConnection;

public class JdbcInsert {
	public static void insertRecord() {
		Connection connection = null;
		Statement statement = null;
		Scanner scanner = null;
		
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null) {
				scanner = new Scanner(System.in);
				System.out.println("Enter your name :: ");
				String name = scanner.nextLine().trim();
				System.out.println("Enter your address ::");
				String address = scanner.nextLine().trim();
				System.out.println("Enter your Gender ::");
				String gender = scanner.nextLine().trim();
				System.out.println("Enter your DOB (dd-MM-yyyy) ::");
				String strDOB = scanner.nextLine().trim();
				System.out.println("Enter your DOJ (MM-dd-yyyy) ::");
				String strDOJ = scanner.nextLine().trim();
				System.out.println("Enter your DOM (yyyy-MM-dd) ::");
				String strDOM = scanner.nextLine().trim();
				
				SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM-dd-yyyy");
				SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
				
				java.util.Date utilDOB = simpleDateFormat1.parse(strDOB);
				java.util.Date utilDOJ = simpleDateFormat2.parse(strDOJ);
				java.util.Date utilDOM = simpleDateFormat3.parse(strDOM);
				
				java.sql.Date sqlDOB = new java.sql.Date(utilDOB.getTime());
				java.sql.Date sqlDOJ = new java.sql.Date(utilDOJ.getTime());
				java.sql.Date sqlDOM = new java.sql.Date(utilDOM.getTime());
				
				statement = connection.createStatement();
				String sqlInsertQuery = "insert into employee(name, address, gender, dob, doj, dom) values('"+ name +"','" + address +"','" + gender +"','"+ sqlDOB +"','"+ sqlDOJ +"','"+ sqlDOM+"')";
				int executeUpdate = statement.executeUpdate(sqlInsertQuery);
				
				System.out.println(executeUpdate +"row(s) affected");
			}
		}catch(SQLException se) {
			se.printStackTrace();
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
