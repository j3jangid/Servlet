package com.groot.respo;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnectiopn {
		public static Connection getConnection() {
			Connection conn=null;
			try {
				Class.forName("com.mysql.jdbc.cj.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newPro", "root", "root");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
}
