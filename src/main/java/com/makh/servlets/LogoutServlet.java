package com.makh.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

// Created by on 17.09.2017.
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        session.invalidate();
        writer.print("<html><head>" +
                "<title>Logout page</title>" +
                "</head>" +
                "<body link=\"#00008b\" vlink=\"#00008b\" alink=\"#dc143c\">" +
                "<div align=\"center\">" +
                "    <h2><a style=\"text-decoration: none; margin: 5px\" href=\"/LoginServlet\">Login</a>" +
                "    <a style=\"text-decoration: none; margin: 5px\" href=\"/LogoutServlet\">Logout</a>" +
                "    <a style=\"text-decoration: none; margin: 5px\" href=\"/ProfileServlet\">Profile</a></h2>" +
                "</div><hr>" +
                "<h1 align=\"center\">See you later</h1>" +
                "</body</html>");
    }
}
