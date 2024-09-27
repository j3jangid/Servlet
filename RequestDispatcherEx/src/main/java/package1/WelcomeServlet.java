package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String loginFlag=null;
		try {
		loginFlag=(String)req.getAttribute("login");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(loginFlag !=null && loginFlag.equalsIgnoreCase("ok")) {
			String emailGot = req.getParameter("emailBy");
			out.println("Welcome "+emailGot);
			req.removeAttribute("login");
			out.print("<a href='./LogoutServlet'>Logout</a>");
			loginFlag=(String)req.getAttribute("login");
			out.print("attr"+loginFlag);
		}else {
//			resp.sendRedirect("login.html");
			out.println("Your are logged out");
			req.getRequestDispatcher("./login.html").include(req, resp);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
