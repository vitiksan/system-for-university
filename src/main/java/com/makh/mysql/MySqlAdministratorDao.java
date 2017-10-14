package com.makh.mysql;// Created by on 14.10.2017.

import com.makh.beans.Administrator;
import com.makh.dao.AbstractDao;
import com.makh.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAdministratorDao extends AbstractDao<Administrator,Integer> {
    public MySqlAdministratorDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Administrator JOIN ";
    }

    @Override
    public String getSelectAllQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public ArrayList<Administrator> parsData(ResultSet rs) throws DaoException {
        return null;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Administrator obj) throws DaoException {

    }

    @Override
    public void parsInsert(PreparedStatement prSt, Administrator obj) throws DaoException {

    }
}
