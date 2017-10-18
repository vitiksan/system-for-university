package com.makh.mysql;// Created by on 18.10.2017.

import com.makh.beans.User;
import com.makh.dao.DaoException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlUserDao {
    private Connection connection;
    private static final Logger log = Logger.getLogger(MySqlUserDao.class);

    public MySqlUserDao(Connection connection) {
        this.connection=connection;
    }

    public String getCreateQuery() {
        return "INSERT INTO Users (login,password,user_state,user_group,created,last_access) " +
                "VALUES(?,?,?,?,NOW(),NOW());";
    }

    public User create(User obj) throws DaoException {
        String query = getCreateQuery();

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            parsInsert(prSt, obj);
            int count = prSt.executeUpdate();
            if (count != 1) {
                throw new DaoException("Error. Created more then 1 object " + count);
            }
        } catch (Exception e) {
            log.error("Error with create object" + e.getMessage());
            throw new DaoException(e);
        }
        return obj;
    }

    public void parsInsert(PreparedStatement prSt, User obj) throws DaoException {
        try {
            prSt.setString(1, obj.getLogin());
            prSt.setString(2, obj.getPassword());
            prSt.setString(3, String.valueOf(obj.getState()));
            prSt.setString(4, String.valueOf(obj.getGroup()));
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
