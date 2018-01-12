<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body link="#00008b" vlink="#00008b" alink="#dc143c">
<div align="center">
    <h2><a style="text-decoration: none; margin: 5px" href="/LoginServlet">Sign in</a>
        <a style="text-decoration: none; margin: 5px" href="/registration.html">Sign up</a>
        <a style="text-decoration: none; margin: 5px" href="view-users.jsp">View users</a>
    </h2>
</div>
<jsp:useBean id="admin" class="com.makh.beans.Administrator" scope="session">
    <jsp:setProperty name="admin" property="*"/>
</jsp:useBean>
<h1 align="center">Your profile</h1>
<div align="center">
    <table>
        <tr>
            <td>Login:</td>
            <td><jsp:getProperty name="admin" property="login"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><jsp:getProperty name="admin" property="email"/></td>
        </tr>
        <tr>
            <td>Phone number:</td>
            <td><jsp:getProperty name="admin" property="phoneNumber"/></td>
        </tr>
    </table>
    </div>
</body>
</html>
