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
import java.io.PrintWriter;

// Created by on 14.10.2017.
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        DaoFactory factory = new MySqlDaoFactory();

        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);
            Administrator user = (Administrator) dao.read(id);
            dao.delete(user);
            writer.print("User " + user.getName() + " " + user.getSurname() + " deleted");
            request.getRequestDispatcher("view-users.jsp").include(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
