package com.World_DB.web;

import java.io.IOException;

//import org.apache.tomcat.util.http.parser.Cookie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;

public class Cities extends HttpServlet {
	
	public void doGet(HttpServletRequest hReq , HttpServletResponse hRes) throws ServletException, IOException {
	String cName = hReq.getParameter("city");
	
	hReq.setAttribute("city", cName);
	RequestDispatcher requestDispatcher = hReq.getRequestDispatcher("sC");
	requestDispatcher.forward(hReq, hRes);
  
	
	}
}
