package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProcess extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String emailGot = req.getParameter("emailBy");
		String passwordGot = req.getParameter("passwordBy");

		System.out.println("In doGet");

//		if(emailGot.equalsIgnoreCase("admin")&&passwordGot.equalsIgnoreCase("admin")) {
//			RequestDispatcher rd=req.getRequestDispatcher("./WelcomeServlet");
//			rd.forward(req, resp);
//		}else {
//			out.print("Invalid user name or password");
//			RequestDispatcher rd=req.getRequestDispatcher("./login.html");
//			rd.include(req, resp);
//		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servelet", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from secondTable where email=? and password=?");
			ps.setString(1, emailGot);
			ps.setString(2, passwordGot);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("./WelcomeServlet");
				req.setAttribute("login", "OK");
				rd.forward(req, resp);
			} else {
				out.println("Invalid User Name OR Password");
				RequestDispatcher rd = req.getRequestDispatcher("./login.html");
				rd.include(req, resp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}