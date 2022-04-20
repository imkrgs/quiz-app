package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.flightResultDao;
import com.project.pojo.BookingDetails;

public class indexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public indexController() {
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
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String date = request.getParameter("date");
			try {
	 			BookingDetails details = new BookingDetails();
				details.setDate(date);
				details.setSource(from);
				details.setDestination(to);
				List<BookingDetails> result = flightResultDao.flightSearchResult(details);
				System.out.println(result.size());
				if (result.size() > 0) {
					request.getSession().setAttribute("result", result);
					rd = getServletContext().getRequestDispatcher("/resultFlightjsp.jsp");
				}
				else {
					rd = getServletContext().getRequestDispatcher("/noResultFound.html");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
				rd = request.getRequestDispatcher("/resultFlightjsp.jsp");
				request.setAttribute("exception", ex);
			} finally {
				rd.forward(request, response);
			}
		}
	}

}
