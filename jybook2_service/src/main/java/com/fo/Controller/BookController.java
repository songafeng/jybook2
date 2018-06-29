package com.fo.Controller;

import com.fo.entity.book;
import com.fo.service.BookService;
import com.fo.service.PersonService;
import com.fo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jdd on 2018/6/27.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private TestService testService;

    @Autowired
    private PersonService personService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    @ResponseBody
    public List<book> list(Integer type)
    {
//        logger.info("进入book/list方法");

        List<book> list=bookService.findByType(type);

        return list;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
//        实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "test";
    }

    @RequestMapping(value = "springtest", method = RequestMethod.GET)
    public String springTest(){
        return testService.test();
    }

    @RequestMapping(value = "savePerson", method = RequestMethod.GET)
    @ResponseBody
    public String savePerson()
    {
        personService.savePerson();
        return "success!";
    }
}
