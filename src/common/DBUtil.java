package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static Connection connection;
	private static Statement statement;
	static
	{
		try {
			connection=DriverManager.getConnection("jdbc:mysql:///ecommerce", "root", "swapnil1133");
			statement=connection.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public static ResultSet executeSeleteQuery(String query) throws SQLException
	{
		ResultSet resultSet=statement.executeQuery(query);
		return resultSet;
	}
	public static void executeQuery(String query)throws SQLException
	{
		statement.execute(query);
	}
	
	

}
