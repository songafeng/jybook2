package com.fo.repository;

import com.fo.entity.Person;
import com.fo.entity.book;
import com.fo.entity.booktype;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
public interface BookRepository extends DomainRepository<book,Integer> {

    public List<book> findByType(Integer type);
}
