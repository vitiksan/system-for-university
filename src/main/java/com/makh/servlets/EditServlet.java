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
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

// Created by on 14.10.2017.
@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int id = (int) request.getAttribute("id");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone-number");

        Administrator administrator = new Administrator();
        administrator.setId(id);
        administrator.setLogin(login);
        administrator.setPassword(password);
        administrator.setName(name);
        administrator.setSurname(surname);
        administrator.setBirthday(birthday);
        administrator.setEmail(email);
        administrator.setPhoneNumber(phoneNumber);
        administrator.setLastAccess(LocalDateTime.now());
        try {
            DaoFactory factory = new MySqlDaoFactory();
            AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);
            dao.update(administrator);
        } catch (DaoException e) {
            //TODO log
        }

        request.getRequestDispatcher("view-users.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            DaoFactory factory = new MySqlDaoFactory();
            AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);

            int id = Integer.parseInt(request.getParameter("id"));

            Administrator administrator = (Administrator) dao.read(id);
            request.setAttribute("user", administrator);

            request.getRequestDispatcher("edit-page.jsp").forward(request, response);
        } catch (DaoException e) {
            //TODO log
        }
    }
}
