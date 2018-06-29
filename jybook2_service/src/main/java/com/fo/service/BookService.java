package com.fo.service;

import com.fo.entity.book;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
public interface BookService {

    public book get(Integer id);
    public List<book> findByType(Integer type);
}
