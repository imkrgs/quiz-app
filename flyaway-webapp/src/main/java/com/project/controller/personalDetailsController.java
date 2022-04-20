package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.pojo.personalDetails;

public class personalDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public personalDetailsController() {
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
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String aadhar = request.getParameter("aadhar");
			String phone = request.getParameter("phone");
			String gender = request.getParameter("gender");
			try {
				personalDetails details = new personalDetails();
				details.setName(name);
				details.setEmail(email);
				details.setAadhar(aadhar);
				details.setPhone(phone);
				details.setGender(gender);
				request.getSession().setAttribute("personalDetails", details);
				rd = getServletContext().getRequestDispatcher("/flightDetails.jsp");

			} catch (Exception ex) {
				ex.printStackTrace();
				rd = request.getRequestDispatcher("/flightDetails.jsp");
				request.setAttribute("exception", ex);
			} finally {
				rd.forward(request, response);
			}
		}
	}

}
