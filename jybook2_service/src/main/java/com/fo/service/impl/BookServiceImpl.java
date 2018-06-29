package com.fo.service.impl;

import com.fo.entity.book;
import com.fo.repository.BookRepository;
import com.fo.repository.PersonRepository;
import com.fo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public book get(Integer id) {
        return bookRepository.get(id);
    }

    public List<book> findByType(Integer type) {
        return bookRepository.findByType(type);
    }

}
