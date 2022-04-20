package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class flightListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public flightListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			RequestDispatcher rd = null;
			try {
				
			} catch (Exception ex) {
				ex.printStackTrace();
				rd = request.getRequestDispatcher("/loginResponse.jsp");
				request.setAttribute("exception", ex);
			} finally {
				rd.forward(request, response);
			}
		}
	}

}
