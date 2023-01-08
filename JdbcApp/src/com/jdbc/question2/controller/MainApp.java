package com.jdbc.question2.controller;

import java.util.Scanner;

import com.jdbc.question2.curd.JdbcInsert;
import com.jdbc.question2.curd.JdbcRetrive;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = null;
		char check = 'N';
		do {
			System.out.println("Menu :");
			System.out.println("1. Insert");
			System.out.println("2. Retrive");
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
				JdbcInsert.insertRecord();
				break;
			case 2:
				JdbcRetrive.retriveRecords();
				break;
			default:
				System.out.println("Invalid input selected! Please try again");
				break;
			}
			System.out.println("Do you want to continue ? (Y/y)");
			scanner.reset();
			check = scanner.nextLine().trim().charAt(0);
		}while(check == 'y' || check == 'Y');
		scanner.close();
	}
}
