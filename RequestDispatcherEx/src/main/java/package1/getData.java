package package1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getData extends HttpServlet {
	public getData() {
		// TODO Auto-generated constructor stub
		System.out.println("object created");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init method called");
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init method called generic servlet");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String nameGot = req.getParameter("nameBy");
		String emailGot = req.getParameter("emailBy");
		String mobileGot = req.getParameter("mobileBy");
		String passwordGot = req.getParameter("passwordBy");
	System.out.println("I am in do get");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver Error");
//			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servelet", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into secondTable (name, email, mobile, password) values (?,?,?,?)");
			ps.setString(1, nameGot);
			ps.setString(2, emailGot);
			ps.setString(3, mobileGot);
			ps.setString(4, passwordGot);
			int i = ps.executeUpdate();
			System.out.println(i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
