package servelet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // Set the content type to HTML
        res.setContentType("text/html");

        // Get the PrintWriter object to send the response
        try (PrintWriter out = res.getWriter()) {
            // Write the HTML content to the response
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Data Management</title>");
            out.println("<style>");
            out.println("table { width: 700px; margin: 0 auto; border-collapse: collapse; }");
            out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println("a { text-decoration: none; color: blue; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='index.html'>ADD DATA</a><br><br>");
            out.println("<table>");
            out.println("<tr>");
            
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Mail</th>");
            out.println("<th>Password</th>");
            out.println("<th>Update</th>");
            out.println("<th>Delete</th>");
            out.println("</tr>");
            
            Connection  con=GetConnection.getConnection();
           PreparedStatement ps=  con.prepareStatement("select * from recdata");
           ResultSet rs=ps.executeQuery();
           while(rs.next()) {
            out.println("<tr>");
            out.println("<td>"+rs.getInt(1)+"</td>");
            out.println("<td>"+rs.getString(2)+"</td>");
            out.println("<td>"+rs.getString(3)+"</td>");
            out.println("<td>"+rs.getString(4)+"</td>");
            out.println("<td>"+rs.getString(5)+"</td>");
            out.println("<td><a href='./UpdateData?id="+rs.getInt(1)+"'>Update</a></td>");
            out.println("<td><a href='./DeleteData?id="+rs.getInt(1)+"'>Delete</a></td>");
            out.println("</tr>");
            
           }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}