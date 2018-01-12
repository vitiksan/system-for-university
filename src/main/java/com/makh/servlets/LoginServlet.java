package com.makh.servlets;

import com.makh.beans.Administrator;
import com.makh.dao.AbstractDao;
import com.makh.dao.DaoException;
import com.makh.dao.DaoFactory;
import com.makh.mysql.MySqlDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

// Created by on 17.09.2017.
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Administrator admin = null;
        try {
            DaoFactory factory = new MySqlDaoFactory();
            AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);

            ArrayList<Administrator> administrators = dao.readAll();

            for (Administrator current : administrators) {
                if (current.getLogin().equals(login) && current.getPassword().equals(password)) {
                    admin = current;
                }
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }

        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login-page.jsp").forward(request, response);
    }
}
