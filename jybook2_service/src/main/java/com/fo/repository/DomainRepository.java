package com.fo.repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jdd on 2018/6/27.
 */
public interface DomainRepository<T,PK extends Serializable>{
    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();
}