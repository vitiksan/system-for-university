<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.makh.beans.Administrator" %><%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 14.10.2017
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<%
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();

    List<Administrator> administrators = null;
    //TODO: get all from dao

    for (Administrator admin : administrators) {
        //TODO: show date in table with button edit
        //<a href="EditServlet?id="+admin.getId()+"">Edit</a>
        //<a href="DeleteServlet?id="+admin.getId()+"">Delete</a>
        //from servlet redirect to html page and return on post method servlet
        //and than return on view page
    }
%>
</body>
</html>
