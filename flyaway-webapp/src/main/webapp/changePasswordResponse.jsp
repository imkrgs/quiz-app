<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String result = (String) request.getAttribute("result");
String emailid = (String) request.getAttribute("emailid");
if (result.equals("true")) {
	HttpSession sess = request.getSession();
	sess.setAttribute("emailid", emailid);
	out.print("adminController?jsessionid=" + sess.getId());
} else
	out.print("error");
%>