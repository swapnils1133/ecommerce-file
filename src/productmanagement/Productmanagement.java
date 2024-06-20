package productmanagement;
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

public class Productmanagement {

	public void productManagement() throws IOException, SQLException {
		System.out.println("Welcome to product management");
	
		Product product = new Product();
		boolean loop = true;
		while (loop) {
			Scanner sc = new Scanner(System.in);
			System.out.println("what would you like t do ");
			System.out.println("1.Add product");
			System.out.println("2.update product");
			System.out.println("3.search product");
			System.out.println("4.delete product");
			System.out.println("5.print product");
			System.out.println("9.Exit");
			System.out.println("enter your choice");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("enter productname");
				product.name = sc.next();
				System.out.println("enter quantity");
				product.quantity = sc.next();
				System.out.println("enter price");
				product.price = sc.next();
				
				String insertQuery="insert into product(product_name,product_quantity, product_price) values('"+product.name +"', '"+product.quantity +"', '"+product.price+"', )";
				DBUtil.executeQuery(insertQuery);
				System.out.println("product add successfully");

				break;

			case 2:
				System.out.println("update product");
				System.out.println("enter product name to update");

				Scanner scToUpdate = new Scanner(System.in);
				String productNameToUpdate = scToUpdate.next();

				String selectQUery="select * from product where product_name='"+ productNameToUpdate+"'";
				ResultSet resultset=DBUtil.executeSeleteQuery(selectQUery);
				if(resultset.next()) {
						scToUpdate = new Scanner(System.in);
						System.out.println("enter updated productname");
						String updatedproductName = scToUpdate.next();
						System.out.println("enter updated quantity");
						String updatedproductQuantity = scToUpdate.next();
						System.out.println("enter updated price");
						String updatedproductPrice = scToUpdate.next();
						String updateQuery="update user set first_name='"+updatedproductName+"', '"+updatedproductQuantity+"', '"+updatedproductPrice+"'";
						DBUtil.executeQuery(updateQuery);
						System.out.println("product Update succesfully!!");
				}
				else {
					System.out.println("product Not Found");
				}
				break;
				
			case 3:
				System.out.println("search product");
				System.out.println("enter product name to search");

				Scanner scToSearch = new Scanner(System.in);
				String productNameSearch = scToSearch.next();

				String searchQuery="select * from product where product_name='"+productNameSearch+"'";
				ResultSet rs=DBUtil.executeSeleteQuery(searchQuery);
				if(rs.next()) {
					System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getInt(4)+", "+rs.getString(5)+", "+rs.getString(6));
				}else {
					System.out.println("product Not Found");
				}
				break;
				
			case 4:
				System.out.println("Delete product");
				System.out.println("enter product name to Delete");

				Scanner scToDelete = new Scanner(System.in);
				String productNameDelete = scToDelete.next();

				String deleteQuery="delete from product where product_name='"+productNameDelete+"'";
				DBUtil.executeQuery(deleteQuery);
				System.out.println("product Deleted Succssfully!!");
				break;
				
			case 5:
				System.out.println("Print product deatil");
				String printQuery="select * from product";
				ResultSet resultSets=DBUtil.executeSeleteQuery(printQuery);
				while(resultSets.next()) {
					System.out.println(resultSets.getString(1)+", "+resultSets.getString(2)+", "+resultSets.getString(3));

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
