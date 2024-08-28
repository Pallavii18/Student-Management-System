package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class getConnection {
	public static Connection connect() 
	{
		Connection con = null;

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Delta", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
