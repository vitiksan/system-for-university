package com.makh.dao;// Created by on 14.10.2017.

public class DaoException extends Exception{

    public DaoException() {
    }

    public DaoException(String message){
        super(message);
    }

    public DaoException(String message, Throwable cause){
        super(message,cause);
    }

    public DaoException(Throwable cause){
        super(cause);
    }

    protected DaoException(String message, Throwable cause,
                           boolean enableSuppression, boolean writableTrace){
        super(message,cause,enableSuppression,writableTrace);
    }
}