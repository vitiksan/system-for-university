<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.makh.beans.Administrator" %><%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 18.10.2017
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body link="#00008b" vlink="#00008b" alink="#dc143c">
<div align="center">
    <h2><a style="text-decoration: none; margin: 5px" href="/LoginServlet">Sign in</a>
        <a style="text-decoration: none; margin: 5px" href="/registration.html">Sign up</a>
        <a style="text-decoration: none; margin: 5px" href="view-users.jsp">View users</a>
    </h2>
</div>
<div align="center">
    <%
        PrintWriter writer = response.getWriter();
        Administrator user = (Administrator) request.getAttribute("user");
        request.setAttribute("id", user.getId());
        writer.print("<form action=\"/EditServlet\" method=\"post\">" +
                "<input type=\"text\" name=\"login\" value=\"" + user.getLogin() + "\"><br>" +
                "<input type=\"password\" name=\"password\" value=\"" + user.getPassword() + "\"><br>" +
                "<input type=\"text\" name=\"name\" value=\"" + user.getName() + "\"><br>" +
                "<input type=\"text\" name=\"surname\" value=\"" + user.getSurname() + "\"><br>" +
                "<input type=\"date\" name=\"birthday\" value=\"" + user.getBirthday().toString() + "\"><br>" +
                "<input type=\"email\" name=\"email\" value=\"" + user.getEmail() + "\"><br>" +
                "<input type=\"text\" name=\"phone-number\" value=\"" + user.getPhoneNumber() + "\"><br>" +
                "<input type=\"submit\" value=\"save\">" +
                "</form>");
    %>
</div>
</body>
</html>
