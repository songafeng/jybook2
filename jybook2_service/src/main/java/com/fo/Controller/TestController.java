package com.fo.Controller;

import com.fo.Utils.JedisConfig;
import com.fo.entity.book;

import com.fo.service.impl.SimpleRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jdd on 2018/7/11.
 */
@Controller
@RequestMapping("/test")
public class TestController {


    @Autowired
    private SimpleRedisService simpleRedisService;

    @Autowired
    private JedisConfig jedisConfig;

    private static final String REDIS_KEY = "disconf_key";

    @RequestMapping("/list")
    @ResponseBody
    public String list()
    {
        System.out.println("host:"+jedisConfig.getHost());
        System.out.println("port:"+jedisConfig.getPort());
        System.out.println("name:"+simpleRedisService.getKey("name"));

        return "host:"+ jedisConfig.getHost() +";port:"+ jedisConfig.getPort() +"; name:"+simpleRedisService.getKey("name");
    }
}
