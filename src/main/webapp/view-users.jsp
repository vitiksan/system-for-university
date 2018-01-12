<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.makh.beans.Administrator" %>
<%@ page import="com.makh.dao.DaoFactory" %>
<%@ page import="com.makh.mysql.MySqlDaoFactory" %>
<%@ page import="com.makh.dao.AbstractDao" %>
<%@ page import="com.makh.dao.DaoException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body link="#00008b" vlink="#00008b" alink="#dc143c">
<div align="center">
    <h2><a style="text-decoration: none; margin: 5px" href="/LoginServlet">Sign in</a>
        <a style="text-decoration: none; margin: 5px" href="/registration.html">Sign up</a>
        <a style="text-decoration: none; margin: 5px" href="view-users.jsp">View users</a>
    </h2>
</div>
<%
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    List<Administrator> administrators = null;
    try {
        DaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);
        administrators = dao.readAll();
    } catch (DaoException e) {
        //TODO log
    }
    writer.print("<table border=\"1\" width=\"600\" align=\"center\">");
    for (Administrator admin : administrators) {
        writer.print("<tr>" +
                "<td>" + admin.toString() + "</td>" +
                "<td><a href=\"EditServlet?id=" + admin.getId() + "\">Edit</a></td>" +
                "<td><a href=\"DeleteServlet?id=" + admin.getId() + "\">Delete</a></td></tr>");
    }
    writer.print("</table>");
%>
</body>
</html>
