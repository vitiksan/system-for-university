package com.makh.servlets;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Created by on 17.09.2017.
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ServletContext context = getServletContext();

        if (login.equals(context.getInitParameter("login"))
                && password.equals(context.getInitParameter("password"))) {
            HttpSession session = request.getSession();
            session.setAttribute("login", DigestUtils.md5Hex(login));
            session.setAttribute("password", DigestUtils.md5Hex(password));
            response.sendRedirect("/ProfileServlet");
        } else {
            // тут буде логування
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login-page.jsp").forward(request, response);
    }
}
