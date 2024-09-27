package com.groot;

import java.sql.Connection;

import com.groot.db.DBOperations;

public class Test2 {
	 public static void main(String[] args) {
		Connection connection=DBOperations.getDbOperations().getConnection("jdbc:mysql://localhost:3306/servelet", "root", "root");
		Connection connection2=DBOperations.getDbOperations().getConnection("jdbc:mysql://localhost:3306/servelet", "root", "root");
		System.out.println(connection==connection2);
		System.out.println(connection.hashCode());
		System.out.println(connection2.hashCode());
	 }
}
