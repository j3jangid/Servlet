package com.groot.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOperations {
		public static DBOperations dbOperations=new DBOperations();
		public Connection conn;
		private  DBOperations() {
			// TODO Auto-generated constructor stub
		}
//		public static  Connection=null;
		public  Connection getConnection(String dbUrl,String dbName,String dbPassword) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				
				conn=DriverManager.getConnection(dbUrl,dbName,dbPassword);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return conn;
			
		}
		public static DBOperations getDbOperations() {
			return dbOperations;
		}
}
