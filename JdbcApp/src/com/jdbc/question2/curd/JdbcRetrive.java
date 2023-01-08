package com.jdbc.question2.curd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.jdbcutils.JdbcConnection;

public class JdbcRetrive {
	public static void retriveRecords() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcConnection.getJdbcConnection();
			if (connection != null) {
				statement = connection.createStatement();
				String sqlSelectQuery = "select name, address, gender, dob, doj, dom from employee";
				resultSet = statement.executeQuery(sqlSelectQuery);

				System.out.println("name\t\t\taddress\t\tgender\tdob\t\tdoj\t\tdom\t");
				while (resultSet.next()) {
					String name = resultSet.getString(1);
					String address = resultSet.getString(2);
					String gender = resultSet.getString(3);
					java.sql.Date dob = resultSet.getDate(4);
					java.sql.Date doj = resultSet.getDate(5);
					java.sql.Date dom = resultSet.getDate(6);
					String strDob = dob.toString();
					String strDoj = doj.toString();
					String strDom = dom.toString();
					if(name.length() < 16) {
						System.out.println(name + "\t\t" + address + "\t" + gender + "\t" 
								+ strDob.substring(8, 10)+ "-" + strDob.substring(5, 7) + "-" + strDob.substring(0, 4) + "\t" 
								+ strDoj.substring(5, 7) + "-" + strDoj.substring(8, 10) + "-" + strDoj.substring(0, 4) + "\t"
								+ strDom.substring(0, 4)+ "-" + strDom.substring(5, 7) + "-" + strDom.substring(8, 10) +"\t");
					}
					else {
						System.out.println(name + "\t" + address + "\t" + gender + "\t" 
								+ strDob.substring(8, 10)+ "-" + strDob.substring(5, 7) + "-" + strDob.substring(0, 4) + "\t" 
								+ strDoj.substring(5, 7) + "-" + strDoj.substring(8, 10) + "-" + strDoj.substring(0, 4) + "\t"
								+ strDom.substring(0, 4)+ "-" + strDom.substring(5, 7) + "-" + strDom.substring(8, 10) +"\t");						
					}
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcConnection.closeResourses(resultSet, statement, connection);
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
