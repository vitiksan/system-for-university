package com.makh.dao;// Created by on 14.10.2017.

public interface DaoFactory<T> {

    public interface DaoCreator<T>{

        public AbstractDao create(T connection);
    }

    public T getConnection()throws DaoException;

    public AbstractDao getDao(T connection,Class daoClass)throws DaoException;
}