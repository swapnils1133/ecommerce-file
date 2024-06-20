package ecommerce;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import productmanagement.Productmanagement;
import usermanagement.Usermanagement;

public class Application {

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("'welcome to Application");
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("what would you like to do today");
			System.out.println("1.usermanagement");
			System.out.println("2.productmanagement");
			System.out.println("9.exit application");
			
			System.out.println("enter choice");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				Usermanagement user = new Usermanagement();
				user.userManagement();
				break;
				
			case 2:
				Productmanagement product = new Productmanagement();
				product.productManagement();
				break;
				
			case 9:
				System.out.println(".exit application");
				loop = false;
				break;
				
				default:
					System.out.println("Invalid choice");
					
			}
			
		}

	}

	}


