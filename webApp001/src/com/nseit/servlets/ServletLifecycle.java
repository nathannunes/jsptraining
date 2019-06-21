
package com.nseit.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletLifecycle")
public class ServletLifecycle extends HttpServlet {
	File f;
	int hitCount;

	public ServletLifecycle() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		f = new File("D:\\Count.txt");
		FileInputStream fi = null;
		try {
			if (f.exists()) {
				fi = new FileInputStream(f);
				hitCount = fi.read();
				fi.close();
			} else
				hitCount = 0;
		} catch (IOException ie) {
			throw new ServletException("Input file corrupted.", ie);
		}

	}

	public void destroy() {
		System.out.println(" Object being undeployed from server..");
		try {
			FileOutputStream fo = new FileOutputStream(f);
			fo.write(hitCount);
			fo.close();
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet receiving subsequent requests");
		PrintWriter out = resp.getWriter();
		out.println(" Pragati Software Private Limited");
		out.println("This website is hit " + (hitCount++) + " no. of times.");

	}
}
