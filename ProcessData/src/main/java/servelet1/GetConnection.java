package servelet1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
public static Connection getConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("Error in Driver");
		e.printStackTrace();
	}
	
	try {
		return DriverManager.getConnection(GlobleVar.DB_URL, GlobleVar.DB_USERNAME, GlobleVar.DB_PASSWORD);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error in Connection");
		e.printStackTrace();
	}
	
	return null;
}
}
