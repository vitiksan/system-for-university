package com.makh.mysql;// Created by on 15.10.2017.

import com.makh.beans.Administrator;
import com.makh.dao.AbstractDao;
import com.makh.dao.DaoException;
import com.makh.dao.DaoFactory;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DaoFactory<Connection> {

    private static final Logger log = Logger.getLogger(MySqlDaoFactory.class);
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://servlab.mysql.ukraine.com.ua/servlab_devmax?useSSL=false";
    private static String USERNAME = "servlab_devmax";
    private static String PASSWORD = "f843xa4x";
    private Map<Class, DaoCreator> allDao;

    @Override
    public Connection getConnection() throws DaoException {
        Connection connection = null;
        try {
            Class.forName(driverName); // Завантажуємо клас драйвера
        } catch (ClassNotFoundException e) {
            log.error("Driver JDBC has NOT get");
            log.error(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("The successful connection for DB");
        } catch (SQLException e) {
            log.error("Failed connection for DB");
            log.error(e.getMessage());
        }
        return connection;
    }

    @Override
    public AbstractDao getDao(Connection connection, Class daoClass) throws DaoException {
        DaoCreator creator = allDao.get(daoClass);
        if (creator == null) {
            throw new DaoException("DAO for class " + daoClass + " not found");
        }
        return creator.create(connection);
    }


    public MySqlDaoFactory() {
        allDao = new HashMap<Class, DaoCreator>();

        allDao.put(Administrator.class, new DaoCreator<Connection>() {
            @Override
            public AbstractDao create(Connection connection) {
                return new MySqlAdministratorDao(connection);
            }
        });

    }
}