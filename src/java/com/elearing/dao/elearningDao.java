/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.dao;

import java.util.List;

/**
 *
 * @author Faruqul Islam
 */
public interface elearningDao<T> {

    public boolean insert(T obj);

    public boolean update(T obj);

    public boolean delete(T obj);

    public boolean search(T obj);
    
    public T getObjectById(int id);

    public T getObjectByName(T name);

    public List<T> getAllObject();
    
    public List<T> getListById(int id);
    
    public List<T> getListByName(T obj);
}
