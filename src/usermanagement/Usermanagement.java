package usermanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.DBUtil;
import productmanagement.Product;

public class Usermanagement {


	public  void userManagement() throws IOException, SQLException {
		System.out.println("Welcome to user management");
		
		User user = new User();
		boolean loop = true;
		while (loop) {
			Scanner sc = new Scanner(System.in);
			System.out.println("what would you like t do ");
			System.out.println("1.Add user");
			System.out.println("2.update user");
			System.out.println("3.search user");
			System.out.println("4.delete user");
			System.out.println("5.print user");
			System.out.println("9.Exit");
			System.out.println("enter your choice");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("enter firstname");
				user.firstname = sc.next();
				System.out.println("enter lastname");
				user.lastname = sc.next();
				System.out.println("enter gender");
				user.gender = sc.next();
				System.out.println("enter age");
				user.age = sc.nextInt();
				System.out.println("enter email");
				user.email = sc.next();
				System.out.println("enter password");
				String password = sc.next();
				System.out.println("enter confirmpassword");
				String confirmpassword = sc.next();
				if (password.equals(confirmpassword)) {
					user.password = confirmpassword;
					String insertQuery="insert into user(first_name, last_name, gender, age, email, password) values('"+user.firstname+"', '"+user.lastname+"', '"+user.gender+"', '"+user.age+"','"+user.email+"', '"+user.password+"')";
					DBUtil.executeQuery(insertQuery);
					System.out.println("user add successfully");
					
				}
				System.out.println("password incorrect");

				break;

			case 2:
				System.out.println("update user");
				System.out.println("enter user name to update");

				Scanner scToUpdate = new Scanner(System.in);
				String userNameToUpdate = scToUpdate.next();
				String selectQUery="select * from user where first_name='"+ userNameToUpdate+"'";
				ResultSet resultset=DBUtil.executeSeleteQuery(selectQUery);
				if(resultset.next()) {
						scToUpdate = new Scanner(System.in);
						System.out.println("enter updated firstname");
						String updatedUserFirstname = scToUpdate.next();
						System.out.println("enter updated lastname");
						String updatedUserLastname = scToUpdate.next();
						System.out.println("enter updated gender");
						String updatedUserGender = scToUpdate.next();
						System.out.println("enter updated age");
						int updatedUserAge = scToUpdate.nextInt();
						System.out.println("enter updated email");
						String updatedUserEmail = scToUpdate.next();
						System.out.println("enter updates password: ");
						String uppassword=scToUpdate.next();
						String updateQuery="update user set first_name='"+updatedUserFirstname+"', '"+updatedUserLastname+"', '"+updatedUserGender+"', '"+updatedUserAge+"', '"+updatedUserEmail+"', '"+uppassword+"' where first_name='"+userNameToUpdate+"'";
						DBUtil.executeQuery(updateQuery);
						System.out.println("User Update succesfully!!");
				}
				else {
					System.out.println("User Not Found");
				}
				break;
			case 3:
				System.out.println("search user");
				System.out.println("enter user name to search");

				Scanner scToSearch = new Scanner(System.in);
				String userNameSearch = scToSearch.next();
				String searchQuery="select * from user where first_name='"+userNameSearch+"'";
				ResultSet rs=DBUtil.executeSeleteQuery(searchQuery);
				if(rs.next()) {
					System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getInt(4)+", "+rs.getString(5)+", "+rs.getString(6));
				}else {
					System.out.println("User Not Found");
				}
				break;
			case 4:
				System.out.println("Delete user");
				System.out.println("enter user name to Delete");

				Scanner scToDelete = new Scanner(System.in);
				String userNameDelete = scToDelete.next();
				String deleteQuery="delete from user where first_name='"+userNameDelete+"'";
				DBUtil.executeQuery(deleteQuery);
				System.out.println("User Deleted Succssfully!!");
				break;

			case 5:
				System.out.println("Print product deatil");
				String printQuery="select * from user";
				ResultSet resultSets=DBUtil.executeSeleteQuery(printQuery);
				while(resultSets.next()) {
					System.out.println(resultSets.getString(1)+", "+resultSets.getString(2)+", "+resultSets.getString(3)+", "+resultSets.getInt(4)+", "+resultSets.getString(5)+", "+resultSets.getString(6));

				}
				break;
			case 9:
				System.out.println("Existing the product management");
				
				loop = false;
				break;
			default:
				System.out.println("invalid choice");
			}
		}
	}
}