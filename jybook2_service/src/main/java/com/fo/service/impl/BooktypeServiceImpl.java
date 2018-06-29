package com.fo.service.impl;

import com.fo.entity.booktype;
import com.fo.repository.BookRepository;
import com.fo.repository.BooktypeRepository;
import com.fo.service.BooktypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
@Service("BooktypeService")
public class BooktypeServiceImpl implements BooktypeService {

    @Autowired
    private BooktypeRepository booktypeRepository;

    public booktype get(Integer id){
        return booktypeRepository.get(id);
    }

    public List<booktype> findAll()
    {
        return booktypeRepository.findAll();
    }
}
