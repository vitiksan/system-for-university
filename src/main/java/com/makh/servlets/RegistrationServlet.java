package com.makh.servlets;

import com.makh.beans.Administrator;
import com.makh.dao.AbstractDao;
import com.makh.dao.DaoException;
import com.makh.dao.DaoFactory;
import com.makh.mysql.MySqlDaoFactory;
import com.makh.mysql.MySqlUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;

// Created by on 14.10.2017.
@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone-number");

        Administrator administrator = new Administrator();
        administrator.setLogin(login);
        administrator.setPassword(password);
        administrator.setEmail(email);
        administrator.setPhoneNumber(phoneNumber);

        try {
            DaoFactory factory = new MySqlDaoFactory();
            MySqlUserDao userDao = new MySqlUserDao((Connection) factory.getConnection());
            AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);

            userDao.create(administrator);
            administrator = (Administrator) dao.create(administrator);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        writer.print("<p>User is created</p>");
        writer.print("<table>" +
                "        <tr>" +
                "            <td>Id:</td>" +
                        "            <td>" + administrator.getId() + "</td>" +
                        "        </tr>" +
                "        <tr>" +
                "            <td>Login:</td>" +
                "            <td>" + administrator.getLogin() + "</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>Password:</td>" +
                "            <td>" + administrator.getPassword() + "</td>" +
                "        </tr>" +
                "            <td>Email:</td>" +
                "            <td>" + administrator.getEmail() + "</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>Phone number:</td>" +
                "            <td>" + administrator.getPhoneNumber() + "</td>" +
                "        </tr>" +
                "    </table>");

        request.getRequestDispatcher("index.jsp").include(request, response);
    }
}
