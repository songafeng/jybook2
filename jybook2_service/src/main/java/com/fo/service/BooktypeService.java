package com.fo.service;

import com.fo.entity.booktype;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
public interface BooktypeService {

    public booktype get(Integer id);
    public List<booktype> findAll();
}
