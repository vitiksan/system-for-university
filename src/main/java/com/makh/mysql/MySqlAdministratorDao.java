package com.makh.mysql;// Created by on 14.10.2017.

import com.makh.beans.Administrator;
import com.makh.dao.AbstractDao;
import com.makh.dao.DaoException;

import java.sql.*;
import java.util.ArrayList;

public class MySqlAdministratorDao extends AbstractDao<Administrator, Integer> {
    public MySqlAdministratorDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Administrators JOIN Users USING(login) WHERE id=?;";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM Administrators JOIN Users USING(login);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Administrators JOIN Users USING(login) " +
                "SET login=?,password=?,user_state=?,user_group=?,last_access=?," +
                "name=?,surname=?,birthday=?,email=?,phone_number=? WHERE id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Administrators (name, surname, birthday, email, phone_number, login) " +
                "VALUES(?,?,?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE Administrators WHERE id=?;";
    }

    @Override
    public ArrayList<Administrator> parsData(ResultSet rs) throws DaoException {
        ArrayList<Administrator> administrators = new ArrayList<>();
        try {
            while (rs.next()) {
                Administrator admin = new Administrator();

                admin.setLogin(rs.getString("login"));
                admin.setPassword(rs.getString("password"));
                admin.setState(rs.getString("user_state"));
                admin.setGroup(rs.getString("user_group"));
                admin.setCreated(rs.getTimestamp("created").toLocalDateTime());
                admin.setLastAccess(rs.getTimestamp("last_access").toLocalDateTime());
                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setSurname(rs.getString("surname"));
                admin.setBirthday(rs.getDate("birthday").toLocalDate());
                admin.setEmail(rs.getString("email"));
                admin.setPhoneNumber(rs.getString("phone_number"));

                administrators.add(admin);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        return administrators;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Administrator obj) throws DaoException {
        try {
            prSt.setString(1, obj.getLogin());
            prSt.setString(2, obj.getPassword());
            prSt.setString(3, String.valueOf(obj.getState()));
            prSt.setString(4, String.valueOf(obj.getGroup()));
            prSt.setTimestamp(5, Timestamp.valueOf(obj.getLastAccess()));
            prSt.setString(6, obj.getName());
            prSt.setString(7, obj.getSurname());
            prSt.setDate(8, Date.valueOf(obj.getBirthday()));
            prSt.setString(9, obj.getEmail());
            prSt.setString(10, obj.getPhoneNumber());
            prSt.setInt(11, obj.getId());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Administrator obj) throws DaoException {
        try {
            prSt.setString(1, obj.getLogin());
            prSt.setString(2, obj.getPassword());
            prSt.setString(3, String.valueOf(obj.getState()));
            prSt.setString(4, String.valueOf(obj.getGroup()));
            prSt.setString(5, obj.getName());
            prSt.setString(6, obj.getSurname());
            prSt.setDate(7, Date.valueOf(obj.getBirthday()));
            prSt.setString(8, obj.getEmail());
            prSt.setString(9, obj.getPhoneNumber());
            prSt.setString(10, obj.getLogin());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
