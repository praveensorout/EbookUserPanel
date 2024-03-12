package connection;

import java.sql.*;

public class DBConnect
{
	private static Connection con;
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook","root","root123");
		}
		catch(SQLException e){}
		catch(ClassNotFoundException e){}
		return con;
	}
}
	