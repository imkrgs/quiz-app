<%@page import="com.project.dao.adminDao ,com.project.pojo.BookingDetails, java.util.List "%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>List of Source and Destination</title>
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="css/style.css" />
    <link
      href="//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="//fonts.googleapis.com/css?family=Montserrat:400,700"
      rel="stylesheet"
      type="text/css"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      href="//fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap"
      rel="stylesheet"
    />
    <link
      href="//fonts.googleapis.com/css2?family=Lato:ital,wght@0,300;0,400;0,700;1,400&display=swap"
      rel="stylesheet"
    />
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
    <div class="topnav">
      <a href="index.html">Home</a>
      <div class="topnav-right">
        <a class="active" href="#">Admin</a>
      </div>
    </div>
    <div class="main-agileinfo">
      <div class="sap_tabs">
        <div id="horizontalTab">
          <ul class="resp-tabs-list">
            <li class="resp-tab-item">
              <span style="color: #5ff2be">List Of Source And Destination</span>
            </li>
          </ul>
          <div class="clearfix"></div>
          <div class="resp-tabs-container">
            <div class="tab-1 resp-tab-content roundtrip">
              <table class="s-d">
                <tr>
                  <th>S.No</th>
                  <th>Source</th>
                  <th>Destination</th>
                </tr>
                <%
                List<Object []> details = adminDao.sourceAndDestinationList();
                int sno = 1 ;
                for(Object [] arr : details){
                	out.print("<tr>");
                	out.print("<td>"+sno+"</td>");
                	out.print("<td>"+arr[0]+"</td>");
                	out.print("<td>"+arr[1]+"</td>");
                	out.print("</tr>");
                	sno++;
                }
                %>
              </table>
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
      $(document).ready(function () {
        $("#horizontalTab").easyResponsiveTabs({
          type: "default", //Types: default, vertical, accordion
          width: "auto", //auto or any width like 600px
          fit: true, // 100% fit in a container
        });
      });
    </script>
  </body>
</html>
    