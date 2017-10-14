package com.makh.dao;// Created by on 14.10.2017.

import java.io.Serializable;
import java.util.ArrayList;

public interface IGenDao <T, PK extends Serializable> {

    T create(T obj) throws DaoException;

    T read(int key) throws DaoException;

    ArrayList<T> readAll() throws DaoException;

    boolean update(T obj) throws DaoException;

    boolean delete(T obj) throws DaoException;
}