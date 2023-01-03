package com.jdbc.question1.controller;

import java.util.Scanner;

import com.jdbc.question1.curd.JdbcCreate;
import com.jdbc.question1.curd.JdbcDelete;
import com.jdbc.question1.curd.JdbcRead;
import com.jdbc.question1.curd.JdbcUpdate;

public class MainApp {

	public static void main(String[] args) {
		Scanner scanner = null;
		char ch = 'n';
		do {
			System.out.println("Menu :");
			System.out.println("1. Create");
			System.out.println("2. Read");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("Please Enter Your Choice :- ");
			scanner = new Scanner(System.in);
			int optionValue = 0;
			try {
				String opt = scanner.nextLine().trim();
				optionValue = Integer.parseInt(opt);
			}catch(Exception e) {
				
			}
			switch(optionValue) {
			case 1:
				JdbcCreate.createRecord();
				break;
			case 2:
				JdbcRead.readRecords();
				break;
			case 3:
				JdbcUpdate.updateRecord();
				break;
			case 4:
				JdbcDelete.deleteRecord();
				break;
			default:
				System.out.println("Invalid input selected! Please try again");
				break;
			}
			System.out.println("Do you want to continue ? (Y/y)");
			scanner.reset();
			ch = scanner.nextLine().trim().charAt(0);
			System.out.println(ch);
		}while(ch == 'y' || ch == 'Y');
		scanner.close();
	}

}
