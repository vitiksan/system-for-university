<%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 17.09.2017
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body link="#00008b" vlink="#00008b" alink="#dc143c">
<div align="center">
    <h2>
        <a style="text-decoration: none; margin: 5px" href="/LoginServlet">Login</a>
        <a style="text-decoration: none; margin: 5px" href="/LogoutServlet">Logout</a>
        <a style="text-decoration: none; margin: 5px" href="/ProfileServlet">Profile</a>
    </h2>
</div>
<hr>
<div align="center" style="border: 2px black;">
    <form action="LoginServlet" method="post">
        <label>Login: <input type="text" name="login" value="login" placeholder="Login"></label><br>
        <label>Password <input type="password" name="password" value="password" placeholder="Password"></label><br>
        <input type="submit" value="Sign in">
    </form>
</div>
</body>
</html>
