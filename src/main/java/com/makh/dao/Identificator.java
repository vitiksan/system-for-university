package com.makh.dao;// Created by on 14.10.2017.

import java.io.Serializable;

public interface Identificator<PK extends Serializable> {
    int getId();
}