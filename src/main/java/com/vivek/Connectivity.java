package com.vivek;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectivity {
	static String url = "jdbc:mysql://localhost:3306/vivek";
	static String un = "root";
	static String up = "0000";
	static Connection con = null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,un,up);
			if(con!=null) {
				System.out.println("Connected");
			}
			else {
				System.out.println("Connection Failed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
