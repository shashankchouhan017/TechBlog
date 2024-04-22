package com.tech.blog.helper;
import java.sql.*;
public class ConnectionProvider
{
	private static Connection conn = null;
	public static Connection getConnection()
	{
		try {
			if(conn ==null)
			{
				Class.forName("oracle.jdbc.OracleDriver");
				
				conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-GOPFM6R:1521/xe","techblog","shashank");
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return conn;
		
	}
}
