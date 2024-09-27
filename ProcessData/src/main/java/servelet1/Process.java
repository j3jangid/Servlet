package servelet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/process")
public class Process extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		String name = req.getParameter("n1");
		String email = req.getParameter("e1");
		String mobile = req.getParameter("m1");
		String pass = req.getParameter("p1");
		
		PrintWriter out = res.getWriter();
		out.println(name+"<br>");
		out.println(mobile+"<br>");
		out.println(email+"<br>");
		out.println(pass+"<br>");
		
		Connection con= GetConnection.getConnection();;
		
		try{
			PreparedStatement addData = con.prepareStatement("INSERT INTO recdata (name, phone, email, password) VALUES (?, ?, ?, ?)");
			addData.setString(1, name);
			addData.setString(2, mobile);
			addData.setString(3, email);
			addData.setString(4, pass);
			int i = addData.executeUpdate();
			out.println("Updated " + i +" records");
		} catch (SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Errr");
		}
		
		
	}
}
