package com.gussoft.pedidoscr.service;

import java.util.List;

public interface Crud<T> {

    T Register(T t);
    T Modify(T t);
    T ReadById(Integer id);
    List<T> ToList();
    void Deleted(Integer id);

}
