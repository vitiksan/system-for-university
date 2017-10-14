package com.makh.servlets;

import com.makh.beans.Administrator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

// Created by on 14.10.2017.
@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone-number");

        Administrator administrator = new Administrator();
        administrator.setLogin(login);
        administrator.setPassword(password);
        administrator.setName(name);
        administrator.setSurname(surname);
        administrator.setBirthday(birthday);
        administrator.setEmail(email);
        administrator.setPhoneNumber(phoneNumber);

        //TODO: using dao here

        writer.print("<p>User is created</p>");
        writer.print("<table>" +
                "        <tr>" +
                "            <td>Login:</td>" +
                "            <td>"+login+"</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>Password:</td>" +
                "            <td>"+password +"</td>"+
                "        </tr>" +
                "        <tr>" +
                "            <td>Name:</td>" +
                "            <td>"+name+"</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>Surname:</td>" +
                "            <td>"+ surname +"</td>"+
                "        </tr>" +
                "        <tr>" +
                "            <td>Birthday:</td>" +
                "            <td>"+birthday.toString()+"</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>Email:</td>" +
                "            <td>"+email+"</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>Phone number:</td>" +
                "            <td>"+phoneNumber+"</td>" +
                "        </tr>" +
                "    </table>");
        
        request.getRequestDispatcher("index.jsp").include(request,response);
    }
}
