package servelet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletEx extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		String name = req.getParameter("n1");
		String mobile = req.getParameter("m1");
		String email = req.getParameter("e1");
		String password = req.getParameter("p1");
		
		PrintWriter out = res.getWriter();
		out.println(name+"<br>");
		out.println(mobile+"<br>");
		out.println(email+"<br>");
		out.println(password+"<br>");
		
		Connection con = GetConnection.getConnection();
		try {
			PreparedStatement addData = con.prepareStatement("INSERT INTO recdata (name, phone, email, password) VALUES (?, ?, ?, ?)");
			addData.setString(1, name);
			addData.setString(2, mobile);
			addData.setString(3, email);
			addData.setString(4, password);
			int i = addData.executeUpdate();
			out.println(i+" Record Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
		
	}
}
