package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.adminDao;
import com.project.pojo.AdminInfo;

public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginController() {
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
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			try {
				AdminInfo details = new AdminInfo(email, password);
				String result = adminDao.verifyUser(details);
				request.setAttribute("result", result);
				request.setAttribute("emailid",email);
				request.getSession().setAttribute("emailid", email);
				rd = request.getRequestDispatcher("/loginResponse.jsp");
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
