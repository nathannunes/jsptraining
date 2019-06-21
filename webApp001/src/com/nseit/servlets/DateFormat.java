package com.nseit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DateFormat")
public class DateFormat extends HttpServlet {
	
       
    
    public DateFormat() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<B>STATIC DATA</B></BR>");
		out.println("<B>GOOD MORNING</B></BR>");
		
		String[] monthNames = {"Jan","Feb","March"};
		Calendar timeNow = Calendar.getInstance();
		int date = timeNow.get(Calendar.DAY_OF_MONTH);
		int month = timeNow.get(Calendar.MONTH);
		int year  = timeNow.get(Calendar.YEAR);
		
		out.println("<BR><BR><b>DYNAMIC GEN.</b><BR>");
		out.println("today is: "+date+"th"+"  "+monthNames[month]+"  "+year+"<br>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
