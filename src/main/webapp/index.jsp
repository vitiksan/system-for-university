<%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 17.09.2017
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
    <link href="bootstrap/css/bootstrap.css">
    <link href="./style.css" rel="stylesheet">
</head>
<body>
<div class="wrapper container">
    <header></header>
    <nav class="navbar navbar-default">
        <ul class="nav navbar-nav">
            <li><a style="text-decoration: none; margin: 5px" href="/LoginServlet">Sign in</a></li>
            <li><a style="text-decoration: none; margin: 5px" href="registration.html">Sign up</a></li>
            <li><a style="text-decoration: none; margin: 5px" href="view-users.jsp">View users</a></li>
        </ul>
    </nav>
    <div class="heading">
        <h1 align="center">Welcome to our site</h1>
    </div>
    <div class="row">
        <aside class="col-md-7"></aside>
        <section class="col-md-17"></section>
    </div>
</div>
<footer></footer>
</body>
</html>
