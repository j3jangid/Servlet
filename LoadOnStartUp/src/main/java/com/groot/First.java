package com.groot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig config;

    public First() {
    	System.out.println("Object Created");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("without args");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	this.config=config;
    	System.out.println("Init With Args");
//    	getServletContext();
    }
    
    
    @Override
    public void destroy() {
    	System.out.println("Destroy Method");
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("hii");
		System.out.println("in service method");
		ServletContext context1= config.getServletContext();
//		ServletContext context1=getServletContext();
		out.println(context1.getInitParameter("name")+"<br>");
		out.println(context1.getInitParameter("salary")+"<br>");
		out.println("by enumeration");
		Enumeration<String> en= context1.getInitParameterNames();
		while(en.hasMoreElements()) {
			String name= en.nextElement();
			out.println("Name : "+name+" ,Value : "+context1.getInitParameter(name)+"<br>");
		}
		
		
	}



}
