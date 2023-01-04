package com.learnservlet.web;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class FirstServlet extends HttpServlet{
	public void service(ServletRequest req, ServletResponse res) throws IOException {
		
//		res.setContentType("text/Html");
//		res.getWriter().print("Hello World Ram_K");
//		res.getWriter().print("<h1>Hello World Ram_K</h1>");
		
		String city = (String) req.getParameter("city");
		
		TimeZone tZone = TimeZone.getTimeZone(city);
		Calendar cal = Calendar.getInstance(tZone);
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		 String amPm = hour > 11 ? "PM" : "AM" ;
         hour = hour%12 ;
         int currectHour = hour == 0 ? 12 : hour ;
         res.getWriter().print("Current time at "+ city + " : " + currectHour + ":" + minute + ":" + second + "  "+amPm);
	
		
		
		
	}

}
