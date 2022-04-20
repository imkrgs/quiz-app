<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Personal Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic"
	rel="stylesheet" type="text/css" />
<link href="//fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="//fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap"
	rel="stylesheet" />
<link
	href="//fonts.googleapis.com/css2?family=Lato:ital,wght@0,300;0,400;0,700;1,400&display=swap"
	rel="stylesheet" />
<script type="application/x-javascript">
	
      addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    
</script>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #5ff2be;
	color: white;
}

.topnav-right {
	float: right;
}
</style>
</head>
<body>
<%  String id = request.getParameter("id");
	session.setAttribute("id",id);
%>
	<div class="topnav">
		<a href="index.html">Home</a>
		<div class="topnav-right">
			 <a href="login.html">Admin</a>
		</div>
	</div>
	<div class="main-agileinfo">
		<div class="sap_tabs">
			<div id="horizontalTab">
				<ul class="resp-tabs-list">
					<li class="resp-tab-item"><span style="color: #5ff2be">Personal
							Details</span></li>
				</ul>
				<div class="clearfix"></div>
				<div class="resp-tabs-container">
					<div class="tab-1 resp-tab-content roundtrip">
						<form action="personalDetailsController" method="post">
							<div class="name">
								<h3>Full Name</h3>
								<input name="name" type="text" placeholder="Full Name" required />
							</div>
							<div class="email">
								<h3>Email Id</h3>
								<input type="text" name="email"
									pattern="^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$"
									class="city1" placeholder="Email" required autocomplete="off" />
							</div>
							<div class="aadhar">
								<h3>Aadhar Number</h3>
								<input name="aadhar" type="text" pattern="^\d{4}\d{4}\d{4}$"
									placeholder="Aadhar Number" required />
							</div>
							<div class="phone">
								<h3>Phone Number</h3>
								<input name="phone" type="text" pattern="^[6-9]\d{2}\d{3}\d{4}$"
									placeholder="Phone Number" required />
							</div>
							<div class="gender">
								<h3>Select gender</h3>

								<select name="gender" required>
									<option value="" selected>Gender</option>
									<option value="male">Male</option>
									<option value="female">Female</option>
									<option value="other">other</option>
								</select>
							</div>
							<div class="clear"></div>
							<div class="clear"></div>
							<div class="sbutton">
								<input id="login-button" type="submit" value="Procced" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-w3l">
		<!-- place for footer -->
	</div>
	<!--script for portfolio-->
	<script src="js/jquery.min.js"></script>
	<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#horizontalTab").easyResponsiveTabs({
				type : "default", //Types: default, vertical, accordion
				width : "auto", //auto or any width like 600px
				fit : true, // 100% fit in a container
			});
		});
	</script>
</body>
</html>
