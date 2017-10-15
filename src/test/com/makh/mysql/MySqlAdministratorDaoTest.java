package com.makh.mysql;

import com.makh.beans.Administrator;
import com.makh.beans.UserGroup;
import com.makh.beans.UserState;
import com.makh.dao.AbstractDao;
import com.makh.dao.DaoFactory;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

// Created by on 15.10.2017.
public class MySqlAdministratorDaoTest {
    @Test
    public void create() throws Exception {
        Administrator administrator = new Administrator();
        administrator.setLogin("atrik");
        administrator.setPassword("1234");
        administrator.setState(UserState.NEW);
        administrator.setGroup(UserGroup.ADMINISTRATOR);
        administrator.setCreated(LocalDateTime.now());
        administrator.setLastAccess(LocalDateTime.now());
        administrator.setName("vitalik");
        administrator.setSurname("makh");
        administrator.setBirthday(LocalDate.of(1997, 11, 29));
        administrator.setEmail("patrik@gmail.ua");
        administrator.setPhoneNumber("+3076593524");

        DaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);

        Administrator getAdmin = (Administrator) dao.create(administrator);

        System.out.println(getAdmin.toString());
    }

    @Test
    public void read() throws Exception {
        DaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);

        Administrator getAdmin = (Administrator) dao.read(4);

        System.out.println(getAdmin.toString());
    }

    @Test
    public void readAll() throws Exception {
        DaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);

        ArrayList<Administrator> getAdmins = dao.readAll();

        for (Administrator getAdmin : getAdmins)
            System.out.println(getAdmin.toString());
    }

    @Test
    public void update() throws Exception {
        DaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);

        Administrator getAdmin = (Administrator) dao.read(4);
        getAdmin.setPhoneNumber("+305555555555");
        dao.update(getAdmin);
    }

    @Test
    public void delete() throws Exception {
        DaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Administrator.class);

        Administrator getAdmin = (Administrator) dao.read(7);

        dao.delete(getAdmin);
    }

}