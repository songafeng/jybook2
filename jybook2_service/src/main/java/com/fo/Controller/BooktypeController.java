package com.fo.Controller;

import com.fo.entity.booktype;
import com.fo.service.BooktypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
@Controller
@RequestMapping("/booktype")
public class BooktypeController {

    @Resource(name = "BooktypeService")
    private BooktypeService booktypeService;

    @RequestMapping("/list")
    @ResponseBody
    public List<booktype> list()
    {
        List<booktype> list=booktypeService.findAll();

        return list;
    }
}
