package com.World_DB.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Db_Connector extends HttpServlet {
	
	static final String db_Url = "jdbc:mysql://localhost:3306/world";
	static final String userName = "ramkdatabase";
	static final String password = "DBKannan@1141";
	
	
	public void doGet(HttpServletRequest hReq , HttpServletResponse hRes) throws ServletException, IOException {
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String cName = (String) hReq.getAttribute("city");
			
			Connection connection = DriverManager.getConnection(db_Url,userName,password);
			Statement stmt  = connection.createStatement();

			String str = "select Name from city where District like "+"'"+ cName +"'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(str);
			
			ArrayList<String> citiesArrayLists = new ArrayList<String>();
			
			while(resultSet.next()) {
				citiesArrayLists.add(resultSet.getString("Name"));
			}
			
//			System.out.println(citiesArrayLists);
			
			PrintWriter out = hRes.getWriter();
			out.println(citiesArrayLists);
			
			
		}
		catch (Exception e){
			System.out.println(e);
		}

	}
	
	


	

}
